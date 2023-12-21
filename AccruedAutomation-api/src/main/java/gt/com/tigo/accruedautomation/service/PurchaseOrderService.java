package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dao.DocumentosRepository;
import gt.com.tigo.accruedautomation.dao.EmpleadosRepository;
import gt.com.tigo.accruedautomation.dao.GroupRepository;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import static gt.com.tigo.accruedautomation.util.SpecFactory.*;

@Service
public class PurchaseOrderService extends AbstractService<PurchaseOrderEntity, PurchaseOrderRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderService.class);

    public static final String PODETAIL = "{po_detail}";
    public static final String PO = "{PO}";
    public static final String FECHARECEPCION = "fechaRecepcion";
    public static final String FECHAINTEGRACION = "fechaIntegracion";
    public static final String ULTIMAACT = "ultimaActualizacion";
    public static final String ORIGEN = "origen";
    public static final String ORIGEN1 = "origen1";
    public static final String ORIGEN2 = "origen2";
    public static final String ENTIDAD = "ENTIDAD";
    public static final String CAPEXOPEX = "Capex, Opex";
    public static final String PURCHASEORDER = "PURCHASE_ORDER";
    @Autowired
    private DocumentosService documentosService;

    @Autowired
    private DocumentosRepository documentosRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    protected Specification buildFilterSpecification(DataTableRequestDto dataTableRequestDto) throws InvalidFilterException {
        try {
            Map<String, FilterInfoDto> filtersInfo = super.buildFiltersInfo(dataTableRequestDto);

            // create filter specifications
            Specification idSpec = SpecFactory.<PurchaseOrderEntity>getEqualSpecification("id", getValueAsLong(filtersInfo, "id"));
            Specification llaveSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("llave", getValueAsString(filtersInfo, "llave"));
            Specification poNumberSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("poNumber", getValueAsString(filtersInfo, "poNumber"));
            Specification proveedorSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("proveedor", getValueAsString(filtersInfo, "proveedor"));
            Specification conceptoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("concepto", getValueAsString(filtersInfo, "concepto"));
            Specification monedaSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("moneda", getValueAsString(filtersInfo, "moneda"));
            Specification montoSpec = SpecFactory.<PurchaseOrderEntity>getEqualSpecification("monto", getValueAsDouble(filtersInfo, "monto"));
            Specification montoGtqSpec = SpecFactory.<PurchaseOrderEntity>getEqualSpecification("montoGtq", getValueAsDouble(filtersInfo, "montoGtq"));
            Specification antiguedadSpec = SpecFactory.<PurchaseOrderEntity>getEqualSpecification("antiguedad", getValueAsLong(filtersInfo, "antiguedad"));
            Specification statusSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("status", getValueAsString(filtersInfo, "status"));
            Specification justificacionSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("justificacion", getValueAsString(filtersInfo, "justificacion"));
            Specification archivoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("archivo", getValueAsString(filtersInfo, "archivo"));
            Specification fechaSpec = SpecFactory.<PurchaseOrderEntity>getBetweenSpecification(FECHARECEPCION, getValueAsSimpleDate(filtersInfo, FECHARECEPCION), getValueAsSimpleDate(filtersInfo, FECHARECEPCION));
            Specification nombreRequesterSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("nombreRequester", getValueAsString(filtersInfo, "nombreRequester"));
            Specification usuarioRequesterSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("usuarioRequester", getValueAsString(filtersInfo, "usuarioRequester"));
            Specification nombreOwnerSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("nombreOwner", getValueAsString(filtersInfo, "nombreOwner"));
            Specification usuarioOwnerSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("usuarioOwner", getValueAsString(filtersInfo, "usuarioOwner"));
            Specification nombreJefeOwnerSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("nombreJefeOwner", getValueAsString(filtersInfo, "nombreJefeOwner"));
            Specification usuarioJefeOwnerSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("usuarioJefeOwner", getValueAsString(filtersInfo, "usuarioJefeOwner"));
            Specification antiguedadPeriodoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("antiguedadPeriodo", getValueAsString(filtersInfo, "antiguedadPeriodo"));
            Specification entidadSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("entidad", getValueAsString(filtersInfo, "entidad"));
            Specification tipoCambioSpec = SpecFactory.<PurchaseOrderEntity>getEqualSpecification("tipoCambio", getValueAsDouble(filtersInfo, "tipoCambio"));
            Specification cargoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("cargo", getValueAsString(filtersInfo, "cargo"));
            Specification abonoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("abono", getValueAsString(filtersInfo, "abono"));
            Specification centroCostoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("centroCosto", getValueAsString(filtersInfo, "centroCosto"));
            Specification fechaIntegracionSpec = SpecFactory.<PurchaseOrderEntity>getBetweenSpecification(FECHAINTEGRACION, getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION), getValueAsSimpleDate(filtersInfo, FECHAINTEGRACION));
            Specification ultimaActualizacionSpec = SpecFactory.<PurchaseOrderEntity>getBetweenSpecification(ULTIMAACT, getValueAsDate(filtersInfo, ULTIMAACT), getValueAsDate(filtersInfo, ULTIMAACT));

            Specification attribute1Spec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("attribute1", getValueAsString(filtersInfo, "attribute1"));
            Specification attribute2Spec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("attribute2", getValueAsString(filtersInfo, "attribute2"));
            Specification attribute3Spec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("attribute3", getValueAsString(filtersInfo, "attribute3"));
            Specification attribute4Spec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("attribute4", getValueAsString(filtersInfo, "attribute4"));
            Specification attribute5Spec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("attribute5", getValueAsString(filtersInfo, "attribute5"));
            Specification cambiarAEstadoSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification("cambiarAEstado", getValueAsString(filtersInfo, "cambiarAEstado"));
            Specification origenSpec2 = SpecFactory.<PurchaseOrderEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));
            Specification origenSpec;

            Specification origenOpexCapexSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification(ORIGEN, "CAPEX");

            if (filtersInfo.containsKey(ORIGEN1)) {
                origenSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN1));
            } else if (filtersInfo.containsKey(ORIGEN2)) {
                origenSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification(ORIGEN, "OPEX").or(origenOpexCapexSpec);
            } else {
                origenSpec = SpecFactory.<PurchaseOrderEntity>getLikeSpecification(ORIGEN, getValueAsString(filtersInfo, ORIGEN));
            }
            // assemble filter specifications
            return Specification
                    .where(getDefaultSpecification())
                    .and(idSpec)
                    .and(llaveSpec)
                    .and(poNumberSpec)
                    .and(proveedorSpec)
                    .and(conceptoSpec)
                    .and(monedaSpec)
                    .and(montoSpec)
                    .and(montoGtqSpec)
                    .and(antiguedadSpec)
                    .and(statusSpec)
                    .and(justificacionSpec)
                    .and(archivoSpec)
                    .and(origenSpec)
                    .and(origenSpec2)
                    .and(fechaSpec)
                    .and(nombreRequesterSpec)
                    .and(usuarioRequesterSpec)
                    .and(nombreOwnerSpec)
                    .and(usuarioOwnerSpec)
                    .and(nombreJefeOwnerSpec)
                    .and(usuarioJefeOwnerSpec)
                    .and(antiguedadPeriodoSpec)
                    .and(entidadSpec)
                    .and(tipoCambioSpec)
                    .and(cargoSpec)
                    .and(abonoSpec)
                    .and(centroCostoSpec)
                    .and(fechaIntegracionSpec)
                    .and(ultimaActualizacionSpec)
                    .and(attribute1Spec)
                    .and(attribute2Spec)
                    .and(attribute3Spec)
                    .and(attribute4Spec)
                    .and(attribute5Spec)
                    .and(cambiarAEstadoSpec);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());

            throw new InvalidFilterException();
        }
    }

    @Override
    public PurchaseOrderEntity create(PurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public ResourceDto exportCsv(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException, IOException {
        LOGGER.debug(String.format("@%s::exportCsv(%s)", this.getClass().getName(), dataTableRequestDto));

        try{
            Map<String, Object> model = new HashMap<>();

            model.put(CsvViewBuilder.KEY_FILENAME, "PO.csv");
            model.put(CsvViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "ESTADO",
                    "PERÍODO",
                    ENTIDAD,
                    "NÚMERO PO",
                    "RECEPCIÓN",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "LLAVE",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "ANTIGÜEDAD",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN",
                    "COMENTARIOS",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "USUARIO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "USUARIO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "USUARIO JEFE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    ENTIDAD,
                    "TIPO CAMBIO",
                    "CARGO",
                    "ABONO",
                    "CENTRO COSTO",
                    "FECHA INTEGRACIÓN",
                    "ÚLTIMA ACTUALIZACIÓN"
            ));
            model.put(CsvViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(CsvViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(CsvViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(CsvViewBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(CsvViewBuilder.KEY_FIELD_MAPPER, (IListToListConverter<PurchaseOrderEntity>) (items) -> {
                List<List<String>> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (PurchaseOrderEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getStatus());
                    row.add(item.getAttribute4()); // period
                    row.add(item.getAttribute3()); // entity
                    row.add(item.getPoNumber());
                    row.add(item.getAttribute1()); // reception
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getLlave());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getCambiarAEstado());
                    row.add(item.getJustificacion());
                    row.add(item.getAttribute5()); // comentarios de justificacion
                    row.add(dateFormat.format(item.getFechaRecepcion()));
                    row.add(item.getNombreRequester());
                    row.add(item.getUsuarioRequester());
                    row.add(item.getNombreOwner());
                    row.add(item.getUsuarioOwner());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getUsuarioJefeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getEntidad());
                    row.add(String.valueOf(item.getTipoCambio()));
                    row.add(item.getCargo());
                    row.add(item.getAbono());
                    row.add(item.getCentroCosto());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(dateFormat.format(item.getUltimaActualizacion()));

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
    public PurchaseOrderEntity deleteById(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public List<PurchaseOrderEntity> findAll() throws ResourcesNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public PurchaseOrderEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }


    public PaginatedDataDto<PurchaseOrderEntity> findByPage(DataTableRequestDto dataTableRequestDto, Long id) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s, %d)", this.getClass().getName(), dataTableRequestDto, id));

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
        return super._findByPage(dataTableRequestDto, "id");
    }

    @Override
    public PurchaseOrderEntity update(PurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        LOGGER.debug(String.format("@%s::update(%s, %d)", this.getClass().getName(), entity, requesterId));

        Optional<PurchaseOrderEntity> optionalPo = this.repository.findById(entity.getId());

        if (!optionalPo.isPresent()) {
            throw new ResourceUpdateException();
        }

        if (!optionalPo.get().getUsuarioRequester().equals(entity.getUsuarioRequester())) {
            List<EmpleadosEntity> employees = this.empleadosRepository.findByCorreoTigo(entity.getUsuarioRequester());

            if (employees.size() != 1) {
                throw new ResourceUpdateException();
            }

            entity.setNombreRequester(employees.get(0).getNombreEmpleado());
            entity.setNombreJefeOwner(employees.get(0).getNombreJefe());
            entity.setUsuarioJefeOwner(employees.get(0).getCorreoJefe());
            this.repository.updateRequester(entity.getId(), employees.get(0).getNombreEmpleado(), entity.getUsuarioRequester(),
                    employees.get(0).getNombreJefe(), employees.get(0).getCorreoJefe());
        }
        else if(!optionalPo.get().getStatus().equals(entity.getStatus()) ||
                (optionalPo.get().getCambiarAEstado()!= null && !optionalPo.get().getCambiarAEstado().equals(entity.getCambiarAEstado())) ||
                (optionalPo.get().getJustificacion() != null && !optionalPo.get().getJustificacion().equals(entity.getJustificacion()))){

            String[] recipients = this.repository.getRecipients("NOTIFICACIONES CONFIRMACION", entity.getOrigen()).concat("," + entity.getUsuarioRequester()).split("\\s*[,]\\s*");
            String _template = this.repository.getEmailTemplate("CAMBIO_ESTADO");
            String _subject = this.repository.getEmailSubject("CAMBIO_ESTADO");

            LOGGER.error(this.repository.getRecipients("NOTIFICACIONES CONFIRMACION", entity.getOrigen()).concat("," + entity.getUsuarioRequester()));
            String _datosPo = entity.getJustificacion() == null
                    ? this.repository.getConfirmationData(entity.getId(), entity.getCambiarAEstado())
                    : this.repository.getConfirmationData(entity.getId(), entity.getJustificacion(), entity.getCambiarAEstado()
            );
            try{
                this.mailService.sendMail("accruedApp@tigo.com.gt",recipients,_subject, _template.replace(PODETAIL,_datosPo).replace(PO, entity.getPoNumber()));
            } catch (Exception ex) {
                LOGGER.error(ex.getMessage());


            }

        }

        entity.setUltimaActualizacion(new Timestamp(new Date().getTime()));

        return super._update(entity, requesterId);
    }

    @Override
    public ModelAndView exportXlsx(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::exportXlsx(%s)", this.getClass().getName(), dataTableRequestDto.toString()));

        try {
            Map<String, Object> model = new HashMap<>();

            model.put(XlsxViewBuilder.KEY_FILENAME, "PO.xlsx");
            model.put(XlsxViewBuilder.KEY_ATTACH_TIMESTAMP, true);
            model.put(XlsxViewBuilder.KEY_SHEET_NAME, "Datos");
            model.put(XlsxViewBuilder.KEY_COLUMNS, Arrays.asList(
                    "ID",
                    "ESTADO",
                    "PERÍODO",
                    ENTIDAD,
                    "NÚMERO PO",
                    "RECEPCIÓN",
                    "PROVEEDOR",
                    "CONCEPTO",
                    "LLAVE",
                    "MONEDA",
                    "MONTO",
                    "MONTO GTQ",
                    "ANTIGÜEDAD",
                    "CAMBIAR A ESTADO",
                    "JUSTIFICACIÓN",
                    "COMENTARIOS",
                    "FECHA RECEPCIÓN",
                    "NOMBRE SOLICITANTE",
                    "USUARIO SOLICITANTE",
                    "NOMBRE CREADOR",
                    "USUARIO CREADOR",
                    "NOMBRE JEFE SOLICITANTE",
                    "USUARIO JEFE SOLICITANTE",
                    "ANTIGÜEDAD PERÍODO",
                    "ORIGEN",
                    ENTIDAD,
                    "TIPO CAMBIO",
                    "CARGO",
                    "ABONO",
                    "CENTRO COSTO",
                    "FECHA INTEGRACIÓN",
                    "ÚLTIMA ACTUALIZACIÓN"
            ));
            model.put(XlsxViewBuilder.KEY_SPECIFICATION, this.buildFilterSpecification(dataTableRequestDto));
            model.put(XlsxViewBuilder.KEY_ORDER_BY, super.buildSortOrder(dataTableRequestDto, "id"));
            model.put(XlsxViewBuilder.KEY_REPOSITORY, super.repository);
            model.put(XlsxByteArrayInputStreamBuilder.KEY_BATCH_SIZE, dataTableRequestDto.getPageSize());
            model.put(XlsxViewBuilder.KEY_FIELD_MAPPER, (IListToArrayConverter<PurchaseOrderEntity>) (items) -> {
                List<Object[]> rows = new LinkedList<>();

                IDateTimeFormat dateFormat = new DateTimeFormatterFactory().getFormatter(DateTimeFormatterType.DATE);

                for (PurchaseOrderEntity item : items) {
                    List<String> row = new LinkedList<>();

                    row.add(String.valueOf(item.getId()));
                    row.add(item.getStatus());
                    row.add(item.getAttribute4()); // period
                    row.add(item.getAttribute3()); // entity
                    row.add(item.getPoNumber());
                    row.add(item.getAttribute1()); // reception
                    row.add(item.getProveedor());
                    row.add(item.getConcepto());
                    row.add(item.getLlave());
                    row.add(item.getMoneda());
                    row.add(String.valueOf(item.getMonto()));
                    row.add(String.valueOf(item.getMontoGtq()));
                    row.add(String.valueOf(item.getAntiguedad()));
                    row.add(item.getCambiarAEstado());
                    row.add(String.valueOf(item.getJustificacion()));
                    row.add(item.getAttribute5()); // comentarios de justificacion
                    row.add(dateFormat.format(item.getFechaRecepcion()));
                    row.add(item.getNombreRequester());
                    row.add(item.getUsuarioRequester());
                    row.add(item.getNombreOwner());
                    row.add(item.getUsuarioOwner());
                    row.add(item.getNombreJefeOwner());
                    row.add(item.getUsuarioJefeOwner());
                    row.add(item.getAntiguedadPeriodo());
                    row.add(item.getOrigen());
                    row.add(item.getEntidad());
                    row.add(String.valueOf(item.getTipoCambio()));
                    row.add(String.valueOf(item.getCargo()));
                    row.add(String.valueOf(item.getAbono()));
                    row.add(item.getCentroCosto());
                    row.add(dateFormat.format(item.getFechaIntegracion()));
                    row.add(dateFormat.format(item.getUltimaActualizacion()));

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

    @Transactional
    public DocumentosEntity upload(MultipartFile file, Long poId, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::upload(%s, %d, %d", this.getClass().getName(), file.getOriginalFilename(), poId, requesterId));

        try {
            DocumentosEntity document = new DocumentosEntity();
            document.setNombre(file.getOriginalFilename());
            document.setDescripcion(file.getName());
            document.setTipo(file.getContentType());
            document.setTamanio(file.getSize());
            document.setContenido(file.getBytes());
            document.setTipoEntidad(PURCHASEORDER);
            document.setIdEntidad(poId);

            this.documentosRepository.deleteByTipoEntidadAndIdEntidad(PURCHASEORDER, poId);

            return this.documentosService.create(document, requesterId);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());

            throw new ResourceCreateException();
        }
    }

    public PaginatedDataDto<DocumentosEntity> findFiles(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findFiles(%s)", this.getClass().getName(), dataTableRequestDto.toString()));

        List<FilterInfoDto> filters = dataTableRequestDto.getFiltered();

        if (filters == null) {
            filters = new ArrayList<>();
        }

        Map<String, FilterInfoDto> filterInfoMap = SpecFactory.getFiltersAsMap(filters);

        FilterInfoDto tipoEntidadFilterInfo = new FilterInfoDto("tipoEntidad", PURCHASEORDER);

        filterInfoMap.put("tipoEntidad", tipoEntidadFilterInfo);

        dataTableRequestDto.setFiltered(SpecFactory.getMapAsFilters(filterInfoMap));

        return this.documentosService.findByPage(dataTableRequestDto);
    }

    public List<Object> getData4PoChart(Long requesterId) {
        LOGGER.debug(String.format("@%s::getData4PoChart()", this.getClass().getName()));

        return this.repository.getData4PoChart(requesterId);
    }

    public List<Object> getData4KpiGeneral(String origen) {
        LOGGER.debug(String.format("@%s::getData4KpiGeneral()", this.getClass().getName()));

        return this.repository.getData4KpiGeneral(origen);
    }

    public List<Object> getData4SaldoEstadoEmpresa(String origen) {
        LOGGER.debug(String.format("@%s::getData4SaldoEstadoEmpresa()", this.getClass().getName()));

        return this.repository.getData4SaldoEstadoEmpresa(origen);
    }

    public List<Object> getData4AntiguedadAcciones(String origen) {
        LOGGER.debug(String.format("@%s::getData4AntiguedadAcciones()", this.getClass().getName()));

        return this.repository.getData4AntiguedadAcciones(origen);
    }

    public List<Object> getData4SaldoVencidoProveedor(String origen) {
        LOGGER.debug(String.format("@%s::getData4SaldoVencidoProveedor()", this.getClass().getName()));

        return this.repository.getData4SaldoVencidoProveedor(origen);
    }

    public List<Object> getData4SalvoVencidoRequester(String origen) {
        LOGGER.debug(String.format("@%s::getData4SalvoVencidoRequester()", this.getClass().getName()));

        return this.repository.getData4SaldoVencidoRequester(origen);
    }

    public List<Object> getData4SOpexCapex(String origen) {
        LOGGER.debug(String.format("@%s::getData4SOpexCapex()", this.getClass().getName()));

        return this.repository.getData4OpexCapex(origen);
    }

    public List<Object> getData4EstadoJustificaciones(String origen, String usuario) {
        LOGGER.debug(String.format("@%s::getData4EstadoJustificaciones()", this.getClass().getName()));

        return this.repository.getData4EstadosJustificaciones(origen, usuario);
    }

    public List<Object> getData4PoByAmount(Long requesterId) {
        LOGGER.debug(String.format("@%s::getData4PoByAmount()", this.getClass().getName()));

        return this.repository.getData4PobyAmount(requesterId);
    }

    @Override
    public PaginatedDataDto<PurchaseOrderEntity> findByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException, InvalidFilterException {
        LOGGER.debug(String.format("@%s::findByPage(%s)", this.getClass().getName(), dataTableRequestDto));

        return super._findByPage(dataTableRequestDto, "id");
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

    public List<Object> getData4TotalKpiEmpresa(Long requesterId, String empresa) {
        LOGGER.debug(String.format("@%s::getData4TotalKpiEmpresa()", this.getClass().getName()));

        return this.repository.getData4totalkpiempresa(requesterId, empresa);
    }

    public List<Object> getData4DetalleKpiEmpresa(Long requesterId) {
        LOGGER.debug(String.format("@%s::getData4DetalleKpiEmpresa()", this.getClass().getName()));

        return this.repository.getData4detallekpiempresa(requesterId);
    }

    public List<Object> getEmpresas() {
        LOGGER.debug(String.format("@%s::getEmpresas()", this.getClass().getName()));

        return this.repository.getEmpresas();
    }

}
