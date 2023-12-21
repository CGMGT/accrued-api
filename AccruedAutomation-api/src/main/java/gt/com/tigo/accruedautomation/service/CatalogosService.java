package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.CatalogosRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.CatalogosEntity;
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


import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getValueAsString;

@Service
public class CatalogosService extends AbstractService<CatalogosEntity, CatalogosRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosService.class);
    private static final String GRUPO = "grupo";
    private static final String NOMBRE = "nombre";

    @Autowired
    private CatalogosRepository catalogosRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification grupo = SpecFactory.<CatalogosEntity>getEqualSpecification(GRUPO, getValueAsString(filtersInfo, GRUPO));
            Specification llave = SpecFactory.<CatalogosEntity>getLikeSpecification("llave", getValueAsString(filtersInfo, "llave"));
            Specification nombre = SpecFactory.<CatalogosEntity>getLikeSpecification(NOMBRE, getValueAsString(filtersInfo, NOMBRE));
            Specification description = SpecFactory.<CatalogosEntity>getLikeSpecification("descripcion", getValueAsString(filtersInfo, "descripcion"));
            Specification estado = SpecFactory.<CatalogosEntity>getLikeSpecification("estado", getValueAsString(filtersInfo, "estado"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(grupo)
                    .and(llave)
                    .and(nombre)
                    .and(description)
                    .and(estado);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public CatalogosEntity create(CatalogosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));
        entity.setEstado("A");
        return super._create(entity, requesterId);
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "Catalogos.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "GRUPO",
                    "LLAVE",
                    "NOMBRE",
                    "DESCRIPCION",
                    "ESTADO",
                    "FECHA CREACION",
                    "USUARIO CREACION",
                    "FECHA MODIFICACION",
                    "USUARIO MODIFICACION",
                    "ATTRIBUTE1",
                    "ATTRIBUTE2",
                    "ATTRIBUTE3",
                    "ATTRIBUTE4"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, GRUPO));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<CatalogosEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);
                for (CatalogosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getGrupo());
                    row.add(item.getLlave());
                    row.add(item.getNombre());
                    row.add(item.getDescripcion());
                    row.add(item.getEstado());
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getUsuarioCreacion());
                    row.add(dateFormat.format(item.getFechaModificacion()));
                    row.add(item.getUsuarioModificacion());
                    row.add(item.getAttribute1());
                    row.add(item.getAttribute2());
                    row.add(item.getAttribute3());
                    row.add(item.getAttribute4());

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

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        LOGGER.debug(String.format("@%s::deleteById(%d)", this.getClass().getName(), entityId));

        return super._deleteById(entityId);
    }

    @Override
    public CatalogosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::deleteById(%d, %d)", this.getClass().getName(), entityId, requesterId));

        CatalogosEntity entity = this.findById(entityId);

        entity.setEstado("I");

        return super._update(entity, requesterId);
    }

    @Override
    public List<CatalogosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public CatalogosEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<CatalogosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, NOMBRE);
    }

    @Override
    public CatalogosEntity update(CatalogosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Catalogos.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "GRUPO",
                    "LLAVE",
                    "NOMBRE",
                    "DESCRIPCION",
                    "ESTADO",
                    "FECHA CREACION",
                    "USUARIO CREACION",
                    "FECHA MODIFICACION",
                    "USUARIO MODIFICACION",
                    "ATTRIBUTE1",
                    "ATTRIBUTE2",
                    "ATTRIBUTE3",
                    "ATTRIBUTE4"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, GRUPO));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<CatalogosEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (CatalogosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getGrupo());
                    row.add(item.getLlave());
                    row.add(item.getNombre());
                    row.add(item.getDescripcion());
                    row.add(item.getEstado());
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getUsuarioCreacion());
                    row.add(dateFormat.format(item.getFechaModificacion()));
                    row.add(item.getUsuarioModificacion());
                    row.add(item.getAttribute1());
                    row.add(item.getAttribute2());
                    row.add(item.getAttribute3());
                    row.add(item.getAttribute4());

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

    public List<Object> getGroups() {
        LOGGER.debug(String.format("@%s::getGroups()", this.getClass().getName()));

        return this.catalogosRepository.getGroups();
    }

    public List<CatalogosEntity> findByGroup(String group) {
        LOGGER.debug(String.format("@%s::findByGroup(%s)", this.getClass().getName(), group));

        return this.catalogosRepository.findByGrupoOrderByNombre(group);
    }


}
