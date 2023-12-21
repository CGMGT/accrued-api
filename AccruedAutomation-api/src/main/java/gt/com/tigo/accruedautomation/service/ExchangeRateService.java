package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ExchangeRateRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.TiposCambioEntity;
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
import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;

@Service
public class ExchangeRateService extends AbstractService<TiposCambioEntity, ExchangeRateRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateService.class);
    private static final String FECHA = "fecha";
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification fechaSpec = SpecFactory.<TiposCambioEntity>getBetweenSpecification(FECHA, getValueAsDate(filtersInfo, FECHA), getValueAsDate(filtersInfo, FECHA));
            Specification monedaSpec = SpecFactory.<TiposCambioEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification simboloSpec = SpecFactory.<TiposCambioEntity>getLikeSpecification("simbolo", getValueAsString(filtersInfo, "simbolo"));
            Specification referenciaSpec = SpecFactory.<TiposCambioEntity>getEqualSpecification("referencia", getValueAsDouble(filtersInfo, "referencia"));
            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(fechaSpec)
                    .and(monedaSpec)
                    .and(simboloSpec)
                    .and(referenciaSpec)
                    ;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public TiposCambioEntity create(TiposCambioEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "TiposCambio.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "MONEDA",
                    "SÍMBOLO",
                    "FECHA",
                    "REFERENCIA",
                    "FECHA CREACIÓN",
                    "ESTADO"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, FECHA));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<TiposCambioEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (TiposCambioEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getMoneda());
                    row.add(item.getSimbolo());
                    row.add(dateFormat.format(item.getFecha()));
                    row.add(String.valueOf(item.getReferencia()));
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getEstado());

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
    public TiposCambioEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<TiposCambioEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public TiposCambioEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<TiposCambioEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        if (dataTableRequestDto.getSorted() == null || dataTableRequestDto.getSorted().isEmpty()) {
            List<SortInfoDto> sortInfoList = new ArrayList();

            sortInfoList.add(new SortInfoDto(FECHA, true));

            dataTableRequestDto.setSorted(sortInfoList);
        }

        return super._findByPage(dataTableRequestDto, FECHA);
    }

    @Override
    public TiposCambioEntity update(TiposCambioEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "TiposCambio.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "MONEDA",
                    "SÍMBOLO",
                    "FECHA",
                    "REFERENCIA",
                    "FECHA CREACIÓN",
                    "ESTADO"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, FECHA));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<TiposCambioEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (TiposCambioEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getMoneda());
                    row.add(item.getSimbolo());
                    row.add(dateFormat.format(item.getFecha()));
                    row.add(String.valueOf(item.getReferencia()));
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getEstado());



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

    public TiposCambioEntity findCurrent() throws ResourceNotFoundException {
        LOGGER.debug(String.format("@%s::findCurrent()", this.getClass().getName()));

        Date today = new Date();

        TiposCambioEntity entity = this.exchangeRateRepository.findByFecha(new java.sql.Date(today.getTime()));

        if (entity == null) {
            throw new ResourceNotFoundException();
        }

        return entity;
    }

    public List<Object> getExchangeRateLast7Days() {
        LOGGER.debug(String.format("@%s::getExchangeRateLast7Days()", this.getClass().getName()));

        return this.exchangeRateRepository.getExchangeRateLast7Days();
    }
}
