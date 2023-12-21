package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.CustomReportRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.CustomReportEntity;
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
public class CustomReportService extends AbstractService<CustomReportEntity, CustomReportRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomReportService.class);

    private final String[] columnas = {
            "ID",
            "APLICAR A REPORTE",
            "NOMBRE",
            "DESCRIPCIÓN",
            "FECHA CREACION",
            "CREADO POR",
            "ÚLTIMA MODIFICACIÓN",
            "ÚLTIMA MODIFICACIÓN POR"
    };

    private List<String> mapEntityToRow(CustomReportEntity item) {

        IDateTimeFormat timestampFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIMESTAMP);

        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getReporte());
        row.add(item.getNombre());
        row.add(item.getDescripcion());
        row.add(timestampFormat.format(item.getFechaCreacion()));
        row.add(item.getUsuarioCreacion());
        row.add(timestampFormat.format(item.getFechaModificacion()));
        row.add(item.getUsuarioModificacion());

        return row;
    }

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification nombreSpec = SpecFactory.<CustomReportEntity>getLikeSpecification("nombre", getValueAsString(filtersInfo, "nombre"));
            Specification descripcionSpec = SpecFactory.<CustomReportEntity>getLikeSpecification("descripcion", getValueAsString(filtersInfo, "descripcion"));
            Specification reporteSpec = SpecFactory.<CustomReportEntity>getLikeSpecification("reporte", getValueAsString(filtersInfo, "reporte"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(nombreSpec)
                    .and(descripcionSpec)
                    .and(reporteSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public CustomReportEntity create(CustomReportEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._create(entity, requesterId);
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "ReportesPersonalizados.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<CustomReportEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (CustomReportEntity item : items) {
                rows.add(this.mapEntityToRow(item));
            }

            return rows;
        });

        return new CsvViewBuilder().buildCsvFile(model);
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        LOGGER.debug(String.format("@%s::deleteById(%d)", this.getClass().getName(), entityId));

        return super._deleteById(entityId);
    }

    @Override
    public CustomReportEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<CustomReportEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public CustomReportEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<CustomReportEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public CustomReportEntity update(CustomReportEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "ReportesPersonalizados.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<CustomReportEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (CustomReportEntity item : items) {
                    rows.add(this.mapEntityToRow(item).toArray());
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
}
