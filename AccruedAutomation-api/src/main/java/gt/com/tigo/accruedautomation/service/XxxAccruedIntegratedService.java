package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.AccruedIntegratedRepository;
import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.UserRepository;
import gt.com.tigo.accruedautomation.dao.XxxAccruedIntegratedRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.*;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.Functions.getCellValueAsDouble;
import static gt.com.tigo.accruedautomation.util.Functions.getCellValueAsString;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getValueAsString;

@Service
public class XxxAccruedIntegratedService extends AbstractService<XxxAccruedIntegratedEntity, XxxAccruedIntegratedRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxxAccruedIntegratedService.class);
    public static final String MODULO = "modulo";
    public static final String LLAVE = "LLAVE";
    public static final String MODULO1 = "MÓDULO";
    public static final String COMPANIA = "COMPAÑÍA";
    public static final String CUENTA = "CUENTA";
    public static final String LOCAL = "LOCAL";
    public static final String FLUJO = "FLUJO";
    public static final String PROYECTO = "PROYECTO";
    public static final String RECEPCION = "RECEPCIÓN";
    public static final String LINEA = "LÍNEA";
    public static final String NUMERO_DOCUMENTO = "NÚMERO DOCUMENTO";
    public static final String PROVEEDOR = "PROVEEDOR";
    public static final String CONCEPTO = "CONCEPTO";
    public static final String MONEDA = "MONEDA";
    public static final String MONTO = "MONTO";
    public static final String MONTO_GTQ = "MONTO GTQ";
    public static final String TASA_CAMBIO_HISTORICO = "TASA CAMBIO HISTÓRICO";
    public static final String TASA_CAMBIO_CIERRE = "TASA CAMBIO CIERRE";
    public static final String REVALUACION = "REVALUACIÓN";
    public static final String MONTO_REVALUADO = "MONTO REVALUADO";
    public static final String ANTIGUEDAD = "ANTIGÜEDAD";
    public static final String ESTADO = "ESTADO";
    public static final String CAMBIAR_A_ESTADO = "CAMBIAR A ESTADO";
    public static final String JUSTIFICACION_PROVISION = "JUSTIFICACIÓN PROVISIÓN";
    public static final String ADJUNTAR_ARCHIVO = "ADJUNTAR ARCHIVO";
    public static final String FECHA_RECEPCION = "FECHA RECEPCIÓN";
    public static final String NOMBRE_SOLICITANTE = "NOMBRE SOLICITANTE";
    public static final String CORREO_SOLICITANTE = "CORREO SOLICITANTE";
    public static final String NOMBRE_CREADOR = "NOMBRE CREADOR";
    public static final String CORREO_CREADOR = "CORREO CREADOR";
    public static final String NOMBRE_JEFE_SOLICITANTE = "NOMBRE JEFE SOLICITANTE";
    public static final String JEFE_DE_SOLICITANTE = "JEFE DE SOLICITANTE";
    public static final String ANTIGUEDAD_PERIODO = "ANTIGÜEDAD PERÍODO";
    public static final String ORIGEN = "ORIGEN";
    public static final String CARGO = "CARGO";
    public static final String ABONO = "ABONO";
    public static final String FECHA_INTEGRACION = "FECHA INTEGRACIÓN";
    public static final String ESTADO_INTEGRACION = "ESTADO INTEGRACIÓN";
    public static final String MAYOR_1_ANIO = "UMBRAL";
    public static final String COMENTARIO = "COMENTARIO";
    public static final String INTERNAL_ID = "internalId";

    @Autowired
    private AccruedIntegratedRepository accruedIntegratedRepository;

    @Autowired
    private UserRepository userRepository1;

    @Autowired
    private ApplicationParameterRepository applicationParameterRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification moduloSpec = SpecFactory.<XxxAccruedIntegratedEntity>getLikeSpecification(MODULO, getValueAsString(filtersInfo, MODULO));
            Specification cuentaSpec = SpecFactory.<XxxAccruedIntegratedEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification poSpec = SpecFactory.<XxxAccruedIntegratedEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification monedaSpec = SpecFactory.<XxxAccruedIntegratedEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(moduloSpec)
                    .and(cuentaSpec)
                    .and(poSpec)
                    .and(monedaSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public XxxAccruedIntegratedEntity create(XxxAccruedIntegratedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public XxxAccruedIntegratedEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxxAccruedIntegratedEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxxAccruedIntegratedEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxxAccruedIntegratedEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, MODULO);
    }

    @Override
    public XxxAccruedIntegratedEntity update(XxxAccruedIntegratedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "IntegracionDetalle.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO1,
                    COMPANIA,
                    CUENTA,
                    LOCAL,
                    FLUJO,
                    "CC",
                    PROYECTO,
                    "PO",
                    RECEPCION,
                    LINEA,
                    NUMERO_DOCUMENTO,
                    PROVEEDOR,
                    CONCEPTO,
                    MONEDA,
                    MONTO,
                    MONTO_GTQ,
                    TASA_CAMBIO_HISTORICO,
                    TASA_CAMBIO_CIERRE,
                    REVALUACION,
                    MONTO_REVALUADO,
                    ANTIGUEDAD,
                    ESTADO,
                    CAMBIAR_A_ESTADO,
                    JUSTIFICACION_PROVISION,
                    ADJUNTAR_ARCHIVO,
                    FECHA_RECEPCION,
                    NOMBRE_SOLICITANTE,
                    CORREO_SOLICITANTE,
                    NOMBRE_CREADOR,
                    CORREO_CREADOR,
                    NOMBRE_JEFE_SOLICITANTE,
                    JEFE_DE_SOLICITANTE,
                    ANTIGUEDAD_PERIODO,
                    ORIGEN,
                    CARGO,
                    ABONO,
                    "KPI",
                    FECHA_INTEGRACION,
                    ESTADO_INTEGRACION,
                    MAYOR_1_ANIO,
                    COMENTARIO
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxxAccruedIntegratedEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedIntegratedEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getLlave());
                    row.add(item.getModulo());
                    row.add(item.getCompania());
                    row.add(item.getCuenta());
                    row.add(item.getLocal());
                    row.add(item.getFlujo());
                    row.add(item.getCc());
                    row.add(item.getProyecto());
                    row.add(item.getPo());
                    row.add(item.getRecepcion());
                    row.add(item.getLinea());
                    row.add(item.getNumDocumento());
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getTcHistorico()));
                    row.add(String.valueOf(item.getTcCierre()));
                    row.add(item.getRevaluacion());
                    row.add(String.valueOf(item.getMontoRevaluado()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getStatus());
                    row.add(item.getCambiarAEstado());
                    row.add(item.getJustificacionProvision());
                    row.add(item.getAdjuntarArchivo());
                    row.add(item.getFechaRecepcion());
                    row.add(item.getNombreRequester());
                    row.add(item.getRequesterEmail());
                    row.add(item.getNombreCreator());
                    row.add(item.getCreatorEmail());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getJefeDeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getCargo());
                    row.add(item.getAbono());
                    row.add(item.getKpi());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(item.getStatusIntegracion());
                    row.add(item.getMayor1Anio());
                    row.add(item.getComentarios());

                    rows.add(row.toArray());
                }

                return rows;
            });

            return new ModelAndView(new XlsxViewBuilder(), model);
        } catch (InvalidFilterException ex) {
            throw ex;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "IntegracionDetalle.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO1,
                    COMPANIA,
                    CUENTA,
                    LOCAL,
                    FLUJO,
                    "CC",
                    PROYECTO,
                    "PO",
                    RECEPCION,
                    LINEA,
                    NUMERO_DOCUMENTO,
                    PROVEEDOR,
                    CONCEPTO,
                    MONEDA,
                    MONTO,
                    MONTO_GTQ,
                    TASA_CAMBIO_HISTORICO,
                    TASA_CAMBIO_CIERRE,
                    REVALUACION,
                    MONTO_REVALUADO,
                    ANTIGUEDAD,
                    ESTADO,
                    CAMBIAR_A_ESTADO,
                    JUSTIFICACION_PROVISION,
                    ADJUNTAR_ARCHIVO,
                    FECHA_RECEPCION,
                    NOMBRE_SOLICITANTE,
                    CORREO_SOLICITANTE,
                    NOMBRE_CREADOR,
                    CORREO_CREADOR,
                    NOMBRE_JEFE_SOLICITANTE,
                    JEFE_DE_SOLICITANTE,
                    ANTIGUEDAD_PERIODO,
                    ORIGEN,
                    CARGO,
                    ABONO,
                    "KPI",
                    FECHA_INTEGRACION,
                    ESTADO_INTEGRACION,
                    MAYOR_1_ANIO,
                    COMENTARIO
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxxAccruedIntegratedEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedIntegratedEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getLlave());
                    row.add(item.getModulo());
                    row.add(item.getCompania());
                    row.add(item.getCuenta());
                    row.add(item.getLocal());
                    row.add(item.getFlujo());
                    row.add(item.getCc());
                    row.add(item.getProyecto());
                    row.add(item.getPo());
                    row.add(item.getRecepcion());
                    row.add(item.getLinea());
                    row.add(item.getNumDocumento());
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getTcHistorico()));
                    row.add(String.valueOf(item.getTcCierre()));
                    row.add(item.getRevaluacion());
                    row.add(String.valueOf(item.getMontoRevaluado()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getStatus());
                    row.add(item.getCambiarAEstado());
                    row.add(item.getJustificacionProvision());
                    row.add(item.getAdjuntarArchivo());
                    row.add(item.getFechaRecepcion());
                    row.add(item.getNombreRequester());
                    row.add(item.getRequesterEmail());
                    row.add(item.getNombreCreator());
                    row.add(item.getCreatorEmail());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getJefeDeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getCargo());
                    row.add(item.getAbono());
                    row.add(item.getKpi());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(item.getStatusIntegracion());
                    row.add(item.getMayor1Anio());
                    row.add(item.getComentarios());

                    rows.add(row);
                }

                return rows;
            });

            return new CsvViewBuilder().buildCsvFile(model);
        } catch (InvalidFilterException ex) {
            throw ex;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }

    public boolean importXlsx(MultipartFile multipartFile, Long requesterId) throws ResourceNotFoundException, ResourceImportException, ResourceConversionException, RequesterNotFoundException {
        LOGGER.debug(String.format("@%s::importXlsx(%s, %d)", this.getClass().getName(), multipartFile.getOriginalFilename(), requesterId));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository1.findById(requesterId);

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();

        int lineNumber = 0;
        int totalRows = 0;

        int batchSize;

        try {
            AdmParametroEntity parameter = this.applicationParameterRepository.findByCodigo("TEMPLATE_BATCH_SIZE");

            batchSize = Integer.parseInt(parameter.getValor());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            batchSize = 100;
        }

        try {

            this.repository.deleteAllInBatch();

            InputStream is = new ByteArrayInputStream(multipartFile.getBytes());

            Workbook workbook = WorkbookFactory.create(is);

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();

            Map<Long, AccruedIntegratedEntity> accruedIntegratedEntitiesMap = new HashMap<>();
            List<XxxAccruedIntegratedEntity> xxxAccruedIntegratedEntitiesFromXlsx = new LinkedList<>();




            for (lineNumber = 1; lineNumber < rowCount; lineNumber += batchSize) {
                List<Long> ids = new LinkedList<>();

                for (int i = lineNumber; i < rowCount && i < lineNumber + batchSize; i++) {
                    String cell0 = getCellValueAsString(sheet.getRow(i).getCell(0)); // id
                    String cell1 = getCellValueAsString(sheet.getRow(i).getCell(1)); // key
                    String cell2 = getCellValueAsString(sheet.getRow(i).getCell(2)); // module
                    String cell3 = getCellValueAsString(sheet.getRow(i).getCell(3)); // company

                    if (cell3 == null) {
                        rowCount = i;
                        break;
                    }

                    String cell4 = getCellValueAsString(sheet.getRow(i).getCell(4)); // account
                    String cell5 = getCellValueAsString(sheet.getRow(i).getCell(5)); // local
                    String cell6 = getCellValueAsString(sheet.getRow(i).getCell(6)); // flow
                    String cell7 = getCellValueAsString(sheet.getRow(i).getCell(7)); // cost center
                    String cell8 = getCellValueAsString(sheet.getRow(i).getCell(8)); // project
                    String cell9 = getCellValueAsString(sheet.getRow(i).getCell(9)); // purchase order
                    String cell10 = getCellValueAsString(sheet.getRow(i).getCell(10)); // reception
                    String cell11 = getCellValueAsString(sheet.getRow(i).getCell(11)); // line
                    String cell12 = getCellValueAsString(sheet.getRow(i).getCell(12)); // document number
                    String cell13 = getCellValueAsString(sheet.getRow(i).getCell(13)); // provider

                    String concept = getCellValueAsString(sheet.getRow(i).getCell(14));

                    String cell14 = concept.substring(0,concept.length() < 250 ? concept.length() : 250); // concept
                    String cell15 = getCellValueAsString(sheet.getRow(i).getCell(15)); // currency
                    Double cell16 = getCellValueAsDouble(sheet.getRow(i).getCell(16)); // ammount
                    Double cell17 = getCellValueAsDouble(sheet.getRow(i).getCell(17)); // ammount gtq
                    Double cell18 = getCellValueAsDouble(sheet.getRow(i).getCell(18)); // exchange rate history
                    Double cell19 = getCellValueAsDouble(sheet.getRow(i).getCell(19)); // exchange rate current
                    String cell20 = getCellValueAsString(sheet.getRow(i).getCell(20)); // re-evaluation
                    Double cell21 = getCellValueAsDouble(sheet.getRow(i).getCell(21)); // re-evaluated ammount
                    Integer cell22 = Math.toIntExact(Math.round(getCellValueAsDouble(sheet.getRow(i).getCell(22)))); // antiquity
                    String cell23 = getCellValueAsString(sheet.getRow(i).getCell(23)); // status
                    String cell24 = getCellValueAsString(sheet.getRow(i).getCell(24)); // change to status
                    String cell25 = getCellValueAsString(sheet.getRow(i).getCell(25)); // justification
                    String cell26 = getCellValueAsString(sheet.getRow(i).getCell(26)); // attach file
                    String cell27 = getCellValueAsString(sheet.getRow(i).getCell(27)); // reception date
                    String cell28 = getCellValueAsString(sheet.getRow(i).getCell(28)); // requester name
                    String cell29 = getCellValueAsString(sheet.getRow(i).getCell(29)); // requester email
                    String cell30 = getCellValueAsString(sheet.getRow(i).getCell(30)); // creator name
                    String cell31 = getCellValueAsString(sheet.getRow(i).getCell(31)); // creator email
                    String cell32 = getCellValueAsString(sheet.getRow(i).getCell(32)); // owner superior name
                    String cell33 = getCellValueAsString(sheet.getRow(i).getCell(33)); // owner superior
                    String cell34 = getCellValueAsString(sheet.getRow(i).getCell(34)); // period antiquity
                    String cell35 = getCellValueAsString(sheet.getRow(i).getCell(35)); // source
                    String cell36 = getCellValueAsString(sheet.getRow(i).getCell(36)); // charge
                    String cell37 = getCellValueAsString(sheet.getRow(i).getCell(37)); // payment
                    String cell38 = getCellValueAsString(sheet.getRow(i).getCell(38)); // kpi
                    String cell39 = getCellValueAsString(sheet.getRow(i).getCell(39)); // integration date
                    String cell40 = getCellValueAsString(sheet.getRow(i).getCell(40)); // integration status
                    String cell41 = getCellValueAsString(sheet.getRow(i).getCell(41)); // mayor 1 anio

                    XxxAccruedIntegratedEntity xxxEntity = new XxxAccruedIntegratedEntity();

                    if (cell0 != null) {
                        xxxEntity.setId(Long.parseLong(cell0));
                        ids.add(Long.parseLong(cell0));
                    }

                    DateFormat dateFormatter = new SimpleDateFormat("DD/MM/yyyy");

                    xxxEntity.setLlave(cell1);
                    xxxEntity.setModulo(cell2);
                    xxxEntity.setCompania(cell3);
                    xxxEntity.setCuenta(cell4);
                    xxxEntity.setLocal(cell5);
                    xxxEntity.setFlujo(cell6);
                    xxxEntity.setCc(cell7);
                    xxxEntity.setProyecto(cell8);
                    xxxEntity.setPo(cell9);
                    xxxEntity.setRecepcion(cell10);
                    xxxEntity.setLinea(cell11);
                    xxxEntity.setNumDocumento(cell12);
                    xxxEntity.setProveedor(cell13);
                    xxxEntity.setConcepto(cell14);
                    xxxEntity.setMoneda(cell15);
                    xxxEntity.setMonto(cell16);
                    xxxEntity.setMontoGtq(cell17);
                    xxxEntity.setTcHistorico(cell18);
                    xxxEntity.setTcCierre(cell19);
                    xxxEntity.setRevaluacion(cell20);
                    xxxEntity.setMontoRevaluado(cell21);
                    xxxEntity.setAntiguedad(cell22);
                    xxxEntity.setStatus(cell23);
                    xxxEntity.setCambiarAEstado(cell24);
                    xxxEntity.setJustificacionProvision(cell25);
                    xxxEntity.setAdjuntarArchivo(cell26);
                    xxxEntity.setFechaRecepcion(cell27);
                    xxxEntity.setNombreRequester(cell28);
                    xxxEntity.setRequesterEmail(cell29);
                    xxxEntity.setNombreCreator(cell30);
                    xxxEntity.setCreatorEmail(cell31);
                    xxxEntity.setNombreJefeOwner(cell32);
                    xxxEntity.setJefeDeOwner(cell33);
                    xxxEntity.setAntiguedadPeriodo(cell34);
                    xxxEntity.setOrigen(cell35);
                    xxxEntity.setCargo(cell36);
                    xxxEntity.setAbono(cell37);
                    xxxEntity.setKpi(cell38);
                    xxxEntity.setFechaIntegracion(new Date(dateFormatter.parse(cell39).getTime()));
                    xxxEntity.setStatusIntegracion(cell40);
                    xxxEntity.setMayor1Anio(cell41);
                    xxxEntity.setComentarios(String.format("Registro cargado por el usuario %s", requester.getUsuario()));

                    xxxAccruedIntegratedEntitiesFromXlsx.add(xxxEntity);
                }



                List<AccruedIntegratedEntity> accruedIntegratedEntitiesResultList = this.accruedIntegratedRepository.findAllById(ids);

                accruedIntegratedEntitiesMap.clear();

                for (AccruedIntegratedEntity accruedIntegratedEntity : accruedIntegratedEntitiesResultList) {
                    accruedIntegratedEntitiesMap.put(accruedIntegratedEntity.getId(), accruedIntegratedEntity);
                }



                for (XxxAccruedIntegratedEntity xxxAccruedIntegratedEntityFromXlsx : xxxAccruedIntegratedEntitiesFromXlsx) {
                    if (xxxAccruedIntegratedEntityFromXlsx.getId() == null) {
                        continue;
                    }

                    AccruedIntegratedEntity accruedIntegratedEntity = accruedIntegratedEntitiesMap.get(xxxAccruedIntegratedEntityFromXlsx.getId());

                    if (accruedIntegratedEntity == null) {

                        continue;
                    }

                    xxxAccruedIntegratedEntityFromXlsx.setLlave(accruedIntegratedEntity.getLlave());
                    xxxAccruedIntegratedEntityFromXlsx.setModulo(accruedIntegratedEntity.getModulo());
                    xxxAccruedIntegratedEntityFromXlsx.setCompania(accruedIntegratedEntity.getCompania());
                    xxxAccruedIntegratedEntityFromXlsx.setTcHistorico(accruedIntegratedEntity.getTcHistorico());
                    xxxAccruedIntegratedEntityFromXlsx.setTcCierre(accruedIntegratedEntity.getTcCierre());
                    xxxAccruedIntegratedEntityFromXlsx.setRevaluacion(accruedIntegratedEntity.getRevaluacion());
                    xxxAccruedIntegratedEntityFromXlsx.setMontoRevaluado(accruedIntegratedEntity.getMontoRevaluado());
                    xxxAccruedIntegratedEntityFromXlsx.setAntiguedad(accruedIntegratedEntity.getAntiguedad());
                    xxxAccruedIntegratedEntityFromXlsx.setStatus(accruedIntegratedEntity.getStatus());
                    xxxAccruedIntegratedEntityFromXlsx.setCambiarAEstado(accruedIntegratedEntity.getCambiarAEstado());
                    xxxAccruedIntegratedEntityFromXlsx.setJustificacionProvision(accruedIntegratedEntity.getJustificacionProvision());
                    xxxAccruedIntegratedEntityFromXlsx.setAdjuntarArchivo(accruedIntegratedEntity.getAdjuntarArchivo());
                    xxxAccruedIntegratedEntityFromXlsx.setFechaRecepcion(accruedIntegratedEntity.getFechaRecepcion());
                    xxxAccruedIntegratedEntityFromXlsx.setNombreRequester(accruedIntegratedEntity.getNombreRequester());
                    xxxAccruedIntegratedEntityFromXlsx.setNombreCreator(accruedIntegratedEntity.getNombreCreator());
                    xxxAccruedIntegratedEntityFromXlsx.setNombreJefeOwner(accruedIntegratedEntity.getNombreJefeOwner());
                    xxxAccruedIntegratedEntityFromXlsx.setAntiguedadPeriodo(accruedIntegratedEntity.getAntiguedadPeriodo());
                    xxxAccruedIntegratedEntityFromXlsx.setOrigen(accruedIntegratedEntity.getOrigen());
                    xxxAccruedIntegratedEntityFromXlsx.setFechaIntegracion(accruedIntegratedEntity.getFechaIntegracion());
                    xxxAccruedIntegratedEntityFromXlsx.setStatusIntegracion(accruedIntegratedEntity.getStatusIntegracion());
                    xxxAccruedIntegratedEntityFromXlsx.setMayor1Anio(accruedIntegratedEntity.getMayor1Anio());
                }

                totalRows += xxxAccruedIntegratedEntitiesFromXlsx.size();


                this.repository.saveAll(xxxAccruedIntegratedEntitiesFromXlsx);

                xxxAccruedIntegratedEntitiesFromXlsx.clear();
            }
        } catch (IOException | IllegalStateException | ParseException ex) {
            LOGGER.error("{} - Processing line number {}", ex.getMessage(), lineNumber);

            throw new ResourceImportException();
        } catch (Exception ex2) {
            LOGGER.error("{} - Processing line number {}", ex2.getMessage(), lineNumber);

            throw ex2;
        }

        return true;
    }

    public ModelAndView exportTemplate(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportTemplate(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "PlantillaIntegracion.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO1,
                    COMPANIA,
                    CUENTA,
                    LOCAL,
                    FLUJO,
                    "CC",
                    PROYECTO,
                    "PO",
                    RECEPCION,
                    LINEA,
                    NUMERO_DOCUMENTO,
                    PROVEEDOR,
                    CONCEPTO,
                    MONEDA,
                    MONTO,
                    MONTO_GTQ,
                    TASA_CAMBIO_HISTORICO,
                    TASA_CAMBIO_CIERRE,
                    REVALUACION,
                    MONTO_REVALUADO,
                    ANTIGUEDAD,
                    ESTADO,
                    CAMBIAR_A_ESTADO,
                    JUSTIFICACION_PROVISION,
                    ADJUNTAR_ARCHIVO,
                    FECHA_RECEPCION,
                    NOMBRE_SOLICITANTE,
                    CORREO_SOLICITANTE,
                    NOMBRE_CREADOR,
                    CORREO_CREADOR,
                    NOMBRE_JEFE_SOLICITANTE,
                    JEFE_DE_SOLICITANTE,
                    ANTIGUEDAD_PERIODO,
                    ORIGEN,
                    CARGO,
                    ABONO,
                    "KPI",
                    FECHA_INTEGRACION,
                    ESTADO_INTEGRACION,
                    MAYOR_1_ANIO,
                    COMENTARIO
            ));
            model.put(XlsxViewBuilder.KEY_HIGHLIGHT_COLUMNS, Arrays.asList(
                    CUENTA,
                    LOCAL,
                    FLUJO,
                    "CC",
                    PROYECTO,
                    "PO",
                    RECEPCION,
                    LINEA,
                    NUMERO_DOCUMENTO,
                    PROVEEDOR,
                    CONCEPTO,
                    MONTO,
                    MONTO_GTQ,
                    CORREO_SOLICITANTE,
                    CORREO_CREADOR,
                    JEFE_DE_SOLICITANTE,
                    CARGO,
                    ABONO,
                    "KPI"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxxAccruedIntegratedEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedIntegratedEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(item.getId() == null ? "" : String.valueOf(item.getId()));
                    row.add(item.getLlave());
                    row.add(item.getModulo());
                    row.add(item.getCompania());
                    row.add(item.getCuenta());
                    row.add(item.getLocal());
                    row.add(item.getFlujo());
                    row.add(item.getCc());
                    row.add(item.getProyecto());
                    row.add(item.getPo());
                    row.add(item.getRecepcion());
                    row.add(item.getLinea());
                    row.add(item.getNumDocumento());
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getTcHistorico()));
                    row.add(String.valueOf(item.getTcCierre()));
                    row.add(item.getRevaluacion());
                    row.add(String.valueOf(item.getMontoRevaluado()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getStatus());
                    row.add(item.getCambiarAEstado());
                    row.add(item.getJustificacionProvision());
                    row.add(item.getAdjuntarArchivo());
                    row.add(item.getFechaRecepcion());
                    row.add(item.getNombreRequester());
                    row.add(item.getRequesterEmail());
                    row.add(item.getNombreCreator());
                    row.add(item.getCreatorEmail());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getJefeDeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getCargo());
                    row.add(item.getAbono());
                    row.add(item.getKpi());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(item.getStatusIntegracion());
                    row.add(item.getMayor1Anio());
                    row.add(item.getComentarios());

                    rows.add(row.toArray());
                }

                return rows;
            });

            return new ModelAndView(new XlsxViewBuilder(), model);
        } catch (InvalidFilterException ex) {
            throw ex;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }

    public boolean validar() throws TigoException {
        LOGGER.debug(String.format("@%s::validar()", this.getClass().getName()));

        try {
            int result = this.repository.validarIntegracion();

            return result == 0;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new TigoException("Error al validar Accrued Integrado.");
        }
    }
}
