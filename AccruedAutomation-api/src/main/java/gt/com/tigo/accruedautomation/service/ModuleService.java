package gt.com.tigo.accruedautomation.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import gt.com.tigo.accruedautomation.dao.*;
import gt.com.tigo.accruedautomation.dto.TigoResponseDto;
import gt.com.tigo.accruedautomation.model.AdmUsuarioEntity;
import gt.com.tigo.accruedautomation.model.MensajesEntity;
import gt.com.tigo.accruedautomation.util.exception.RequesterNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourceCreateException;
import gt.com.tigo.accruedautomation.util.exception.TigoException;
import org.postgresql.PGConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.postgresql.copy.CopyManager;

import javax.sql.DataSource;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleService.class);
    private static final  String CASH = "COPY xxx_cash_managment (batch_name, document_sequence, gjh_period_name, journal_name, xh_event_type_code, xh_ae_header_id, \n" +
            "       gjl_je_line_num, xl_currency_code, accounting_line_code, event_class_code, company, account, local, \n" +
            "\t   cc, territory, bu, category, product, project, interco, flow, future1, future2, concatenated_segments, \n" +
            "\t   entered_debits, entered_credits, entered_net, accounted_credits, accounted_debits, accounted_net, \n" +
            "\t   accounting_date, je_source, je_category, ledger_name, transaction_description, payment_currency_code, \n" +
            "\t   bank_account_name, bank_account_num, currency_code, bank_account_destination, bank_account_num_destination, \n" +
            "\t   cashflow_direction, cashflow_number, bank_account_statement_date) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String COST = "COPY xxx_cost(batch_name, document_sequence, gjh_period_name, journal_name, je_category, xh_event_type_code, xl_currency_code, \n" +
            "       company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, future2, \n" +
            "\t   concatenated_segments, entered_debits, entered_credits, entered_net, accounted_credits, accounted_debits, \n" +
            "\t   accounted_net, accounting_date, je_source, po_number, receipt_number, document_description, document_date, \n" +
            "\t   party_name, exchange_rate, source_doc_quantity, item, item_description, ledger_name, comments, po_status, \n" +
            "\t   po_currency_code, combinacion_contable_po, po_company, po_account, po_local, po_cc, po_territory, po_bu, \n" +
            "\t   po_category, po_product, po_project, po_interco, po_flow, po_future1, po_future2, fecha_modificacion_po, pr_line_num, \n" +
            "\t   uom, quantity, unit_cost, requester_email, requisition_number, description, req_status, requisition_type, creator_name, \n" +
            "\t   creator_email, transaction_date, transaction_type_name, transaction_reference, transaction_id, organization_name) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String BALANCE = "COPY xxx_balance(fct_dt, prd_cd, cmpny_cd, accntng_accnt_cd, lcl_accnt_cd, cst_cntr_cd, trrtry_cd, bsnss_unt_ebs_cd, \n" +
            "       ctgry_cd, prdct_cd, prjct_cd, intrcmpny_cd, flw_cd, ftr1_cd, ftr2_cd, bgn_blnc_amnt, prd_nt_amnt, \n" +
            "\t   clsng_blnc_amnt, crrncy_cd, ldgr_nm, ldgr_ctgry_cd, ppn_dt) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String JOURNALENTRIES = "COPY xxx_journal_entries(fct_dt, ldgr_nm, dc_sqnc_vl, ldgr_id, jrnl_nmbr, lst_updt_dt, je_ctgry, je_src, prd_dd, nm_dd, crrncy_cd, \n" +
            "       stts_dd, dt_crtd, actl_flg, blncd_je_flg, je_btch_id, pstd_dt, dscrptn_gl, rnng_ttl_dr, rnng_ttl_cr, \n" +
            "\t   rnng_ttl_accntd_dr, rnng_ttl_accntd_cr, crtd_by, lst_updtd_by, effctv_dt, je_ln_nmbr, entrd_dr, entrd_cr, \n" +
            "\t   entrd_nt, accntd_dr, accntd_cr, accntd_nt, dscrptn_gh, cmpny_dd, accnt_dd, lcl_dd, cc_dd, trrtry_dd, bu_dd, \n" +
            "\t   ctgry_dd, prdct_dd, prjct_dd, intrc_dd, flw_dd, ftr1_dd, ftr2_dd, ppn_dt, source, jrnal_std_flg) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String PAYABLESCOMP = "COPY xxx_payables_comp(company, receipt_creation_date, invoice_currency_code, amount, invoice_num, base_amount, quantity_invoiced, unit_price, \n" +
            "       accounting_date, receipt_num, line_num, po_line, shipment_line_status_code, org_name, operating_unit, po_num, \n" +
            "\t   vendor_name, vendor_site_code, line_type_lookup_code) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String PAYABLES = "COPY xxx_payables(batch_name, document_sequence, gjh_period_name, journal_name, xh_event_type_code, accounting_line_code, event_class_code, \n" +
            "       xl_currency_code, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, \n" +
            "\t   future2, concatenated_segments, aid_description, ai_invoice_num, ai_invoice_date, ai_invoice_amount, vendor_name, \n" +
            "\t   entered_debits, entered_credits, entered_net, accounted_credits, accounted_debits, accounted_net, accounting_date, \n" +
            "\t   usuario_registro_fact, je_source, je_category, ledger_name, po_number, po_comments, po_status, po_currency_code, \n" +
            "\t   po_combinacion_contable, po_company, po_account, po_local, po_cc, po_territory, po_bu, po_category, po_product, \n" +
            "\t   po_project, po_interco, po_flow, po_future1, po_future2, fecha_modificacion_po, invoice_type_lookup_code) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String RECEIVABLES = "COPY xxx_receivables(batch_name, document_sequence, gjh_period_name, journal_name, xh_event_type_code, xl_currency_code, accounting_line_code, \n" +
            "       event_class_code, company, account, local, cc, territory, bu, category, product, project, interco, flow, future1, \n" +
            "\t   future2, concatenated_segments, entered_debits, entered_credits, entered_net, accounted_credits, accounted_debits, \n" +
            "\t   accounted_net, accounting_date, je_source, je_category, ledger_name, receipt_number, receipt_date, adjustment_document_number, \n" +
            "\t   deposit_date, type, status, currency_code, operating_unit, receipt_method, bank_account, bank_name, bank_branch_name, \n" +
            "\t   legal_entity, created_by, email_created, last_update_by, email_updated) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String INTEGRACION = "COPY xxx_accrued_historico(llave, modulo, compania, cuenta, local, flujo, cc, proyecto, po, recepcion, linea, num_documento, proveedor, \n" +
            "       concepto, moneda, monto, monto_gtq, tc_historico, tc_cierre, revaluacion, monto_revaluado, antiguedad, status, \n" +
            "\t   cambiar_a_estado, justificacion_provision, adjuntar_archivo, fecha_recepcion, nombre_requester, requester_email, \n" +
            "\t   nombre_creator, creator_email, nombre_jefe_owner, jefe_de_owner, antiguedad_periodo, origen, cargo, abono, kpi, \n" +
            "\t   fecha_integracion, status_integracion, mayor_1_anio) FROM STDIN WITH (FORMAT CSV, ENCODING 'UTF8', DELIMITER ',', HEADER true)";

    private static final  String WIN1252 = "windows-1252";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private XxxCashManagmentRepository xxxCashManagmentRepository;

    @Autowired
    private XxxBalanceRepository xxxBalanceRepository;

    @Autowired
    private XxxCostRepository xxxCostRepository;

    @Autowired
    private XxxJournalEntriesRepository xxxJournalEntriesRepository;

    @Autowired
    private XxxPayablesCompRepository xxxPayablesCompRepository;

    @Autowired
    private XxxPayablesRepository xxxPayablesRepository;

    @Autowired
    private XxxReceivablesRepository xxxReceivablesRepository;

    @Autowired
    private XxxAccruedHistoricoRepository xxxAccruedHistoricoRepository;

    @Value("${spring.datasource.application.jndi-name}")
    private String applicationJndi;

    public DataSource applicationDataSource() {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(this.applicationJndi);
    }

    public TigoResponseDto processCashManagement(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processCashManagement(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();


        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)) {
            int lineCount = 0;


            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxCashManagmentRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,44, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(CASH, is);
                sb.setLength(0);

            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"CASH");

            sendMessage("Archivo Cash Management cargado",
                    String.format("El archivo Cash Management %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | CsvException | SQLException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Cash Management %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Cash Management.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processCostManagement(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processCostManagement(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();

        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;


            CopyManager copyManager = getCustomConnection().getCopyAPI();


            StringBuilder sb;
            xxxCostRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {

                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,73, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(COST, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"COST");

            sendMessage("Archivo Cost Management cargado",
                    String.format("El archivo Cost Management %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Cost Management %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Cost Management.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processReceivables(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processReceivables(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();

        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;



            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxReceivablesRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,49, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(RECEIVABLES, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"RECEIVABLES");

            sendMessage("Archivo Receivables cargado",
                    String.format("El archivo Receivables %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Receivables %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Receivables.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processJournalEntries(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processJournalEntries(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();

        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;

            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxJournalEntriesRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,49, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(JOURNALENTRIES, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"JOURNAL");

            sendMessage("Archivo Journal Entries cargado",
                    String.format("El archivo Journal Entries %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Journal Entries %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Journal Entries.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processPayables(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processPayables(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();


        try (Reader isreader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), WIN1252))){

            CopyManager copyManager = getCustomConnection().getCopyAPI();

            xxxPayablesRepository.deleteAllInBatch();

                copyManager.copyIn(PAYABLES, isreader);

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"PAYABLES");

            sendMessage("Archivo Payables cargado",
                    String.format("El archivo Payables %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), result),
                    requesterId, requester);
        } catch (IOException | SQLException  ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Payables %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Payables.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processPayablesComp(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processPayablesComp(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();


        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;


            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxPayablesCompRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,19, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(PAYABLESCOMP, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"PAYABLESCOMP");

            sendMessage("Archivo Payables Comp cargado",
                    String.format("El archivo Payables Comp %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Payables Comp %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Payables Comp.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processBalance(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processBalance(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();


        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;


            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxBalanceRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,22, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(BALANCE, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"BALANCE");

            sendMessage("Archivo Balance cargado",
                    String.format("El archivo Balance %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                    requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Balance %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Balance.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }

    public TigoResponseDto processInitialIntegration(MultipartFile multipartFile, Long requesterId) throws TigoException {
        LOGGER.debug(String.format("@%s::processInitialIntegration(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();


        try (Reader isreader = new InputStreamReader(multipartFile.getInputStream(),WIN1252)){
            int lineCount = 0;

            CopyManager copyManager = getCustomConnection().getCopyAPI();

            StringBuilder sb;
            xxxAccruedHistoricoRepository.deleteAllInBatch();
            try (CSVReader reader = new CSVReader(isreader)) {
                List<String[]> r = reader.readAll();
                lineCount = (int) reader.getLinesRead();
                sb = fileContent(r,41, ",");
                InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                copyManager.copyIn(INTEGRACION, is);
                sb.setLength(0);
            }

            int result = this.xxxBalanceRepository.ejecutarCargaManual(requester.getCorreoElectronico(),"INTEGRACION");
            sendMessage("Archivo Integración Inicial cargado",
                        String.format("El archivo Integración Inicial %s ha sido cargado al sistema. Se han procesado %d líneas en total.", multipartFile.getOriginalFilename(), lineCount),
                        requesterId, requester);
        } catch (IOException | SQLException | CsvException ex) {
            LOGGER.error(ex.getMessage());
            sendMessage(String.format("Error al procesar archivo Integración Inicial %s.", multipartFile.getOriginalFilename()), ex.getMessage(), requesterId, requester);
            throw new TigoException("Error al procesar archivo Integración Inicial.");
        }

        return new TigoResponseDto(HttpStatus.OK, "");
    }



    StringBuilder fileContent(List<String[]> r, Integer cantidad, String separador) {
        StringBuilder sb = new StringBuilder();
        for (String[] line : r)
        {
            for (int i = 0; i < cantidad - 1; i++) {
                sb.append(line[i].replace(",","").replace("\n","").replace("\r","").replace("\"", "")).append(separador);
            }
            sb.append(line[cantidad-1].replace(",","").replace("\n","").replace("\r",""));
            sb.append("\n");
        }
        return sb;
    }

    String sendMessage(String mensaje, String comentarios, Long requesterId, AdmUsuarioEntity requester) throws RequesterNotFoundException, ResourceCreateException {
        try {
            MensajesEntity message = new MensajesEntity();
            message.setMensaje(mensaje);
            message.setComentarios(comentarios);
            message.setUsuario(requester);
            this.messageService.create(message, requesterId);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return null;
    }

    PGConnection getCustomConnection(){
        PGConnection pgConn = null;
        try {
            DataSource ds = applicationDataSource();
            pgConn = (PGConnection) ds.getConnection();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            try {
                // Do nothing because this is for close conn.
                if (pgConn != null) applicationDataSource().getConnection().close();
            } catch (Exception ex) {
                LOGGER.warn(ex.getMessage());
            }
        }
        return pgConn;
    }



}
