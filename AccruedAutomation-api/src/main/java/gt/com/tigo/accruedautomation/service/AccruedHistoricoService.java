package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.AccruedHistoricoRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.AccruedHistoricoEntity;
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

import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getValueAsString;

@Service
public class AccruedHistoricoService extends AbstractService<AccruedHistoricoEntity, AccruedHistoricoRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccruedHistoricoService.class);
    private static final String MODULO = "modulo";
    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification moduloSpec = SpecFactory.<AccruedHistoricoEntity>getLikeSpecification(MODULO, getValueAsString(filtersInfo, MODULO));
            Specification cuentaSpec = SpecFactory.<AccruedHistoricoEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification poSpec = SpecFactory.<AccruedHistoricoEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification monedaSpec = SpecFactory.<AccruedHistoricoEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));

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
    public AccruedHistoricoEntity create(AccruedHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public AccruedHistoricoEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<AccruedHistoricoEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public AccruedHistoricoEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<AccruedHistoricoEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, MODULO);
    }

    @Override
    public AccruedHistoricoEntity update(AccruedHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "DatosHistoricos.xlsx");
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
                    "TASA CAMBIO (HISTÓRICO)",
                    "TASA CAMBIO (AL CIERRE)",
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
                    "FECHA INTEGRACIÓN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, MODULO));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<AccruedHistoricoEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (AccruedHistoricoEntity item : items) {
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
        return null;
    }
}
