package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.XxPurchaseOrderRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.XxPurchaseOrderEntity;
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
public class XxPurchaseOrderService extends AbstractService<XxPurchaseOrderEntity, XxPurchaseOrderRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxPurchaseOrderService.class);
    public static final String PONUMBER = "poNumber";
    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification llaveSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("llave", getValueAsString(filtersInfo, "llave"));
            Specification poNumberSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification(PONUMBER, getValueAsString(filtersInfo, PONUMBER));
            Specification proveedorSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification conceptoSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification monedaSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification statusSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("status", getValueAsString(filtersInfo, "status"));
            Specification nombreRequesterSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("nombreRequester", getValueAsString(filtersInfo, "nombreRequester"));
            Specification usuarioRequesterSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("usuarioRequester", getValueAsString(filtersInfo, "usuarioRequester"));
            Specification nombreOwnerSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("nombreOwner", getValueAsString(filtersInfo, "nombreOwner"));
            Specification usuarioOwnerSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("usuarioOwner", getValueAsString(filtersInfo, "usuarioOwner"));
            Specification nombreJefeOwnerSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("nombreJefeOwner", getValueAsString(filtersInfo, "nombreJefeOwner"));
            Specification usuarioJefeOwnerSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("usuarioJefeOwner", getValueAsString(filtersInfo, "usuarioJefeOwner"));
            Specification antiguedadPeriodoSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("antiguedadPeriodo", getValueAsString(filtersInfo, "antiguedadPeriodo"));
            Specification origenSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("origen", getValueAsString(filtersInfo, "origen"));
            Specification entidadSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("entidad", getValueAsString(filtersInfo, "entidad"));
            Specification centroCostoSpec = SpecFactory.<XxPurchaseOrderEntity>getLikeSpecification("centroCosto", getValueAsString(filtersInfo, "centroCosto"));
            Specification fechaRecepcionSpec = SpecFactory.<XxPurchaseOrderEntity>getBetweenSpecification("fechaRecepcion", getValueAsDate(filtersInfo, "fechaRecepcionInicio"), getValueAsDate(filtersInfo, "fechaRecepcionFin"));
            Specification fechaIntegracionSpec = SpecFactory.<XxPurchaseOrderEntity>getBetweenSpecification("fechaIntegracion", getValueAsDate(filtersInfo, "fechaIntegracionInicio"), getValueAsDate(filtersInfo, "fechaIntegracionFin"));
            Specification ultimaActualizacionSpec = SpecFactory.<XxPurchaseOrderEntity>getBetweenSpecification("ultimaActualizacion", getValueAsDate(filtersInfo, "ultimaActualizacionInicio"), getValueAsDate(filtersInfo, "ultimaActualizacionnFin"));


            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(llaveSpec)
                    .and(poNumberSpec)
                    .and(proveedorSpec)
                    .and(conceptoSpec)
                    .and(monedaSpec)
                    .and(statusSpec)
                    .and(nombreRequesterSpec)
                    .and(usuarioRequesterSpec)
                    .and(nombreOwnerSpec)
                    .and(usuarioOwnerSpec)
                    .and(nombreJefeOwnerSpec)
                    .and(usuarioJefeOwnerSpec)
                    .and(antiguedadPeriodoSpec)
                    .and(origenSpec)
                    .and(entidadSpec)
                    .and(centroCostoSpec)
                    .and(fechaRecepcionSpec)
                    .and(fechaIntegracionSpec)
                    .and(ultimaActualizacionSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public XxPurchaseOrderEntity create(XxPurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public XxPurchaseOrderEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxPurchaseOrderEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxPurchaseOrderEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxPurchaseOrderEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, PONUMBER);
    }

    @Override
    public XxPurchaseOrderEntity update(XxPurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto.toString()));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "PO.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "LLAVE",
                    "NÚMERO PO",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "ANTIGÜEDAD",
                    "ESTADO",
                    "JUSTIFICACIÓN",
                    "ADJUNTAR ARCHIVO",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "USUARIO SOLICITANTE",
                    "NOMBRE PROPIETARIO",
                    "USUARIO PROPIETARIO",
                    "NOMBRE JEFE PROPIETARIO",
                    "USUARIO JEFE PROPIETARIO",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    "ENTIDAD",
                    "TIPO CAMBIO",
                    "CARGO",
                    "ABONO",
                    "CENTRO COSTO",
                    "FECHA INTEGRACIÓN",
                    "ÚLTIMA ACTUALIZACIÓN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, PONUMBER));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxPurchaseOrderEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (XxPurchaseOrderEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getLlave());
                    row.add(item.getPoNumber());
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getStatus());
                    row.add(String.valueOf(item.getJustificacion()));
                    row.add(String.valueOf(item.getAdjuntarArchivo()));
                    row.add(dateFormat.format(item.getFechaRecepcion()));
                    row.add(item.getNombreRequester());
                    row.add(item.getUsuarioRequester());
                    row.add(item.getNombreOwner());
                    row.add(item.getUsuarioOwner());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getUsuarioJefeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getEntidad());
                    row.add(String.valueOf(item.getTipoCambio()));
                    row.add(String.valueOf(item.getCargo()));
                    row.add(String.valueOf(item.getAbono()));
                    row.add(item.getCentroCosto());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(dateFormat.format(item.getUltimaActualizacion()));

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
