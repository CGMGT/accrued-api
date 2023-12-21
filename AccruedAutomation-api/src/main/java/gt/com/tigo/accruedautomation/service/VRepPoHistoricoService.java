package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.GroupRepository;
import gt.com.tigo.accruedautomation.dao.VRepPoHistoricoRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.AdmGrupoEntity;

import gt.com.tigo.accruedautomation.model.VRepPoHistoricoEntity;
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
public class VRepPoHistoricoService extends AbstractService<VRepPoHistoricoEntity, VRepPoHistoricoRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VRepPoHistoricoService.class);

    private static final String TABLE_NAME = "v_rep_po_historico";
    public static final String FECHARECEPCION = "fechaRecepcion";
    public static final String FECHAINTEGRACION = "fechaIntegracion";
    public static final String ULTIMAACT = "ultimaActualizacion";
    public static final String ORIGEN = "origen";
    public static final String ORIGEN1 = "origen1";
    public static final String ORIGEN2 = "origen2";
    public static final String CAPEXOPEX = "Capex, Opex";


    @Autowired
    private GroupRepository groupRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<VRepPoHistoricoEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification llaveSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("llave", getValueAsString(filtersInfo, "llave"));
            Specification nombreEntidad = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("nombreEntidad", getValueAsString(filtersInfo, "nombreEntidad"));
            Specification poNumberSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("poNumber", getValueAsString(filtersInfo, "poNumber"));
            Specification recepcion = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("recepcion", getValueAsString(filtersInfo, "recepcion"));
            Specification proveedorSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification conceptoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification monedaSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification montoSpec = SpecFactory.<VRepPoHistoricoEntity>getEqualSpecification("monto", getValueAsString(filtersInfo, "monto"));
            Specification montoGtqSpec = SpecFactory.<VRepPoHistoricoEntity>getEqualSpecification("montoGtq", getValueAsString(filtersInfo, "montoGtq"));
            Specification antiguedadSpec = SpecFactory.<VRepPoHistoricoEntity>getEqualSpecification("antiguedad", getValueAsLong(filtersInfo, "antiguedad"));
            Specification statusSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("status", getValueAsString(filtersInfo, "status"));
            Specification justificacionSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("justificacion", getValueAsString(filtersInfo, "justificacion"));
            Specification archivoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("archivo", getValueAsString(filtersInfo, "archivo"));
            Specification fechaRecepcionSpec = SpecFactory.<VRepPoHistoricoEntity>getBetweenSpecification(FECHARECEPCION, getValueAsSimpleDate(filtersInfo, FECHARECEPCION), getValueAsSimpleDate(filtersInfo, FECHARECEPCION));
            Specification nombreRequesterSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("nombreRequester", getValueAsString(filtersInfo, "nombreRequester"));
            Specification usuarioRequesterSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("usuarioRequester", getValueAsString(filtersInfo, "usuarioRequester"));
            Specification nombreOwnerSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("nombreOwner", getValueAsString(filtersInfo, "nombreOwner"));
            Specification usuarioOwnerSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("usuarioOwner", getValueAsString(filtersInfo, "usuarioOwner"));
            Specification nombreJefeOwnerSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("nombreJefeOwner", getValueAsString(filtersInfo, "nombreJefeOwner"));
            Specification usuarioJefeOwnerSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("usuarioJefeOwner", getValueAsString(filtersInfo, "usuarioJefeOwner"));
            Specification antiguedadPeriodoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("antiguedadPeriodo", getValueAsString(filtersInfo, "antiguedadPeriodo"));
            Specification entidadSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("entidad", getValueAsString(filtersInfo, "entidad"));
            Specification tipoCambioSpec = SpecFactory.<VRepPoHistoricoEntity>getEqualSpecification("tipoCambio", getValueAsDouble(filtersInfo, "tipoCambio"));
            Specification cargoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("cargo", getValueAsString(filtersInfo, "cargo"));
            Specification abonoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("abono", getValueAsString(filtersInfo, "abono"));
            Specification centroCostoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("centroCosto", getValueAsString(filtersInfo, "centroCosto"));
            Specification fechaIntegracionSpec = SpecFactory.<VRepPoHistoricoEntity>getBetweenSpecification(FECHAINTEGRACION, getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION), getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION));
            Specification ultimaActualizacionSpec = SpecFactory.<VRepPoHistoricoEntity>getBetweenSpecification(ULTIMAACT, getValueAsDate(filtersInfo, ULTIMAACT), getValueAsDate(filtersInfo, ULTIMAACT));
            Specification attribute2Spec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("attribute2", getValueAsString(filtersInfo, "attribute2"));
            Specification periodoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("periodo", getValueAsString(filtersInfo, "periodo"));
            Specification cambiarAEstadoSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification("cambiarAEstado", getValueAsString(filtersInfo, "cambiarAEstado"));
            Specification origenSpec2 = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));

            Specification origenSpec;

            Specification origenOpexCapexSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification(ORIGEN, "CAPEX");

            if (filtersInfo.containsKey(ORIGEN1)) {
                origenSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN1));
            } else if (filtersInfo.containsKey(ORIGEN2)) {
                origenSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification(ORIGEN, "OPEX").or(origenOpexCapexSpec);
            } else {
                origenSpec = SpecFactory.<VRepPoHistoricoEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));
            }

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(llaveSpec)
                    .and(nombreEntidad)
                    .and(poNumberSpec)
                    .and(recepcion)
                    .and(proveedorSpec)
                    .and(conceptoSpec)
                    .and(monedaSpec)
                    .and(montoSpec)
                    .and(montoGtqSpec)
                    .and(antiguedadSpec)
                    .and(statusSpec)
                    .and(justificacionSpec)
                    .and(cambiarAEstadoSpec)
                    .and(origenSpec2)
                    .and(archivoSpec)
                    .and(fechaRecepcionSpec)
                    .and(nombreRequesterSpec)
                    .and(usuarioRequesterSpec)
                    .and(nombreOwnerSpec)
                    .and(usuarioOwnerSpec)
                    .and(nombreJefeOwnerSpec)
                    .and(usuarioJefeOwnerSpec)
                    .and(antiguedadPeriodoSpec)
                    .and(origenSpec)
                    .and(entidadSpec)
                    .and(tipoCambioSpec)
                    .and(cargoSpec)
                    .and(abonoSpec)
                    .and(centroCostoSpec)
                    .and(fechaIntegracionSpec)
                    .and(ultimaActualizacionSpec)
                    .and(attribute2Spec)
                    .and(periodoSpec);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public VRepPoHistoricoEntity create(VRepPoHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();
            List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);

            model.put(CsvViewBuilder.KEY_FILENAME, "HistoricoPO.csv");
            model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(CsvViewBuilder.KEY_COLUMNS, columnsToExport);
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<VRepPoHistoricoEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                for (VRepPoHistoricoEntity item : items) {
                    rows.add(this.mapEntityToRow(item, columnsToExport));
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

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public VRepPoHistoricoEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<VRepPoHistoricoEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public VRepPoHistoricoEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }


    public PaginatedDataDto<VRepPoHistoricoEntity> findByPage(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if (!admGrupoEntities.isEmpty()) {
            FilterInfoDto dto = new FilterInfoDto();
            if (admGrupoEntities.size() == 1) {
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            } else {
                dto.setId(ORIGEN2);
                dto.setValue(CAPEXOPEX);

            }
            dataTableRequestDto.getFiltered().add(dto);
        }


        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public VRepPoHistoricoEntity update(VRepPoHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto.toString()));

        try {
            Map<String, Object> model = new HashMap<>();
            List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);

            model.put(XlsxViewBuilder.KEY_FILENAME, "HistoricoPO.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, columnsToExport);
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<VRepPoHistoricoEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (VRepPoHistoricoEntity item : items) {
                    rows.add(this.mapEntityToRow(item, columnsToExport).toArray());
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
    public PaginatedDataDto<VRepPoHistoricoEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
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
                dto.setValue(CAPEXOPEX);
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
                dto.setValue(CAPEXOPEX);
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.exportCsv(dataTableRequestDto);
    }

}
