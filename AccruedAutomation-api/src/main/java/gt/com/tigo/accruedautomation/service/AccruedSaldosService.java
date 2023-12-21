package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.AccruedSaldosRepository;
import gt.com.tigo.accruedautomation.dao.GroupRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.AccruedSaldosEntity;
import gt.com.tigo.accruedautomation.model.AdmGrupoEntity;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class AccruedSaldosService extends AbstractService<AccruedSaldosEntity, AccruedSaldosRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccruedIntegratedService.class);
    private static final String FECHARECEPCION = "fechaRecepcion";
    private static final String FECHAINTEGRACION = "fechaIntegracion";
    private static final String ULTIMAACTUALIZACION = "ultimaActualizacion";
    private static final String ORIGEN = "origen";
    private static final String ORIGEN1 = "origen1";
    private static final String ORIGEN2 = "origen2";
    private static final String ENTIDAD = "ENTIDAD";

    @Autowired
    private GroupRepository groupRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<AccruedSaldosEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification llaveSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("llave", getValueAsString(filtersInfo, "llave"));
            Specification poNumberSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("poNumber", getValueAsString(filtersInfo, "poNumber"));
            Specification proveedorSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification conceptoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification monedaSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification montoSpec = SpecFactory.<AccruedSaldosEntity>getEqualSpecification("monto", getValueAsDouble(filtersInfo, "monto"));
            Specification montoGtqSpec = SpecFactory.<AccruedSaldosEntity>getEqualSpecification("montoGtq", getValueAsDouble(filtersInfo, "montoGtq"));
            Specification antiguedadSpec = SpecFactory.<AccruedSaldosEntity>getEqualSpecification("antiguedad", getValueAsLong(filtersInfo, "antiguedad"));
            Specification statusSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("status", getValueAsString(filtersInfo, "status"));
            Specification justificacionSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("justificacion", getValueAsString(filtersInfo, "justificacion"));
            Specification archivoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("archivo", getValueAsString(filtersInfo, "archivo"));
            Specification fechaRecepcionSpec = SpecFactory.<AccruedSaldosEntity>getBetweenSpecification(FECHARECEPCION, getValueAsSimpleDate(filtersInfo, FECHARECEPCION), getValueAsSimpleDate(filtersInfo, FECHARECEPCION));
            Specification nombreRequesterSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("nombreRequester", getValueAsString(filtersInfo, "nombreRequester"));
            Specification usuarioRequesterSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("usuarioRequester", getValueAsString(filtersInfo, "usuarioRequester"));
            Specification nombreOwnerSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("nombreOwner", getValueAsString(filtersInfo, "nombreOwner"));
            Specification usuarioOwnerSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("usuarioOwner", getValueAsString(filtersInfo, "usuarioOwner"));
            Specification nombreJefeOwnerSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("nombreJefeOwner", getValueAsString(filtersInfo, "nombreJefeOwner"));
            Specification usuarioJefeOwnerSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("usuarioJefeOwner", getValueAsString(filtersInfo, "usuarioJefeOwner"));
            Specification antiguedadPeriodoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("antiguedadPeriodo", getValueAsString(filtersInfo, "antiguedadPeriodo"));
            Specification entidadSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("entidad", getValueAsString(filtersInfo, "entidad"));
            Specification tipoCambioSpec = SpecFactory.<AccruedSaldosEntity>getEqualSpecification("tipoCambio", getValueAsDouble(filtersInfo, "tipoCambio"));
            Specification cargoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("cargo", getValueAsString(filtersInfo, "cargo"));
            Specification abonoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("abono", getValueAsString(filtersInfo, "abono"));
            Specification centroCostoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("centroCosto", getValueAsString(filtersInfo, "centroCosto"));
            Specification fechaIntegracionSpec = SpecFactory.<AccruedSaldosEntity>getBetweenSpecification(FECHAINTEGRACION, getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION), getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION));
            Specification ultimaActualizacionSpec = SpecFactory.<AccruedSaldosEntity>getBetweenSpecification(ULTIMAACTUALIZACION, getValueAsDate(filtersInfo, ULTIMAACTUALIZACION), getValueAsDate(filtersInfo, ULTIMAACTUALIZACION));

            Specification attribute1Spec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("attribute1", getValueAsString(filtersInfo, "attribute1"));
            Specification attribute2Spec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("attribute2", getValueAsString(filtersInfo, "attribute2"));
            Specification attribute3Spec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("attribute3", getValueAsString(filtersInfo, "attribute3"));
            Specification attribute4Spec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("attribute4", getValueAsString(filtersInfo, "attribute4"));
            Specification attribute5Spec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("attribute5", getValueAsString(filtersInfo, "attribute5"));
            Specification cambiarAEstadoSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification("cambiarAEstado", getValueAsString(filtersInfo, "cambiarAEstado"));
            Specification origenSpec2 = SpecFactory.<AccruedSaldosEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));
            Specification origenSpec;

            Specification origenOpexCapexSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification(ORIGEN, "CAPEX");

            if (filtersInfo.containsKey(ORIGEN1)) {
                origenSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN1));
            } else if (filtersInfo.containsKey(ORIGEN2)) {
                origenSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification(ORIGEN, "OPEX").or(origenOpexCapexSpec);
            } else {
                origenSpec = SpecFactory.<AccruedSaldosEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));
            }
            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(llaveSpec)
                    .and(poNumberSpec)
                    .and(proveedorSpec)
                    .and(conceptoSpec)
                    .and(monedaSpec)
                    .and(montoSpec)
                    .and(montoGtqSpec)
                    .and(antiguedadSpec)
                    .and(statusSpec)
                    .and(justificacionSpec)
                    .and(archivoSpec)
                    .and(origenSpec)
                    .and(origenSpec2)
                    .and(fechaRecepcionSpec)
                    .and(nombreRequesterSpec)
                    .and(usuarioRequesterSpec)
                    .and(nombreOwnerSpec)
                    .and(usuarioOwnerSpec)
                    .and(nombreJefeOwnerSpec)
                    .and(usuarioJefeOwnerSpec)
                    .and(antiguedadPeriodoSpec)
                    .and(entidadSpec)
                    .and(tipoCambioSpec)
                    .and(cargoSpec)
                    .and(abonoSpec)
                    .and(centroCostoSpec)
                    .and(fechaIntegracionSpec)
                    .and(ultimaActualizacionSpec)
                    .and(attribute1Spec)
                    .and(attribute2Spec)
                    .and(attribute3Spec)
                    .and(attribute4Spec)
                    .and(attribute5Spec)
                    .and(cambiarAEstadoSpec);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public AccruedSaldosEntity create(AccruedSaldosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }


    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public AccruedSaldosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<AccruedSaldosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public AccruedSaldosEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<AccruedSaldosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public AccruedSaldosEntity update(AccruedSaldosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Saldos.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "ESTADO",
                    "PERÍODO",
                    ENTIDAD,
                    "NÚMERO PO",
                    "RECEPCIÓN",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "LLAVE",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "ANTIGÜEDAD",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "USUARIO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "USUARIO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "USUARIO JEFE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    ENTIDAD,
                    "TIPO CAMBIO",
                    "CARGO",
                    "ABONO",
                    "CENTRO COSTO",
                    "FECHA INTEGRACIÓN",
                    "ÚLTIMA ACTUALIZACIÓN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<AccruedSaldosEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (AccruedSaldosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getStatus());
                    row.add(item.getAttribute4()); // period
                    row.add(item.getAttribute3()); // entity
                    row.add(item.getPoNumber());
                    row.add(item.getAttribute1()); // reception
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getLlave());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getCambiarAEstado());
                    row.add(String.valueOf(item.getJustificacion()));
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
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "Saldos.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "ESTADO",
                    "PERÍODO",
                    ENTIDAD,
                    "NÚMERO PO",
                    "RECEPCIÓN",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "LLAVE",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "ANTIGÜEDAD",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "USUARIO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "USUARIO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "USUARIO JEFE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    ENTIDAD,
                    "TIPO CAMBIO",
                    "CARGO",
                    "ABONO",
                    "CENTRO COSTO",
                    "FECHA INTEGRACIÓN",
                    "ÚLTIMA ACTUALIZACIÓN"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<AccruedSaldosEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (AccruedSaldosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getStatus());
                    row.add(item.getAttribute4()); // period
                    row.add(item.getAttribute3()); // entity
                    row.add(item.getPoNumber());
                    row.add(item.getAttribute1()); // reception
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getLlave());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getCambiarAEstado());
                    row.add(item.getJustificacion());
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
                    row.add(item.getCargo());
                    row.add(item.getAbono());
                    row.add(item.getCentroCosto());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(dateFormat.format(item.getUltimaActualizacion()));

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

    public ModelAndView exportOrigenXlsx(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsxOrigen(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if(!admGrupoEntities.isEmpty()){
            FilterInfoDto dto = new FilterInfoDto();
            if(admGrupoEntities.size()==1){
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            }else{
                dto.setId(ORIGEN2);
                dto.setValue("Capex, Opex");
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.exportXlsx(dataTableRequestDto);
    }

    public ResourceDto exportOrigenCsv(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if(!admGrupoEntities.isEmpty()){
            FilterInfoDto dto = new FilterInfoDto();
            if(admGrupoEntities.size()==1){
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            }else{
                dto.setId(ORIGEN2);
                dto.setValue("Capex, Opex");
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.exportCsv(dataTableRequestDto);
    }
}
