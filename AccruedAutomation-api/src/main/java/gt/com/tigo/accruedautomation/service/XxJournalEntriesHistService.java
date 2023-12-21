package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ApplicationParameterRepository;
import gt.com.tigo.accruedautomation.dao.XxJournalEntriesHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.XxJournalEntriesHistEntity;
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
public class XxJournalEntriesHistService extends AbstractService<XxJournalEntriesHistEntity, XxJournalEntriesHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(XxJournalEntriesHistService.class);
    public static final String PERIODO = "periodo";
    @Autowired
    private ApplicationParameterRepository applicationParameterRepository;

    private final String[] columnas = {
            "ID",
            "PERIODO",
            "FCT DT",
            "LDGR NM",
            "DC SQNC VL",
            "LDGR ID",
            "JRNL NMBR",
            "LST UPDT DT",
            "JE CTGRY",
            "JE SRC",
            "PRD DD",
            "NM DD",
            "CRRNCY CD",
            "STTS DD",
            "DT CRTD",
            "ACTL FLG",
            "BLNCD JE FLG",
            "JE BTCH ID",
            "PSTD DT",
            "DSCRPTN GL",
            "RNNG TTL DR",
            "RNNG TTL CR",
            "RNNG TTL ACCNTD DR",
            "RNNG TTL ACCNTD CR",
            "CRTD BY",
            "LST UPDTD BY",
            "EFFCTV DT",
            "JE LN NMBR",
            "ENTRD DR",
            "ENTRD CR",
            "ENTRD NT",
            "ACCNTD DR",
            "ACCNTD CR",
            "ACCNTD NT",
            "DSCRPTN GH",
            "CMPNY DD",
            "ACCNT DD",
            "LCL DD",
            "CC DD",
            "TRRTRY DD",
            "BU DD",
            "CTGRY DD",
            "PRDCT DD",
            "PRJCT DD",
            "INTRC DD",
            "FLW DD",
            "FTR1 DD",
            "FTR2 DD",
            "PPN DT",
            "SOURCE",
            "JRNAL STD FLG"
    };

    private List<String> mapEntityToRow(XxJournalEntriesHistEntity item) {
        List<String> row = new LinkedList<>();

        row.add(String.valueOf(item.getId()));
        row.add(item.getPeriodo());
        row.add(item.getFctDt());
        row.add(item.getLdgrNm());
        row.add(item.getDcSqncVl());
        row.add(item.getLdgrId());
        row.add(item.getJrnlNmbr());
        row.add(item.getLstUpdtDt());
        row.add(item.getJeCtgry());
        row.add(item.getJeSrc());
        row.add(item.getPrdDd());
        row.add(item.getNmDd());
        row.add(item.getCrrncyCd());
        row.add(item.getSttsDd());
        row.add(item.getDtCrtd());
        row.add(item.getActlFlg());
        row.add(item.getBlncdJeFlg());
        row.add(item.getJeBtchId());
        row.add(item.getPstdDt());
        row.add(item.getDscrptnGl());
        row.add(item.getRnngTtlDr());
        row.add(item.getRnngTtlCr());
        row.add(item.getRnngTtlAccntdDr());
        row.add(item.getRnngTtlAccntdCr());
        row.add(item.getCrtdBy());
        row.add(item.getLstUpdtdBy());
        row.add(item.getEffctvDt());
        row.add(item.getJeLnNmbr());
        row.add(item.getEntrdDr());
        row.add(item.getEntrdCr());
        row.add(item.getEntrdNt());
        row.add(item.getAccntdDr());
        row.add(item.getAccntdCr());
        row.add(item.getAccntdNt());
        row.add(item.getDscrptnGh());
        row.add(item.getCmpnyDd());
        row.add(item.getAccntDd());
        row.add(item.getLclDd());
        row.add(item.getCcDd());
        row.add(item.getTrrtryDd());
        row.add(item.getBuDd());
        row.add(item.getCtgryDd());
        row.add(item.getPrdctDd());
        row.add(item.getPrjctDd());
        row.add(item.getIntrcDd());
        row.add(item.getFlwDd());
        row.add(item.getFtr1Dd());
        row.add(item.getFtr2Dd());
        row.add(item.getPpnDt());
        row.add(item.getSource());
        row.add(item.getJrnalStdFlg());

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
                periodSpec = SpecFactory.<XxJournalEntriesHistEntity>getLikeSpecification(PERIODO, getValueAsString(filtersInfo, PERIODO));
            } else {
                periodSpec = SpecFactory.<XxJournalEntriesHistEntity>getLikeSpecification(PERIODO, this.applicationParameterRepository.findByCodigo("PERIODO").getValor());
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
    public XxJournalEntriesHistEntity create(XxJournalEntriesHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "JournalEntries.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<XxJournalEntriesHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (XxJournalEntriesHistEntity item : items) {
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
    public XxJournalEntriesHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<XxJournalEntriesHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public XxJournalEntriesHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<XxJournalEntriesHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        return null;
    }

    @Override
    public XxJournalEntriesHistEntity update(XxJournalEntriesHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "JournalEntries.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(columnas));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<XxJournalEntriesHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (XxJournalEntriesHistEntity item : items) {
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
