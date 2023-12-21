package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.VRepAccruedHistoricoRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.VRepAccruedHistoricoEntity;
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

@Service
public class VRepAccruedHistoricoService extends AbstractService<VRepAccruedHistoricoEntity, VRepAccruedHistoricoRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VRepAccruedHistoricoService.class);

    private static final String TABLE_NAME = "v_rep_accrued_historico";
    public static final String MODULO = "modulo";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<VRepAccruedHistoricoEntity>getEqualSpecification("id", getValueAsDouble(filtersInfo, "id"));
            Specification moduloSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification(MODULO, getValueAsString(filtersInfo, MODULO));
            Specification cuentaSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("cuenta", getValueAsString(filtersInfo, "cuenta"));
            Specification companiaSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("compania", getValueAsString(filtersInfo, "compania"));
            Specification poSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("po", getValueAsString(filtersInfo, "po"));
            Specification monedaSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification periodoSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("periodo", getValueAsString(filtersInfo, "periodo"));
            Specification statusVigenteSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("statusIntegracion", "VIGENTE");
            Specification statusLiquidadoSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("statusIntegracion", getValueAsString(filtersInfo, "liquidado"));
            Specification proveedorSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification kpiSpec = SpecFactory.<VRepAccruedHistoricoEntity>getLikeSpecification("kpi", getValueAsString(filtersInfo, "kpi"));
            Specification montoSpec = SpecFactory.<VRepAccruedHistoricoEntity>getEqualSpecification("monto", getValueAsDouble(filtersInfo, "monto"));
            Specification montoGtqSpec = SpecFactory.<VRepAccruedHistoricoEntity>getEqualSpecification("montoGtq", getValueAsDouble(filtersInfo, "montoGtq"));

            String statusLiquidadoValue = getValueAsString(filtersInfo, "liquidado");


            Specification statusSpec;

            if(statusLiquidadoValue == null){
                statusSpec = Specification
                        .where(statusVigenteSpec);

            }else{
                statusSpec = Specification
                        .where(statusVigenteSpec)
                        .or(statusLiquidadoSpec);
            }

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(moduloSpec)
                    .and(cuentaSpec)
                    .and(poSpec)
                    .and(periodoSpec)
                    .and(monedaSpec)
                    .and(statusSpec)
                    .and(companiaSpec)
                    .and(proveedorSpec)
                    .and(kpiSpec)
                    .and(montoSpec)
                    .and(montoGtqSpec);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public VRepAccruedHistoricoEntity create(VRepAccruedHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();
        List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);
        List<String> columnsName = columnsToExport;
        Collections.replaceAll(columnsName, "mayor1Anio", "umbral");

        model.put(CsvViewBuilder.KEY_FILENAME, "HistoricoIntegracion.csv");
        model.put(CsvViewBuilder.KEY_ATTACH_TIMESTAMP, true);

        model.put(CsvViewBuilder.KEY_COLUMNS, columnsName);
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<VRepAccruedHistoricoEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            for (VRepAccruedHistoricoEntity item : items) {
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
    public VRepAccruedHistoricoEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<VRepAccruedHistoricoEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public VRepAccruedHistoricoEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<VRepAccruedHistoricoEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, MODULO);
    }

    @Override
    public VRepAccruedHistoricoEntity update(VRepAccruedHistoricoEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();
            List<String> columnsToExport = getColumnsToExport(dataTableRequestDto, TABLE_NAME);
            List<String> columnsName = columnsToExport;
            Collections.replaceAll(columnsName, "mayor1Anio", "umbral");

            model.put(XlsxViewBuilder.KEY_FILENAME, "HistoricoIntegracion.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, columnsName);
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<VRepAccruedHistoricoEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();


                for (VRepAccruedHistoricoEntity item : items) {
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
