package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;

import gt.com.tigo.accruedautomation.dao.XxCostHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;

import gt.com.tigo.accruedautomation.model.XxCostHistEntity;
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
public class XxCostHistService extends AbstractService<XxCostHistEntity, XxCostHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxCostHistService.class);
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
            "JE CATEGORY",
            "XH EVENT TYPE CODE",
            "XL CURRENCY CODE",
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
            "PO NUMBER",
            "RECEIPT NUMBER",
            "DOCUMENT DESCRIPTION",
            "DOCUMENT DATE",
            "PARTY NAME",
            "EXCHANGE RATE",
            "SOURCE DOC QUANTITY",
            "ITEM",
            "ITEM DESCRIPTION",
            "LEDGER NAME",
            "COMMENTS",
            "PO STATUS",
            "PO CURRENCY CODE",
            "COMBINACION CONTABLE PO",
            "PO COMPANY",
            "PO ACCOUNT",
            "PO LOCAL",
            "PO CC",
            "PO TERRITORY",
            "PO BU",
            "PO CATEGORY",
            "PO PRODUCT",
            "PO PROJECT",
            "PO INTERCO",
            "PO FLOW",
            "PO FUTURE1",
            "PO FUTURE2",
            "FECHA MODIFICACION PO",
            "PR LINE NUM",
            "UOM",
            "QUANTITY",
            "UNIT COST",
            "REQUESTER EMAIL",
            "REQUISITION NUMBER",
            "DESCRIPTION",
            "REQ STATUS",
            "REQUISITION TYPE",
            "CREATOR NAME",
            "CREATOR EMAIL",
            "TRANSACTION DATE",
            "TRANSACTION TYPE NAME",
            "TRANSACTION REFERENCE",
            "TRANSACTION ID",
            "ORGANIZATION NAME"
    };

    private List<String> mapEntityToRow(XxCostHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getBatchName());
        row.add(item.getDocumentSequence());
        row.add(item.getGjhPeriodName());
        row.add(item.getJournalName());
        row.add(item.getJeCategory());
        row.add(item.getXhEventTypeCode());
        row.add(item.getXlCurrencyCode());
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
        row.add(item.getPoNumber());
        row.add(item.getReceiptNumber());
        row.add(item.getDocumentDescription());
        row.add(item.getDocumentDate());
        row.add(item.getPartyName());
        row.add(item.getExchangeRate());
        row.add(item.getSourceDocQuantity());
        row.add(item.getItem());
        row.add(item.getItemDescription());
        row.add(item.getLedgerName());
        row.add(item.getComments());
        row.add(item.getPoStatus());
        row.add(item.getPoCurrencyCode());
        row.add(item.getCombinacionContablePo());
        row.add(item.getPoCompany());
        row.add(item.getPoAccount());
        row.add(item.getPoLocal());
        row.add(item.getPoCc());
        row.add(item.getPoTerritory());
        row.add(item.getPoBu());
        row.add(item.getPoCategory());
        row.add(item.getPoProduct());
        row.add(item.getPoProject());
        row.add(item.getPoInterco());
        row.add(item.getPoFlow());
        row.add(item.getPoFuture1());
        row.add(item.getPoFuture2());
        row.add(item.getFechaModificacionPo());
        row.add(item.getPrLineNum());
        row.add(item.getUom());
        row.add(item.getQuantity());
        row.add(item.getUnitCost());
        row.add(item.getRequesterEmail());
        row.add(item.getRequisitionNumber());
        row.add(item.getDescription());
        row.add(item.getReqStatus());
        row.add(item.getRequisitionType());
        row.add(item.getCreatorName());
        row.add(item.getCreatorEmail());
        row.add(item.getTransactionDate());
        row.add(item.getTransactionTypeName());
        row.add(item.getTransactionReference());
        row.add(item.getTransactionId());
        row.add(item.getOrganizationName());

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
                periodSpec = SpecFactory.<XxCostHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxCostHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
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
    public XxCostHistEntity create(XxCostHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "CostManagement.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxCostHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxCostHistEntity item : items) {
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
    public XxCostHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxCostHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxCostHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxCostHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxCostHistEntity update(XxCostHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "CostManagement.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxCostHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxCostHistEntity item : items) {
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
