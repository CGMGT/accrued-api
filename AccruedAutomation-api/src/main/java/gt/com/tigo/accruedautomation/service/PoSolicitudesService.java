package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.EmpleadosRepository;
import gt.com.tigo.accruedautomation.dao.GroupRepository;
import gt.com.tigo.accruedautomation.dao.PoSolicitudesRepository;
import gt.com.tigo.accruedautomation.dao.PurchaseOrderRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.FilterInfoDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.dto.ResourceDto;
import gt.com.tigo.accruedautomation.model.*;
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

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;
import static gt.com.tigo.accruedautomation.util.SpecFactory.getDefaultSpecification;

@Service
public class PoSolicitudesService extends AbstractService<PoSolicitudesEntity, PoSolicitudesRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PoSolicitudesService.class);

    public static final String PODETAIL = "{po_detail}";
    public static final String PO = "{PO}";
    public static final String MESSAGE = "{mensaje}";
    public static final String MESSAGE_SOLICITUD = "Se ha realizado una solicitud de cambio de solicitante en la orden de compra {PO}";
    public static final String MESSAGE_APROBACION = "La solicitud de cambio de requester no. {ID} de la orden de compra {PO} ha sido {STATUS}.";
    public static final String PONUMBER = "poNumber";
    public static final String FECHACREACION = "fechaCreacion";
    public static final String ATTRIBUTE1 = "attribute1";
    public static final String ORIGEN1 = "origen1";
    public static final String ORIGEN2 = "origen2";
    public static final String CAPEXOPEX = "Capex, Opex";
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PoSolicitudesRepository poSolicitudesRepository;

    @Autowired
    private GroupRepository groupRepository;




    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        LOGGER.debug(String.format("@%s::buildFilterSpecification(%s)", this.getClass().getName(), dataTableRequestDto));


        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<PoSolicitudesEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification poNumberSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification(PONUMBER, getValueAsString(filtersInfo, PONUMBER));
            Specification proveedorSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification conceptoSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification usuarioRequesterOrigenSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("usuarioRequesterOrigen", getValueAsString(filtersInfo, "usuarioRequesterOrigen"));
            Specification usuarioRequesterDestinoSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("usuarioRequesterDestino", getValueAsString(filtersInfo, "usuarioRequesterDestino"));
            Specification usuarioCreacionSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("usuarioCreacion", getValueAsString(filtersInfo, "usuarioCreacion"));
            Specification usuarioModificacionSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("usuarioModificacion", getValueAsString(filtersInfo, "usuarioModificacion"));
            Specification statusAprobacionSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("statusAprobacion", getValueAsString(filtersInfo, "statusAprobacion"));
            Specification comentariosSolicitudSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("comentariosSolicitud", getValueAsString(filtersInfo, "comentariosSolicitud"));
            Specification comentariosAprobacionSpec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification("comentariosAprobacion", getValueAsString(filtersInfo, "comentariosAprobacion"));
            Specification fechaSpec = SpecFactory.<PoSolicitudesEntity>getBetweenSpecification(FECHACREACION, getValueAsDate(filtersInfo, FECHACREACION), getValueAsDate(filtersInfo, FECHACREACION));

            Specification attribute1Spec;
            Specification origenOpexCapex = SpecFactory.<PoSolicitudesEntity>getLikeSpecification(ATTRIBUTE1, "CAPEX");

            if (filtersInfo.containsKey(ORIGEN1)) {
                attribute1Spec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification(ATTRIBUTE1, getValueAsString(filtersInfo, ORIGEN1));
            } else if (filtersInfo.containsKey(ORIGEN2)) {
                attribute1Spec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification(ATTRIBUTE1, "OPEX").or(origenOpexCapex);
            } else {
                attribute1Spec = SpecFactory.<PoSolicitudesEntity>getLikeSpecification(ATTRIBUTE1, getValueAsString(filtersInfo, "origen"));
            }

            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(poNumberSpec)
                    .and(proveedorSpec)
                    .and(idSpec)
                    .and(fechaSpec)
                    .and(conceptoSpec)
                    .and(usuarioRequesterOrigenSpec)
                    .and(usuarioRequesterDestinoSpec)
                    .and(usuarioCreacionSpec)
                    .and(usuarioModificacionSpec)
                    .and(statusAprobacionSpec)
                    .and(comentariosSolicitudSpec)
                    .and(comentariosAprobacionSpec)
                    .and(attribute1Spec);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public PoSolicitudesEntity create(PoSolicitudesEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::create(%s, %d)", this.getClass().getName(), entity, requesterId));

        entity.setStatusAprobacion("PENDIENTE");
        String mensaje = MESSAGE_SOLICITUD;
        enviarCorreo(entity, entity.getComentariosSolicitud(), mensaje.replace("{PO}", entity.getPoNumber()));
        entity.getParentId();

        PurchaseOrderEntity purchaseOrder = this.purchaseOrderRepository.getById(entity.getParentId());

        entity.setAttribute1(purchaseOrder.getOrigen());


        return super._create(entity, requesterId);
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        Map<String, Object> model = new HashMap<>();

        model.put(CsvViewBuilder.KEY_FILENAME, "Solicitudes.csv");
        model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                "ID",
                "NÚMERO PO",
                "PROVEEDOR",
                "CONCEPTO",
                "REQUESTER ORIGEN",
                "REQUESTER DESTINO",
                "COMENTARIO SOLICITUD",
                "ESTADO",
                "CREADO POR",
                "FECHA CREACIÓN",
                "REVISADO POR",
                "FECHA REVISIÓN",
                "COMENTARIO REVISIÓN"
        ));
        model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
        model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, PONUMBER));
        model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
        model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
        model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<PoSolicitudesEntity>) (items) -> {
            List<List<String>> rows = new LinkedList<>();

            IDateTimeFormat timestampFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIMESTAMP);

            for (PoSolicitudesEntity item : items) {
                List<String> row = new LinkedList<>();

                row.add(String.valueOf(item.getId()));
                row.add(item.getPoNumber());
                row.add(item.getProveedor());
                row.add(item.getConcepto());
                row.add(item.getUsuarioRequesterOrigen());
                row.add(item.getUsuarioRequesterDestino());
                row.add(item.getComentariosSolicitud());
                row.add(item.getStatusAprobacion());
                row.add(item.getUsuarioCreacion());
                row.add(timestampFormat.format(item.getFechaCreacion()));
                row.add(item.getUsuarioModificacion());
                row.add(timestampFormat.format(item.getFechaModificacion()));
                row.add(item.getComentariosAprobacion());

                rows.add(row);
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
    public PoSolicitudesEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<PoSolicitudesEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public PoSolicitudesEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public PaginatedDataDto<PoSolicitudesEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
    }

    public PaginatedDataDto<PoSolicitudesEntity> findByOrigen(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByOrigen(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if(!admGrupoEntities.isEmpty()){
            FilterInfoDto dto = new FilterInfoDto();
            if(admGrupoEntities.size()==1){
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            }else{
                dto.setId(ORIGEN2);
                dto.setValue(CAPEXOPEX);
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.findByPage(dataTableRequestDto);
    }

    @Override
    public PoSolicitudesEntity update(PoSolicitudesEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        if (entity.getStatusAprobacion().equals("APROBADA")) {
            Optional<PurchaseOrderEntity> optionalPurchaseOrder = this.purchaseOrderRepository.findById(entity.getParentId());

            if (!optionalPurchaseOrder.isPresent()) {
                throw new ResourceUpdateException();
            }

            PurchaseOrderEntity purchaseOrder = optionalPurchaseOrder.get();

            purchaseOrder.setUsuarioRequester(entity.getUsuarioRequesterDestino());

            List<EmpleadosEntity> employees = this.empleadosRepository.findByCorreoTigo(purchaseOrder.getUsuarioRequester());

            if (employees.size() != 1) {
                throw new ResourceUpdateException();
            }

            purchaseOrder.setNombreRequester(employees.get(0).getNombreEmpleado());
            purchaseOrder.setNombreJefeOwner(employees.get(0).getNombreJefe());
            purchaseOrder.setUsuarioJefeOwner(employees.get(0).getCorreoJefe());

            this.purchaseOrderRepository.save(purchaseOrder);
        }
        String mensaje = MESSAGE_APROBACION;
        enviarCorreo(entity, entity.getComentariosAprobacion(), mensaje.replace("{PO}", entity.getPoNumber()).replace("{ID}", entity.getId().toString()).replace("{STATUS}", entity.getStatusAprobacion()));

        return super._update(entity, requesterId);
    }

    public String enviarCorreo(PoSolicitudesEntity entity, String _comentarios, String _mensaje) throws RequesterNotFoundException {
        Optional<PurchaseOrderEntity> Poentity = purchaseOrderRepository.findById(entity.getParentId());

        if (!Poentity.isPresent()) {
            throw new RequesterNotFoundException();
        }


        List<EmpleadosEntity> _destino = this.empleadosRepository.findByCorreoTigo(entity.getUsuarioRequesterDestino());

        if (_destino.size() != 1) {
            throw new RequesterNotFoundException();
        }
        String _recipientes = this.purchaseOrderRepository.getRecipients("NOTIFICACIONES REASIGNACION", Poentity.get().getOrigen()) + ", " +
                entity.getUsuarioRequesterDestino() + ", " + entity.getUsuarioRequesterOrigen();
        String[] recipients = _recipientes.split("\\s*[,]\\s*");
        String _template = this.purchaseOrderRepository.getEmailTemplate("REASIGNACION");
        String _subject = this.purchaseOrderRepository.getEmailSubject("REASIGNACION");
        String _data = Poentity.get().getNombreRequester() + "," + _destino.get(0).getNombreEmpleado() + "," + _comentarios;
        String _datosPo = this.purchaseOrderRepository.getReasignacionData(Poentity.get().getId(), _data);
        try {
            this.mailService.sendMail("accruedApp@tigo.com.gt", recipients, _subject, _template.replace(PODETAIL, _datosPo).replace(MESSAGE, _mensaje));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());


        }
        return null;
    }


    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "Solicitudes.xlsx");
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "NÚMERO PO",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "REQUESTER ORIGEN",
                    "REQUESTER DESTINO",
                    "COMENTARIO SOLICITUD",
                    "ESTADO",
                    "CREADO POR",
                    "FECHA CREACIÓN",
                    "REVISADO POR",
                    "FECHA REVISIÓN",
                    "COMENTARIO REVISIÓN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, PONUMBER));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<PoSolicitudesEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat timestampFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.TIMESTAMP);

                for (PoSolicitudesEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getPoNumber());
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getUsuarioRequesterOrigen());
                    row.add(item.getUsuarioRequesterDestino());
                    row.add(item.getComentariosSolicitud());
                    row.add(item.getStatusAprobacion());
                    row.add(item.getUsuarioCreacion());
                    row.add(timestampFormat.format(item.getFechaCreacion()));
                    row.add(item.getUsuarioModificacion());
                    row.add(timestampFormat.format(item.getFechaModificacion()));
                    row.add(item.getComentariosAprobacion());

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
    public ModelAndView exportOrigenXlsx(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsxOrigen(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if(!admGrupoEntities.isEmpty()){
            FilterInfoDto dto = new FilterInfoDto();
            if(admGrupoEntities.size()==1){
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            }else{
                dto.setId(ORIGEN2);
                dto.setValue(CAPEXOPEX);
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.exportXlsx(dataTableRequestDto);
    }

    public ResourceDto exportOrigenCsv(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        List<AdmGrupoEntity> admGrupoEntities = this.groupRepository.findAllByIdUser(id);

        if(!admGrupoEntities.isEmpty()){
            FilterInfoDto dto = new FilterInfoDto();
            if(admGrupoEntities.size()==1){
                dto.setId(ORIGEN1);
                dto.setValue(admGrupoEntities.get(0).getNombre());
            }else{
                dto.setId(ORIGEN2);
                dto.setValue(CAPEXOPEX);
            }
            dataTableRequestDto.getFiltered().add(dto);
        }

        return this.exportCsv(dataTableRequestDto);
    }


}
