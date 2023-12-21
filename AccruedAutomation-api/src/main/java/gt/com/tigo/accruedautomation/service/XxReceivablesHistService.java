package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.XxReceivablesHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.XxReceivablesHistEntity;
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
public class XxReceivablesHistService extends AbstractService<XxReceivablesHistEntity, XxReceivablesHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxReceivablesHistService.class);
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
            "RECEIPT NUMBER",
            "RECEIPT DATE",
            "ADJUSTMENT DOCUMENT NUMBER",
            "DEPOSIT DATE",
            "TYPE",
            "STATUS",
            "CURRENCY CODE",
            "OPERATING UNIT",
            "RECEIPT METHOD",
            "BANK ACCOUNT",
            "BANK NAME",
            "BANK BRANCH NAME",
            "LEGAL ENTITY",
            "CREATED BY",
            "EMAIL CREATED",
            "LAST UPDATE BY",
            "EMAIL UPDATED"
    };

    private List<String> mapEntityToRow(XxReceivablesHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getBatchName());
        row.add(item.getDocumentSequence());
        row.add(item.getGjhPeriodName());
        row.add(item.getJournalName());
        row.add(item.getXhEventTypeCode());
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
        row.add(item.getReceiptNumber());
        row.add(item.getReceiptDate());
        row.add(item.getAdjustmentDocumentNumber());
        row.add(item.getDepositDate());
        row.add(item.getType());
        row.add(item.getStatus());
        row.add(item.getCurrencyCode());
        row.add(item.getOperatingUnit());
        row.add(item.getReceiptMethod());
        row.add(item.getBankAccount());
        row.add(item.getBankName());
        row.add(item.getBankBranchName());
        row.add(item.getLegalEntity());
        row.add(item.getCreatedBy());
        row.add(item.getEmailCreated());
        row.add(item.getLastUpdateBy());
        row.add(item.getEmailUpdated());

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
                periodSpec = SpecFactory.<XxReceivablesHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxReceivablesHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
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
    public XxReceivablesHistEntity create(XxReceivablesHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "Receivables.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxReceivablesHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxReceivablesHistEntity item : items) {
                rows.add(this.mapEntityToRow(item));
            }

            return rows;
        });

        return new CsvViewBuilder().buildCsvFile(model);
    }

    @Override
    public boolean deleteById(Long entityId) throws ResourceDeleteException {
        return false;
    }

    @Override
    public XxReceivablesHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxReceivablesHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxReceivablesHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxReceivablesHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxReceivablesHistEntity update(XxReceivablesHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Receivables.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxReceivablesHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxReceivablesHistEntity item : items) {
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
