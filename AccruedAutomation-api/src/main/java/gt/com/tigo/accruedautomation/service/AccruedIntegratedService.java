package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.AccruedIntegratedRepository;
import gt.com.tigo.accruedautomation.dto.*;

import gt.com.tigo.accruedautomation.model.AccruedIntegratedEntity;
import gt.com.tigo.accruedautomation.model.AdmUsuarioEntity;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class AccruedIntegratedService extends AbstractService<AccruedIntegratedEntity, AccruedIntegratedRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccruedIntegratedService.class);
    private static final String MODULO = "modulo";
    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<AccruedIntegratedEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification kpiSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("kpi", getValueAsString(filtersInfo, "kpi"));
            Specification companiaSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("compania", getValueAsString(filtersInfo, "compania"));
            Specification moduloSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification(MODULO, getValueAsString(filtersInfo, MODULO));
            Specification cuentaSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification poSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification proveedorSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification monedaSpec = SpecFactory.<AccruedIntegratedEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification monto = SpecFactory.<AccruedIntegratedEntity>getEqualSpecification("monto", getValueAsDouble(filtersInfo, "monto"));
            Specification montoGtq = SpecFactory.<AccruedIntegratedEntity>getEqualSpecification("montoGtq", getValueAsDouble(filtersInfo, "montoGtq"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(kpiSpec)
                    .and(companiaSpec)
                    .and(moduloSpec)
                    .and(cuentaSpec)
                    .and(poSpec)
                    .and(proveedorSpec)
                    .and(monedaSpec)
                    .and(monto)
                    .and(montoGtq);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public AccruedIntegratedEntity create(AccruedIntegratedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public AccruedIntegratedEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<AccruedIntegratedEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public AccruedIntegratedEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<AccruedIntegratedEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, MODULO);
    }

    @Override
    public AccruedIntegratedEntity update(AccruedIntegratedEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "IntegracionDetalle.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "LLAVE",
                    "MÓDULO",
                    "COMPAÑÍA",
                    "CUENTA",
                    "LOCAL",
                    "FLUJO",
                    "CC",
                    "PROYECTO",
                    "PO",
                    "RECEPCIÓN",
                    "LÍNEA",
                    "NÚMERO DOCUMENTO",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "TASA CAMBIO HISTÓRICO",
                    "TASA CAMBIO CIERRE",
                    "REVALUACIÓN",
                    "MONTO REVALUADO",
                    "ANTIGÜEDAD",
                    "ESTADO",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN PROVISIÓN",
                    "ADJUNTAR ARCHIVO",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "CORREO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "CORREO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "JEFE DE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    "CARGO",
                    "ABONO",
                    "KPI",
                    "FECHA INTEGRACIÓN",
                    "ESTADO INTEGRACIÓN",
                    "UMBRAL"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<AccruedIntegratedEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (AccruedIntegratedEntity item : items) {
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
            model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "LLAVE",
                    "MÓDULO",
                    "COMPAÑÍA",
                    "CUENTA",
                    "LOCAL",
                    "FLUJO",
                    "CC",
                    "PROYECTO",
                    "PO",
                    "RECEPCIÓN",
                    "LÍNEA",
                    "NÚMERO DOCUMENTO",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "TASA CAMBIO HISTÓRICO",
                    "TASA CAMBIO CIERRE",
                    "REVALUACIÓN",
                    "MONTO REVALUADO",
                    "ANTIGÜEDAD",
                    "ESTADO",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN PROVISIÓN",
                    "ADJUNTAR ARCHIVO",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "CORREO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "CORREO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "JEFE DE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    "CARGO",
                    "ABONO",
                    "KPI",
                    "FECHA INTEGRACIÓN",
                    "ESTADO INTEGRACIÓN",
                    "UMBRAL"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<AccruedIntegratedEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (AccruedIntegratedEntity item : items) {
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

    public boolean procesar(ProcessValidationDto processValidationDto) throws TigoException {
        LOGGER.debug(String.format("@%s::procesar()", this.getClass().getName()));

        Optional<AdmUsuarioEntity> optionalAdmUsuarioEntity = this.userRepository.findById(processValidationDto.getRequesterId());

        if (!optionalAdmUsuarioEntity.isPresent()) {
            throw new RequesterNotFoundException();
        }

        AdmUsuarioEntity requester = optionalAdmUsuarioEntity.get();

        try {
            int result = this.repository.procesarIntegracion(requester.getCorreoElectronico());

            return result == 0;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new TigoException("Error al validar Accrued Consolidado.");
        }
    }
}
