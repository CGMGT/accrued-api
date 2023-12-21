package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.XxBalanceHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.XxBalanceHistEntity;
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
public class XxBalanceHistService extends AbstractService<XxBalanceHistEntity, XxBalanceHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxBalanceHistService.class);
    public static final String PERIODO = "periodo";
    @Autowired
    private ApplicationParameterRepository applicationParameterRepository;

    private final String[] columnas = {
            "ID",
            "PERIODO",
            "FCT DT",
            "PRD CD",
            "CMPNY CD",
            "ACCNTNG ACCNT CD",
            "LCL ACCNT CD",
            "CST CNTR CD",
            "TRRTRY CD",
            "BSNSS UNT EBS CD",
            "CTGRY CD",
            "PRDCT CD",
            "PRJCT CD",
            "INTRCMPNY CD",
            "FLW CD",
            "FTR1 CD",
            "FTR2 CD",
            "BGN BLNC AMNT",
            "PRD NT AMNT",
            "CLSNG BLNC AMNT",
            "CRRNCY CD",
            "LDGR NM",
            "LDGR CTGRY CD",
            "PPN DT"
    };

    private List<String> mapEntityToRow(XxBalanceHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getFctDt());
        row.add(item.getPrdCd());
        row.add(item.getCmpnyCd());
        row.add(item.getAccntngAccntCd());
        row.add(item.getLclAccntCd());
        row.add(item.getCstCntrCd());
        row.add(item.getTrrtryCd());
        row.add(item.getBsnssUntEbsCd());
        row.add(item.getCtgryCd());
        row.add(item.getPrdctCd());
        row.add(item.getPrjctCd());
        row.add(item.getIntrcmpnyCd());
        row.add(item.getFlwCd());
        row.add(item.getFtr1Cd());
        row.add(item.getFtr2Cd());
        row.add(item.getBgnBlncAmnt());
        row.add(item.getPrdNtAmnt());
        row.add(item.getClsngBlncAmnt());
        row.add(item.getCrrncyCd());
        row.add(item.getLdgrNm());
        row.add(item.getLdgrCtgryCd());
        row.add(item.getPpnDt());

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
                periodSpec = SpecFactory.<XxBalanceHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxBalanceHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
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
    public XxBalanceHistEntity create(XxBalanceHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "Balance.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxBalanceHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxBalanceHistEntity item : items) {
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
    public XxBalanceHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxBalanceHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxBalanceHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxBalanceHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxBalanceHistEntity update(XxBalanceHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Balance.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxBalanceHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxBalanceHistEntity item : items) {
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
