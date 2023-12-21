package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.TestRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.TestEntity;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class TestService extends AbstractCatalogService<TestEntity, TestRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);
    public static final String ITEMNAME = "itemName";
    @Override
    public List<TestEntity> findAll() throws ResourcesNotFoundException {
        LOGGER.debug(String.format("%s::findAll()", this.getClass().getName()));

        return super._findAll(ITEMNAME);
    }

    @Override
    public TestEntity findById(Long id) throws ResourceNotFoundException {
        LOGGER.debug(String.format("%s::findById(%d)", this.getClass().getName(), id));

        return super._findById(id);
    }

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification itemNameSpec = SpecFactory.<TestEntity>getLikeSpecification(ITEMNAME, getValueAsString(filtersInfo, ITEMNAME));
            Specification longDescriptionSpec = SpecFactory.<TestEntity>getLikeSpecification("longDescription", getValueAsString(filtersInfo, "longDescription"));
            Specification birthdateSpec = SpecFactory.<TestEntity>getBetweenSpecification("birthdate", getValueAsDate(filtersInfo, "startBirthdate"), getValueAsDate(filtersInfo, "endBirthdate"));
            Specification sectionSpec = SpecFactory.<TestEntity>getLikeSpecification("section", getValueAsString(filtersInfo, "section"));
            Specification salarySpec = SpecFactory.<TestEntity>getEqualSpecification("salary", getValueAsDouble(filtersInfo, "salary"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(itemNameSpec)
                    .and(longDescriptionSpec)
                    .and(birthdateSpec)
                    .and(sectionSpec)
                    .and(salarySpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public PaginatedDataDto<TestEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, ITEMNAME);
    }

    @Override
    public TestEntity create(TestEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));

        entity.setActive(true);

        return super._create(entity, requesterId);
    }

    @Override
    public TestEntity update(TestEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        entity.setActive(false);

        return super._update(entity, requesterId);
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        LOGGER.debug(String.format("@%s::deleteById(%d)", this.getClass().getName(), entityId));

        return super._deleteById(entityId);
    }

    @Override
    public TestEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::deleteById(%d, %d)", this.getClass().getName(), entityId, requesterId));

        TestEntity entity = this.findById(entityId);

        entity.setActive(false);

        return super._update(entity, requesterId);

    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Test.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "ITEM NAME",
                    "LONG DESCRIPTION",
                    "BIRTHDATE",
                    "START TIME",
                    "LAST LOGIN",
                    "SECTION",
                    "IS ACTIVE",
                    "SALARY",
                    "CORRELATIVE"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, ITEMNAME));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<TestEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);
                IDateTimeFormat timeFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIME);
                IDateTimeFormat timestampFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIMESTAMP);

                for (TestEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getItemName());
                    row.add(item.getLongDescription());
                    row.add(dateFormat.format(item.getBirthdate()));
                    row.add(timeFormat.format(item.getStartTime()));
                    row.add(timestampFormat.format(item.getLastLogin()));
                    row.add(item.getSection());
                    row.add(String.valueOf(item.getActive()));
                    row.add(String.valueOf(item.getSalary()));
                    row.add(String.valueOf(item.getCorrelative()));

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
    public List<CatalogDto<String, String>> getDefaultCatalog() throws ResourcesNotFoundException {
        LOGGER.debug(String.format("@%s::getCatalog()", this.getClass().getName()));

        return super._getCatalog();
    }

    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "Test.csv");
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                "ID",
                "ITEM NAME",
                "LONG DESCRIPTION",
                "BIRTHDATE",
                "START TIME",
                "LAST LOGIN",
                "SECTION",
                "IS ACTIVE",
                "SALARY",
                "CORRELATIVE"
        ));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, ITEMNAME));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<TestEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);
            IDateTimeFormat timeFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIME);
            IDateTimeFormat timestampFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIMESTAMP);

            for (TestEntity item : items) {
                List<String> row = new LinkedList<>();

                row.add(String.valueOf(item.getId()));
                row.add(item.getItemName());
                row.add(item.getLongDescription());
                row.add(dateFormat.format(item.getBirthdate()));
                row.add(timeFormat.format(item.getStartTime()));
                row.add(timestampFormat.format(item.getLastLogin()));
                row.add(item.getSection());
                row.add(String.valueOf(item.getActive()));
                row.add(String.valueOf(item.getSalary()));
                row.add(String.valueOf(item.getCorrelative()));

                rows.add(row);
            }

            return rows;
        });

        return new CsvViewBuilder().buildCsvFile(model);
    }
}
