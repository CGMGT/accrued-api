package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.VRepAccruedConsolidadoHistRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.VRepAccruedConsolidadoHistEntity;
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

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;

@Service
public class VRepAccruedConsolidadoHistService extends AbstractService<VRepAccruedConsolidadoHistEntity, VRepAccruedConsolidadoHistRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VRepAccruedConsolidadoHistService.class);

    private static final String TABLE_NAME = "v_rep_accrued_consolidado_hist";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification companiaSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("compania", getValueAsString(filtersInfo, "compania"));
            Specification moduloSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("modulo", getValueAsString(filtersInfo, "modulo"));
            Specification cuentaSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification conceptoSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification poSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification proveedorSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification monedaSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification montoSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getEqualSpecification("monto", getValueAsDouble(filtersInfo, "monto"));
            Specification montoGtqSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getEqualSpecification("montoGtq", getValueAsDouble(filtersInfo, "montoGtq"));
            Specification periodoSpec = SpecFactory.<VRepAccruedConsolidadoHistEntity>getLikeSpecification("periodo", getValueAsString(filtersInfo, "periodo"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(companiaSpec)
                    .and(moduloSpec)
                    .and(cuentaSpec)
                    .and(conceptoSpec)
                    .and(poSpec)
                    .and(proveedorSpec)
                    .and(monedaSpec)
                    .and(montoSpec)
                    .and(montoGtqSpec)
                    .and(periodoSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public VRepAccruedConsolidadoHistEntity create(VRepAccruedConsolidadoHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();
        List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);

        model.put(CsvViewBuilder.KEY_FILENAME, "HistoricoConsolidado.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);
        model.put(CsvViewBuilder.KEY_COLUMNS, columnsToExport);
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<VRepAccruedConsolidadoHistEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (VRepAccruedConsolidadoHistEntity item : items) {
                rows.add(this.mapEntityToRow(item, columnsToExport));
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
    public VRepAccruedConsolidadoHistEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<VRepAccruedConsolidadoHistEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public VRepAccruedConsolidadoHistEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<VRepAccruedConsolidadoHistEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public VRepAccruedConsolidadoHistEntity update(VRepAccruedConsolidadoHistEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();
            List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);

            model.put(XlsxViewBuilder.KEY_FILENAME, "HistoricoConsolidado.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, columnsToExport);
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<VRepAccruedConsolidadoHistEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                for (VRepAccruedConsolidadoHistEntity item : items) {
                    rows.add(this.mapEntityToRow(item, columnsToExport).toArray());
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
