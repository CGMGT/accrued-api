package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.VBitacoraErroresRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.HistoricoProcesosEntity;
import gt.com.tigo.accruedautomation.model.VBitacoraErroresEntity;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class VBitacoraErroresService extends AbstractService<VBitacoraErroresEntity, VBitacoraErroresRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosService.class);
    public static final String LOGTIMESTAMP = "logTimestamp";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification errorMessageSpec = SpecFactory.<VBitacoraErroresEntity>getLikeSpecification("errorMessage", getValueAsString(filtersInfo, "errorMessage"));
            Specification sourceTypeSpec = SpecFactory.<VBitacoraErroresEntity>getLikeSpecification("sourceType", getValueAsString(filtersInfo, "sourceType"));
            Specification sourceNameSpec = SpecFactory.<VBitacoraErroresEntity>getLikeSpecification("sourceName", getValueAsString(filtersInfo, "sourceName"));
            Specification logTimestampSpec = SpecFactory.<HistoricoProcesosEntity>getBetweenSpecification(LOGTIMESTAMP, getValueAsZonedDate(filtersInfo, "startDate"), getValueAsZonedDate(filtersInfo, "endDate"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(errorMessageSpec)
                    .and(sourceTypeSpec)
                    .and(sourceNameSpec)
                    .and(logTimestampSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public VBitacoraErroresEntity create(VBitacoraErroresEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "BitacoraErrores.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "FECHA",
                    "MENSAJE ERROR",
                    "TIPO ORIGEN",
                    "NOMBRE ORIGEN"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, LOGTIMESTAMP));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<VBitacoraErroresEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (VBitacoraErroresEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getLogId()));
                    row.add(dateFormat.format(item.getLogTimestamp()));
                    row.add(item.getErrorMessage());
                    row.add(item.getSourceType());
                    row.add(item.getSourceName());

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
        return false;
    }

    @Override
    public VBitacoraErroresEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<VBitacoraErroresEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public VBitacoraErroresEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<VBitacoraErroresEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, LOGTIMESTAMP, Sort.Direction.DESC);
    }

    @Override
    public VBitacoraErroresEntity update(VBitacoraErroresEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "BitacoraErrores.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "FECHA",
                    "MENSAJE ERROR",
                    "TIPO ORIGEN",
                    "NOMBRE ORIGEN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, LOGTIMESTAMP));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<VBitacoraErroresEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (VBitacoraErroresEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getLogId()));
                    row.add(dateFormat.format(item.getLogTimestamp()));
                    row.add(item.getErrorMessage());
                    row.add(item.getSourceType());
                    row.add(item.getSourceName());

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

    public List<Object> getSourceType(String sourceType){
        LOGGER.debug(String.format("@%s::getSourceType(%s)", this.getClass().getName(), sourceType));
        return this.repository.getSourceType(sourceType);
    }
}
