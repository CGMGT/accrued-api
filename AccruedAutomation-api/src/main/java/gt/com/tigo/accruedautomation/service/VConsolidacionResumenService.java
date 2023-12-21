package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.VConsolidacionResumenRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.VConsolidacionResumenEntity;
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
public class VConsolidacionResumenService extends AbstractService<VConsolidacionResumenEntity, VConsolidacionResumenRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VConsolidacionResumenService.class);
    public static final String COMPANIA = "compania";
    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification compania = SpecFactory.<VConsolidacionResumenEntity>getLikeSpecification(COMPANIA, getValueAsString(filtersInfo, COMPANIA));
            Specification cuenta = SpecFactory.<VConsolidacionResumenEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(compania)
                    .and(cuenta);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public VConsolidacionResumenEntity create(VConsolidacionResumenEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "ConsolidacionResumen.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "COMPANÍA",
                    "CUENTA",
                    "MONTO GTQ",
                    "MONTO BALANCE",
                    "DIFERENCIA"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, COMPANIA));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<VConsolidacionResumenEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                for (VConsolidacionResumenEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getCompania());
                    row.add(item.getCuenta());
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getMontoBalance()));
                    row.add(String.valueOf(item.getDiferencia()));

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
    public VConsolidacionResumenEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<VConsolidacionResumenEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public VConsolidacionResumenEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<VConsolidacionResumenEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, COMPANIA);
    }

    @Override
    public VConsolidacionResumenEntity update(VConsolidacionResumenEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Consolidacion Resumen.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "COMPANIA",
                    "CUENTA",
                    "MONTO GTQ",
                    "MONTO BALANCE",
                    "DIFERENCIA"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, COMPANIA));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<VConsolidacionResumenEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();


                for (VConsolidacionResumenEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getCompania());
                    row.add(item.getCuenta());


                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getMontoBalance()));
                    row.add(String.valueOf(item.getDiferencia()));

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
}
