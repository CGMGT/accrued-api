package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.ScheduledNotificationsRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.NotificacionesEntity;
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

import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getValueAsString;

@Service
public class ScheduledNotificationsServices extends AbstractService<NotificacionesEntity, ScheduledNotificationsRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledNotificationsServices.class);
    public static final String STATUS = "status";

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification periodo = SpecFactory.<NotificacionesEntity>getLikeSpecification("periodo", getValueAsString(filtersInfo, "periodo"));
            Specification statusFecha1 = SpecFactory.<NotificacionesEntity>getLikeSpecification("statusFecha1", getValueAsString(filtersInfo, "statusFecha1"));
            Specification statusFecha2 = SpecFactory.<NotificacionesEntity>getLikeSpecification("statusFecha2", getValueAsString(filtersInfo, "statusFecha2"));
            Specification statusFecha3 = SpecFactory.<NotificacionesEntity>getLikeSpecification("statusFecha3", getValueAsString(filtersInfo, "statusFecha3"));
            Specification statusFecha4 = SpecFactory.<NotificacionesEntity>getLikeSpecification("statusFecha4", getValueAsString(filtersInfo, "statusFecha4"));
            Specification status = SpecFactory.<NotificacionesEntity>getLikeSpecification(STATUS, getValueAsString(filtersInfo, STATUS));
            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(periodo)
                    .and(statusFecha1)
                    .and(statusFecha2)
                    .and(statusFecha3)
                    .and(statusFecha4)
                    .and(status);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public NotificacionesEntity create(NotificacionesEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));

        List<NotificacionesEntity> notificacionesEntityList = this.repository.findAllByPeriodoAndStatus(entity.getPeriodo(),"A");
        if(!notificacionesEntityList.isEmpty()){
            throw new ResourceCreateException("Ya hay un registro para este período.");
        }else{
            entity.setStatus("A");
            return super._create(entity, requesterId);
        }

    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "Notificaciones.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "PERIODO",
                    "FECHA 1",
                    "ESTADO FECHA 1",
                    "FECHA 2",
                    "ESTADO FECHA 2",
                    "FECHA 3",
                    "ESTADO FECHA 3",
                    "FECHA 4",
                    "ESTADO 4",
                    "ESTADO",
                    "USUARIO CREACION",
                    "FECHA CREACION",
                    "FECHA MODIFICACION",
                    "USUARIO MODIFICACION",
                    "ATTRIBUTE1",
                    "ATTRIBUTE2",
                    "ATTRIBUTE3"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, STATUS));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<NotificacionesEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);
                for (NotificacionesEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getPeriodo());
                    row.add(dateFormat.format(item.getFecha1()));
                    row.add(item.getStatusFecha1());
                    row.add(dateFormat.format(item.getFecha2()));
                    row.add(item.getStatusFecha2());
                    row.add(dateFormat.format(item.getFecha3()));
                    row.add(item.getStatusFecha3());
                    row.add(dateFormat.format(item.getFecha4()));
                    row.add(item.getStatusFecha4());
                    row.add(item.getUsuarioCreacion());
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getUsuarioModificacion());
                    row.add(dateFormat.format(item.getFechaModificacion()));
                    row.add(item.getAttribute1());
                    row.add(item.getAttribute2());
                    row.add(item.getAttribute3());

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
        LOGGER.debug(String.format("@%s::deleteById(%d)", this.getClass().getName(), entityId));

        return super._deleteById(entityId);
    }

    @Override
    public NotificacionesEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<NotificacionesEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public NotificacionesEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<NotificacionesEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id", Sort.Direction.DESC);
    }

    @Override
    public NotificacionesEntity update(NotificacionesEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Notificaciones.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "PERIODO",
                    "FECHA 1",
                    "ESTADO FECHA 1",
                    "FECHA 2",
                    "ESTADO FECHA 2",
                    "FECHA 3",
                    "ESTADO FECHA 3",
                    "FECHA 4",
                    "ESTADO 4",
                    "ESTADO",
                    "USUARIO CREACION",
                    "FECHA CREACION",
                    "FECHA MODIFICACION",
                    "USUARIO MODIFICACION",
                    "ATTRIBUTE1",
                    "ATTRIBUTE2",
                    "ATTRIBUTE3"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, STATUS));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<NotificacionesEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (NotificacionesEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getPeriodo());
                    row.add(dateFormat.format(item.getFecha1()));
                    row.add(item.getStatusFecha1());
                    row.add(dateFormat.format(item.getFecha2()));
                    row.add(item.getStatusFecha2());
                    row.add(dateFormat.format(item.getFecha3()));
                    row.add(item.getStatusFecha3());
                    row.add(dateFormat.format(item.getFecha4()));
                    row.add(item.getStatusFecha4());
                    row.add(item.getUsuarioCreacion());
                    row.add(dateFormat.format(item.getFechaCreacion()));
                    row.add(item.getUsuarioModificacion());
                    row.add(dateFormat.format(item.getFechaModificacion()));
                    row.add(item.getAttribute1());
                    row.add(item.getAttribute2());
                    row.add(item.getAttribute3());

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
