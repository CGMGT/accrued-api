package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.EmpleadosRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.EmpleadosEntity;
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
public class EmpleadosService extends AbstractService<EmpleadosEntity, EmpleadosRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosService.class);
    private static final String NOMBREEMP = "nombreEmpleado";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification codigo = SpecFactory.<EmpleadosEntity>getLikeSpecification("codigo", getValueAsString(filtersInfo, "codigo"));
            Specification nombreEmpleado = SpecFactory.<EmpleadosEntity>getLikeSpecification(NOMBREEMP, getValueAsString(filtersInfo, NOMBREEMP));
            Specification correoTigo = SpecFactory.<EmpleadosEntity>getLikeSpecification("correoTigo", getValueAsString(filtersInfo, "correoTigo"));
            Specification nombreJefe = SpecFactory.<EmpleadosEntity>getLikeSpecification("nombreJefe", getValueAsString(filtersInfo, "nombreJefe"));
            Specification correoJefe = SpecFactory.<EmpleadosEntity>getLikeSpecification("correoJefe", getValueAsString(filtersInfo, "correoJefe"));
            Specification unidadDeNegocio = SpecFactory.<EmpleadosEntity>getLikeSpecification("unidadDeNegocio", getValueAsString(filtersInfo, "unidadDeNegocio"));
            Specification estado = SpecFactory.<EmpleadosEntity>getLikeSpecification("estado", getValueAsString(filtersInfo, "estado"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(codigo)
                    .and(nombreEmpleado)
                    .and(correoTigo)
                    .and(nombreJefe)
                    .and(correoJefe)
                    .and(unidadDeNegocio)
                    .and(estado);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public EmpleadosEntity create(EmpleadosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "Empleados.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "CODIGO",
                    "ESTADO",
                    "NOMBRE EMPLEADO",
                    "CORREO TIGO",
                    "NOMBRE JEFE",
                    "CORREO JEFE",
                    "UNIDAD NEGOCIO"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, NOMBREEMP));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<EmpleadosEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();


                for (EmpleadosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getCodigo());
                    row.add(item.getEstado());

                    row.add(item.getNombreEmpleado());
                    row.add(item.getCorreoTigo());
                    row.add(item.getNombreJefe());
                    row.add(item.getCorreoJefe());
                    row.add(item.getUnidadDeNegocio());

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
    public EmpleadosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<EmpleadosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public EmpleadosEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<EmpleadosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, NOMBREEMP);
    }

    @Override
    public EmpleadosEntity update(EmpleadosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Empleados.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "CODIGO",
                    "ESTADO",
                    "NOMBRE EMPLEADO",
                    "CORREO TIGO",
                    "NOMBRE JEFE",
                    "CORREO JEFE",
                    "UNIDAD NEGOCIO"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, NOMBREEMP));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<EmpleadosEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();


                for (EmpleadosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getCodigo());
                    row.add(item.getEstado());

                    row.add(item.getNombreEmpleado());
                    row.add(item.getCorreoTigo());
                    row.add(item.getNombreJefe());
                    row.add(item.getCorreoJefe());
                    row.add(item.getUnidadDeNegocio());

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

    public List<Object> getEmployeesEmail(String name){
        LOGGER.debug(String.format("@%s::getEmployeesEmail(%s)", this.getClass().getName(), name));
        return this.repository.getEmployeesEmail(name);
    }
}
