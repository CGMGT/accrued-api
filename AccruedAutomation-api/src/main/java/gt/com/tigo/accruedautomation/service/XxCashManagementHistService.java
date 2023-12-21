package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.XxCashManagementHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.XxCashManagmentHistEntity;
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
public class XxCashManagementHistService extends AbstractService<XxCashManagmentHistEntity, XxCashManagementHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxCashManagementHistService.class);
    public static final String PERIODO = "periodo";

    @Autowired
    private ApplicationParameterRepository applicationParameterRepository;

    private final String[] columnas = {
            "ID",
            "PERIODO",
            "BATCH NAME",
            "DOCUMENT SEQUENCE",
            "GJH PERIOD NAME",
            "JOURNAL NAME",
            "XH EVENT TYPE CODE",
            "XH AE HEADER ID",
            "GJL JE LINE NUM",
            "XL CURRENCY CODE",
            "ACCOUNTING LINE CODE",
            "EVENT CLASS CODE",
            "COMPANY",
            "ACCOUNT",
            "LOCAL",
            "CC",
            "TERRITORY",
            "BU",
            "CATEGORY",
            "PRODUCT",
            "PROJECT",
            "INTERCO",
            "FLOW",
            "FUTURE1",
            "FUTURE2",
            "CONCATENATED SEGMENTS",
            "ENTERED DEBITS",
            "ENTERED CREDITS",
            "ENTERED NET",
            "ACCOUNTED CREDITS",
            "ACCOUNTED DEBITS",
            "ACCOUNTED NET",
            "ACCOUNTING DATE",
            "JE SOURCE",
            "JE CATEGORY",
            "LEDGER NAME",
            "TRANSACTION DESCRIPTION",
            "PAYMENT CURRENCY CODE",
            "BANK ACCOUNT NAME",
            "BANK ACCOUNT NUM",
            "CURRENCY CODE",
            "BANK ACCOUNT DESTINATION",
            "BANK ACCOUNT NUM DESTINATION",
            "CASHFLOW DIRECTION",
            "CASHFLOW NUMBER",
            "BANK ACCOUNT STATEMENT DATE"
    };

    private List<String> mapEntityToRow(XxCashManagmentHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getBatchName());
        row.add(item.getDocumentSequence());
        row.add(item.getGjhPeriodName());
        row.add(item.getJournalName());
        row.add(item.getXhEventTypeCode());
        row.add(item.getXhAeHeaderId());
        row.add(item.getGjlJeLineNum());
        row.add(item.getXlCurrencyCode());
        row.add(item.getAccountingLineCode());
        row.add(item.getEventClassCode());
        row.add(item.getCompany());
        row.add(item.getAccount());
        row.add(item.getLocal());
        row.add(item.getCc());
        row.add(item.getTerritory());
        row.add(item.getBu());
        row.add(item.getCategory());
        row.add(item.getProduct());
        row.add(item.getProject());
        row.add(item.getInterco());
        row.add(item.getFlow());
        row.add(item.getFuture1());
        row.add(item.getFuture2());
        row.add(item.getConcatenatedSegments());
        row.add(item.getEnteredDebits());
        row.add(item.getEnteredCredits());
        row.add(item.getEnteredNet());
        row.add(item.getAccountedCredits());
        row.add(item.getAccountedDebits());
        row.add(item.getAccountedNet());
        row.add(item.getAccountingDate());
        row.add(item.getJeSource());
        row.add(item.getJeCategory());
        row.add(item.getLedgerName());
        row.add(item.getTransactionDescription());
        row.add(item.getPaymentCurrencyCode());
        row.add(item.getBankAccountName());
        row.add(item.getBankAccountNum());
        row.add(item.getCurrencyCode());
        row.add(item.getBankAccountDestination());
        row.add(item.getBankAccountNumDestination());
        row.add(item.getCashflowDirection());
        row.add(item.getCashflowNumber());
        row.add(item.getBankAccountStatementDate());

        return row;
    }

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification periodSpec;

            if (filtersInfo.containsKey(PERIODO)) {
                periodSpec = SpecFactory.<XxCashManagmentHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxCashManagmentHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
            }

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(periodSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "CashManagement.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxCashManagmentHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxCashManagmentHistEntity item : items) {
                rows.add(this.mapEntityToRow(item));
            }

            return rows;
        });

        return new CsvViewBuilder().buildCsvFile(model);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "CashManagement.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxCashManagmentHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxCashManagmentHistEntity item : items) {
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

    @Override
    public XxCashManagmentHistEntity create(XxCashManagmentHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public XxCashManagmentHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxCashManagmentHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxCashManagmentHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxCashManagmentHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxCashManagmentHistEntity update(XxCashManagmentHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }
}
