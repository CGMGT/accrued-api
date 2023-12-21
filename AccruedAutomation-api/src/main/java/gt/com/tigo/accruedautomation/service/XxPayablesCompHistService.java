package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;

import gt.com.tigo.accruedautomation.dao.XxPayablesCompHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;

import gt.com.tigo.accruedautomation.model.XxPayablesCompHistEntity;
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
public class XxPayablesCompHistService extends AbstractService<XxPayablesCompHistEntity, XxPayablesCompHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxPayablesCompHistService.class);
    public static final String PERIODO = "periodo";
    @Autowired
    private ApplicationParameterRepository applicationParameterRepository;

    private final String[] columnas = {
            "ID",
            "PERIODO",
            "COMPANY",
            "RECEIPT CREATION DATE",
            "INVOICE CURRENCY CODE",
            "AMOUNT",
            "INVOICE NUM",
            "BASE AMOUNT",
            "QUANTITY INVOICED",
            "UNIT PRICE",
            "ACCOUNTING DATE",
            "RECEIPT NUM",
            "LINE NUM",
            "PO LINE",
            "SHIPMENT LINE STATUS CODE",
            "ORG NAME",
            "OPERATING UNIT",
            "PO NUM",
            "VENDOR NAME",
            "VENDOR SITE CODE",
            "LINE TYPE LOOKUP CODE"
    };

    private List<String> mapEntityToRow(XxPayablesCompHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getCompany());
        row.add(item.getReceiptCreationDate());
        row.add(item.getInvoiceCurrencyCode());
        row.add(item.getAmount());
        row.add(item.getInvoiceNum());
        row.add(item.getBaseAmount());
        row.add(item.getQuantityInvoiced());
        row.add(item.getUnitPrice());
        row.add(item.getAccountingDate());
        row.add(item.getReceiptNum());
        row.add(item.getLineNum());
        row.add(item.getPoLine());
        row.add(item.getShipmentLineStatusCode());
        row.add(item.getOrgName());
        row.add(item.getOperatingUnit());
        row.add(item.getPoNum());
        row.add(item.getVendorName());
        row.add(item.getVendorSiteCode());
        row.add(item.getLineTypeLookupCode());

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
                periodSpec = SpecFactory.<XxPayablesCompHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxPayablesCompHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
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
    public XxPayablesCompHistEntity create(XxPayablesCompHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "PayablesComp.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxPayablesCompHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxPayablesCompHistEntity item : items) {
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
    public XxPayablesCompHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxPayablesCompHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxPayablesCompHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxPayablesCompHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxPayablesCompHistEntity update(XxPayablesCompHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "PayablesComp.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxPayablesCompHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxPayablesCompHistEntity item : items) {
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
