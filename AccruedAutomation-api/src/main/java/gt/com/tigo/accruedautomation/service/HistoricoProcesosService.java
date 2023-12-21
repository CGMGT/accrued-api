package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.HistoricoProcesosRepository;
import gt.com.tigo.accruedautomation.dto.*;
import gt.com.tigo.accruedautomation.model.HistoricoProcesosEntity;
import gt.com.tigo.accruedautomation.util.*;
import gt.com.tigo.accruedautomation.util.exception.*;
import gt.com.tigo.accruedautomation.util.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class HistoricoProcesosService extends AbstractService<HistoricoProcesosEntity, HistoricoProcesosRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosService.class);
    private static final String NOMBRE = "nombre";
    private static final String FECHAINICIALEJEC = "fechaInicialEjecucion";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification nombreSpec = SpecFactory.<HistoricoProcesosEntity>getLikeSpecification(NOMBRE, getValueAsString(filtersInfo, NOMBRE));
            Specification descripcionSpec = SpecFactory.<HistoricoProcesosEntity>getLikeSpecification("descripcion", getValueAsString(filtersInfo, "descripcion"));
            Specification usuarioEjecucionSpec = SpecFactory.<HistoricoProcesosEntity>getLikeSpecification("usuarioEjecucion", getValueAsString(filtersInfo, "usuarioEjecucion"));
            Specification fechaInicialEjecucionSpec = SpecFactory.<HistoricoProcesosEntity>getBetweenSpecification(FECHAINICIALEJEC, getValueAsZonedDate(filtersInfo, "startDate"), getValueAsZonedDate(filtersInfo, "endDate"));
            Specification estadoSpec = SpecFactory.<HistoricoProcesosEntity>getLikeSpecification("estado", getValueAsString(filtersInfo, "estado"));

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(nombreSpec)
                    .and(descripcionSpec)
                    .and(usuarioEjecucionSpec)
                    .and(fechaInicialEjecucionSpec)
                    .and(estadoSpec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public HistoricoProcesosEntity create(HistoricoProcesosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "HistoricoProcesos.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "NOMBRE",
                    "DESCRIPCION",
                    "ESTADO",
                    "FECHA INICIAL EJECUCION",
                    "FECHA FINAL EJECUCION",
                    "TIEMPO EJECUCION",
                    "NUMERO REGISTROS CARGADOS",
                    "USUARIO EJECUCION",
                    "STATUS RESULTADO",
                    "COMENTARIOS"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, NOMBRE));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<HistoricoProcesosEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (HistoricoProcesosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getNombre());
                    row.add(item.getDescripcion());
                    row.add(item.getEstado());
                    row.add(dateFormat.format(item.getFechaInicialEjecucion()));
                    row.add(dateFormat.format(item.getFechaFinalEjecucion()));
                    row.add(String.valueOf(item.getTiempoEjecucion()));
                    row.add(String.valueOf(item.getNumRegistrosCargados()));
                    row.add(item.getUsuarioEjecucion());
                    row.add(item.getStatusResultado());
                    row.add(item.getCommentsResultado());

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
    public HistoricoProcesosEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<HistoricoProcesosEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public HistoricoProcesosEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<HistoricoProcesosEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, FECHAINICIALEJEC, Sort.Direction.DESC);
    }

    @Override
    public HistoricoProcesosEntity update(HistoricoProcesosEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "HistoricoProcesos.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "NOMBRE",
                    "DESCRIPCION",
                    "ESTADO",
                    "FECHA INICIAL EJECUCION",
                    "FECHA FINAL EJECUCION",
                    "TIEMPO EJECUCION",
                    "NUMERO REGISTROS CARGADOS",
                    "USUARIO EJECUCION",
                    "STATUS RESULTADO",
                    "COMENTARIOS"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, FECHAINICIALEJEC));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<HistoricoProcesosEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (HistoricoProcesosEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getNombre());
                    row.add(item.getDescripcion());
                    row.add(item.getEstado());
                    row.add(dateFormat.format(item.getFechaInicialEjecucion()));
                    row.add(dateFormat.format(item.getFechaFinalEjecucion()));
                    row.add(String.valueOf(item.getTiempoEjecucion()));
                    row.add(String.valueOf(item.getNumRegistrosCargados()));
                    row.add(item.getUsuarioEjecucion());
                    row.add(item.getStatusResultado());
                    row.add(item.getCommentsResultado());

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

    public List<CatalogDto<String, String>> getStatus() throws ResourcesNotFoundException{
        LOGGER.debug(String.format("@%s::getStatus()", this.getClass().getName()));

        List<Object> entities = this.repository.getStatus();

        if (entities == null) {
            throw new ResourcesNotFoundException();
        }

        List<CatalogDto<String, String>> entries = entities.stream()
                .map(item -> (Object[]) item)
                .map(item -> new CatalogDto<String, String>(item[0].toString(), item[1].toString()))
                .collect(Collectors.toList());

        return entries;

    }

    public List<Object> getUserProcesos(String usuario){
        LOGGER.debug(String.format("@%s::getUserProcesos(%s)", this.getClass().getName(), usuario));
        return this.repository.getUserProcesos(usuario);
    }

    public List<Object> getNombreProceso(String nombre){
        LOGGER.debug(String.format("@%s::getNombreProceso(%s)", this.getClass().getName(), nombre));
        return this.repository.getNombreProceso(nombre);
    }

    public TigoResponseDto getMostRecentProcess(String typeProcess){
        LOGGER.debug(String.format("@%s::getMostRecentProcess(%s)", this.getClass().getName(), typeProcess));
        List<HistoricoProcesosEntity> mostRecentSuccessValidation;
        List<HistoricoProcesosEntity> mostRecentSuccessProcess;

        if(typeProcess.equals("Consolidacion")){
            mostRecentSuccessValidation = this.repository.getSuccessValidation("Validación de Consolidación");
            mostRecentSuccessProcess = this.repository.getSuccessProcess("Consolidación", "Validación de Consolidación");

            return new TigoResponseDto(
                    0,
                    mostRecentSuccessValidation.size() > 0 && mostRecentSuccessProcess.size() > 0 ? "Los registros de consolidación para el período actual ya han sido procesados." : "",
                    mostRecentSuccessValidation.size() > 0 && mostRecentSuccessProcess.size() == 0);

        }else if( typeProcess.equals("Integracion")){
            mostRecentSuccessValidation = this.repository.getSuccessValidation("Validación de Integración");
            mostRecentSuccessProcess = this.repository.getSuccessProcess("Integración", "Validación de Integración");

            return new TigoResponseDto(
                    0,
                    mostRecentSuccessValidation.size() > 0 && mostRecentSuccessProcess.size() > 0 ? "Los registros de integración para el período actual ya han sido procesados." : "",
                    mostRecentSuccessValidation.size() > 0 && mostRecentSuccessProcess.size() == 0
            );

        }else{
            return new TigoResponseDto(false);
        }
    }
}
