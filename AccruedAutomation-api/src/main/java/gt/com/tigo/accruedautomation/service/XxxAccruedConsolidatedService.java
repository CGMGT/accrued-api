package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.AccruedConsolidatedRepository;
import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.UserRepository;
import gt.com.tigo.accruedautomation.dao.XxxAccruedConsolidatedRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.AccruedConsolidatedEntity;
import gt.com.tigo.accruedautomation.model.AdmParametroEntity;
import gt.com.tigo.accruedautomation.model.AdmUsuarioEntity;
import gt.com.tigo.accruedautomation.model.XxxAccruedConsolidatedEntity;
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
public class XxxAccruedConsolidatedService extends AbstractService<XxxAccruedConsolidatedEntity, XxxAccruedConsolidatedRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxxAccruedConsolidatedService.class);
    public static final String MODULO1 = "modulo";
    public static final String LLAVE = "LLAVE";
    public static final String MODULO = "MÓDULO";
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
    public static final String TASA_CAMBIO = "TASA CAMBIO";
    public static final String REVALUACION = "REVALUACIÓN";
    public static final String MONTO_REVALUADO = "MONTO REVALUADO";
    public static final String ANTIGUEDAD = "ANTIGÜEDAD";
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
    public static final String COMENTARIO = "COMENTARIO";
    public static final String INTERNAL_ID = "internalId";
    public static final String ESTADO = "ESTADO";
    @Autowired
    private AccruedConsolidatedRepository accruedConsolidatedRepository;

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
            Specification moduloSpec = SpecFactory.<XxxAccruedConsolidatedEntity>getLikeSpecification(MODULO1, getValueAsString(filtersInfo, MODULO1));
            Specification cuentaSpec = SpecFactory.<XxxAccruedConsolidatedEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification conceptoSpec = SpecFactory.<XxxAccruedConsolidatedEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification poSpec = SpecFactory.<XxxAccruedConsolidatedEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification monedaSpec = SpecFactory.<XxxAccruedConsolidatedEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(moduloSpec)
                    .and(cuentaSpec)
                    .and(conceptoSpec)
                    .and(poSpec)
                    .and(monedaSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public XxxAccruedConsolidatedEntity create(XxxAccruedConsolidatedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public XxxAccruedConsolidatedEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxxAccruedConsolidatedEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxxAccruedConsolidatedEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxxAccruedConsolidatedEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, MODULO1);
    }

    @Override
    public XxxAccruedConsolidatedEntity update(XxxAccruedConsolidatedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "DatosConsolidados.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO,
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
                    TASA_CAMBIO,
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
                    COMENTARIO
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxxAccruedConsolidatedEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedConsolidatedEntity item : items) {
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
                    row.add(String.valueOf(item.getTc()));
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

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "ConsolidacionDetalle.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO,
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
                    TASA_CAMBIO,
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
                    COMENTARIO
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxxAccruedConsolidatedEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedConsolidatedEntity item : items) {
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
                    row.add(String.valueOf(item.getTc()));
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

            Map<Long, AccruedConsolidatedEntity> accruedConsolidatedEntitiesMap = new HashMap<>();
            List<XxxAccruedConsolidatedEntity> xxxAccruedConsolidatedEntitiesFromXlsx = new LinkedList<>();




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
                    String cell14 = getCellValueAsString(sheet.getRow(i).getCell(14)); // concept
                    String cell15 = getCellValueAsString(sheet.getRow(i).getCell(15)); // currency
                    Double cell16 = getCellValueAsDouble(sheet.getRow(i).getCell(16)); // ammount
                    Double cell17 = getCellValueAsDouble(sheet.getRow(i).getCell(17)); // ammount gtq
                    Double cell18 = getCellValueAsDouble(sheet.getRow(i).getCell(18)); // exchange rate
                    String cell19 = getCellValueAsString(sheet.getRow(i).getCell(19)); // re-evaluation
                    Double cell20 = getCellValueAsDouble(sheet.getRow(i).getCell(20)); // re-evaluated ammount
                    Integer cell21 = Math.toIntExact(Math.round(getCellValueAsDouble(sheet.getRow(i).getCell(21)))); // antiquity
                    String cell22 = getCellValueAsString(sheet.getRow(i).getCell(22)); // status
                    String cell23 = getCellValueAsString(sheet.getRow(i).getCell(23)); // change to status
                    String cell24 = getCellValueAsString(sheet.getRow(i).getCell(24)); // justification
                    String cell25 = getCellValueAsString(sheet.getRow(i).getCell(25)); // attach file
                    String cell26 = getCellValueAsString(sheet.getRow(i).getCell(26)); // reception date
                    String cell27 = getCellValueAsString(sheet.getRow(i).getCell(27)); // requester name
                    String cell28 = getCellValueAsString(sheet.getRow(i).getCell(28)); // requester email
                    String cell29 = getCellValueAsString(sheet.getRow(i).getCell(29)); // creator name
                    String cell30 = getCellValueAsString(sheet.getRow(i).getCell(30)); // creator email
                    String cell31 = getCellValueAsString(sheet.getRow(i).getCell(31)); // owner superior name
                    String cell32 = getCellValueAsString(sheet.getRow(i).getCell(32)); // owner superior
                    String cell33 = getCellValueAsString(sheet.getRow(i).getCell(33)); // period antiquity
                    String cell34 = getCellValueAsString(sheet.getRow(i).getCell(34)); // source
                    String cell35 = getCellValueAsString(sheet.getRow(i).getCell(35)); // charge
                    String cell36 = getCellValueAsString(sheet.getRow(i).getCell(36)); // payment
                    String cell37 = getCellValueAsString(sheet.getRow(i).getCell(37)); // kpi
                    String cell38 = getCellValueAsString(sheet.getRow(i).getCell(38)); // integration date

                    XxxAccruedConsolidatedEntity xxxEntity = new XxxAccruedConsolidatedEntity();

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
                    xxxEntity.setTc(cell18);
                    xxxEntity.setRevaluacion(cell19);
                    xxxEntity.setMontoRevaluado(cell20);
                    xxxEntity.setAntiguedad(cell21);
                    xxxEntity.setStatus(cell22);
                    xxxEntity.setCambiarAEstado(cell23);
                    xxxEntity.setJustificacionProvision(cell24);
                    xxxEntity.setAdjuntarArchivo(cell25);
                    xxxEntity.setFechaRecepcion(cell26);
                    xxxEntity.setNombreRequester(cell27);
                    xxxEntity.setRequesterEmail(cell28);
                    xxxEntity.setNombreCreator(cell29);
                    xxxEntity.setCreatorEmail(cell30);
                    xxxEntity.setNombreJefeOwner(cell31);
                    xxxEntity.setJefeDeOwner(cell32);
                    xxxEntity.setAntiguedadPeriodo(cell33);
                    xxxEntity.setOrigen(cell34);
                    xxxEntity.setCargo(cell35);
                    xxxEntity.setAbono(cell36);
                    xxxEntity.setKpi(cell37);
                    xxxEntity.setFechaIntegracion(new Date(dateFormatter.parse(cell38).getTime()));
                    xxxEntity.setComentarios(String.format("Registro cargado por el usuario %s", requester.getUsuario()));

                    xxxAccruedConsolidatedEntitiesFromXlsx.add(xxxEntity);
                }



                List<AccruedConsolidatedEntity> accruedConsolidatedEntitiesResultList = this.accruedConsolidatedRepository.findAllById(ids);

                accruedConsolidatedEntitiesMap.clear();

                for (AccruedConsolidatedEntity accruedConsolidatedEntity : accruedConsolidatedEntitiesResultList) {
                    accruedConsolidatedEntitiesMap.put(accruedConsolidatedEntity.getId(), accruedConsolidatedEntity);
                }



                for (XxxAccruedConsolidatedEntity xxxAccruedConsolidatedEntityFromXlsx : xxxAccruedConsolidatedEntitiesFromXlsx) {
                    if (xxxAccruedConsolidatedEntityFromXlsx.getId() == null) {
                        continue;
                    }

                    AccruedConsolidatedEntity accruedConsolidatedEntity = accruedConsolidatedEntitiesMap.get(xxxAccruedConsolidatedEntityFromXlsx.getId());

                    if (accruedConsolidatedEntity == null) {

                        continue;
                    }

                    xxxAccruedConsolidatedEntityFromXlsx.setLlave(accruedConsolidatedEntity.getLlave());
                    xxxAccruedConsolidatedEntityFromXlsx.setModulo(accruedConsolidatedEntity.getModulo());
                    xxxAccruedConsolidatedEntityFromXlsx.setCompania(accruedConsolidatedEntity.getCompania());
                    xxxAccruedConsolidatedEntityFromXlsx.setMoneda(accruedConsolidatedEntity.getMoneda());

                    xxxAccruedConsolidatedEntityFromXlsx.setTc(accruedConsolidatedEntity.getTc());
                    xxxAccruedConsolidatedEntityFromXlsx.setRevaluacion(accruedConsolidatedEntity.getRevaluacion());
                    xxxAccruedConsolidatedEntityFromXlsx.setMontoRevaluado(accruedConsolidatedEntity.getMontoRevaluado());
                    xxxAccruedConsolidatedEntityFromXlsx.setAntiguedad(accruedConsolidatedEntity.getAntiguedad());
                    xxxAccruedConsolidatedEntityFromXlsx.setStatus(accruedConsolidatedEntity.getStatus());
                    xxxAccruedConsolidatedEntityFromXlsx.setCambiarAEstado(accruedConsolidatedEntity.getCambiarAEstado());
                    xxxAccruedConsolidatedEntityFromXlsx.setJustificacionProvision(accruedConsolidatedEntity.getJustificacionProvision());
                    xxxAccruedConsolidatedEntityFromXlsx.setAdjuntarArchivo(accruedConsolidatedEntity.getAdjuntarArchivo());
                    xxxAccruedConsolidatedEntityFromXlsx.setFechaRecepcion(accruedConsolidatedEntity.getFechaRecepcion());
                    xxxAccruedConsolidatedEntityFromXlsx.setNombreRequester(accruedConsolidatedEntity.getNombreRequester());
                    xxxAccruedConsolidatedEntityFromXlsx.setRequesterEmail(accruedConsolidatedEntity.getRequesterEmail());
                    xxxAccruedConsolidatedEntityFromXlsx.setNombreCreator(accruedConsolidatedEntity.getNombreCreator());
                    xxxAccruedConsolidatedEntityFromXlsx.setCreatorEmail(accruedConsolidatedEntity.getCreatorEmail());
                    xxxAccruedConsolidatedEntityFromXlsx.setNombreJefeOwner(accruedConsolidatedEntity.getNombreJefeOwner());
                    xxxAccruedConsolidatedEntityFromXlsx.setJefeDeOwner(accruedConsolidatedEntity.getJefeDeOwner());
                    xxxAccruedConsolidatedEntityFromXlsx.setAntiguedadPeriodo(accruedConsolidatedEntity.getAntiguedadPeriodo());

                    xxxAccruedConsolidatedEntityFromXlsx.setKpi(accruedConsolidatedEntity.getKpi());
                    xxxAccruedConsolidatedEntityFromXlsx.setFechaIntegracion(accruedConsolidatedEntity.getFechaIntegracion());
                }

                totalRows += xxxAccruedConsolidatedEntitiesFromXlsx.size();


                this.repository.saveAll(xxxAccruedConsolidatedEntitiesFromXlsx);

                xxxAccruedConsolidatedEntitiesFromXlsx.clear();
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

            model.put(XlsxViewBuilder.KEY_FILENAME, "PlantillaConsolidado.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    LLAVE,
                    MODULO,
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
                    TASA_CAMBIO,
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
                    CARGO,
                    ABONO
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, INTERNAL_ID));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxxAccruedConsolidatedEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxxAccruedConsolidatedEntity item : items) {
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
                    row.add(String.valueOf(item.getTc()));
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
            int result = this.repository.validarConsolidado();

            return result == 0;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new TigoException("Error al validar Accrued Consolidado.");
        }
    }
}
