package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xxx_accrued_consolidated", schema = "", catalog = "")
public class XxxAccruedConsolidatedEntity extends AbstractEntity {
    private Long internalId;
    private Long id;
    private String llave;
    private String modulo;
    private String compania;
    private String cuenta;
    private String local;
    private String flujo;
    private String cc;
    private String proyecto;
    private String po;
    private String recepcion;
    private String linea;
    private String numDocumento;
    private String proveedor;
    private String concepto;
    private String moneda;
    private Double monto;
    private Double montoGtq;
    private Double tc;
    private String revaluacion;
    private Double montoRevaluado;
    private Integer antiguedad;
    private String status;
    private String cambiarAEstado;
    private String justificacionProvision;
    private String adjuntarArchivo;
    private String fechaRecepcion;
    private String nombreRequester;
    private String requesterEmail;
    private String nombreCreator;
    private String creatorEmail;
    private String nombreJefeOwner;
    private String jefeDeOwner;
    private String antiguedadPeriodo;
    private String origen;
    private String cargo;
    private String abono;
    private String kpi;
    private Date fechaIntegracion;
    private String comentarios;

    public XxxAccruedConsolidatedEntity() {
        // not implemented
    }

    public XxxAccruedConsolidatedEntity(AccruedConsolidatedEntity accruedConsolidatedEntity) {
        this.id = accruedConsolidatedEntity.getId();
        this.llave = accruedConsolidatedEntity.getLlave();
        this.modulo = accruedConsolidatedEntity.getModulo();
        this.compania = accruedConsolidatedEntity.getCompania();
        this.cuenta = accruedConsolidatedEntity.getCuenta();
        this.local = accruedConsolidatedEntity.getLocal();
        this.flujo = accruedConsolidatedEntity.getFlujo();
        this.cc = accruedConsolidatedEntity.getCc();
        this.proyecto = accruedConsolidatedEntity.getProyecto();
        this.po = accruedConsolidatedEntity.getPo();
        this.recepcion = accruedConsolidatedEntity.getRecepcion();
        this.linea = accruedConsolidatedEntity.getLinea();
        this.numDocumento = accruedConsolidatedEntity.getNumDocumento();
        this.proveedor = accruedConsolidatedEntity.getProveedor();
        this.concepto = accruedConsolidatedEntity.getConcepto();
        this.moneda = accruedConsolidatedEntity.getMoneda();
        this.monto = accruedConsolidatedEntity.getMonto();
        this.montoGtq = accruedConsolidatedEntity.getMontoGtq();
        this.tc = accruedConsolidatedEntity.getTc();
        this.revaluacion = accruedConsolidatedEntity.getRevaluacion();
        this.montoRevaluado = accruedConsolidatedEntity.getMontoRevaluado();
        this.antiguedad = accruedConsolidatedEntity.getAntiguedad();
        this.status = accruedConsolidatedEntity.getStatus();
        this.cambiarAEstado = accruedConsolidatedEntity.getCambiarAEstado();
        this.justificacionProvision = accruedConsolidatedEntity.getJustificacionProvision();
        this.adjuntarArchivo = accruedConsolidatedEntity.getAdjuntarArchivo();
        this.fechaRecepcion = accruedConsolidatedEntity.getFechaRecepcion();
        this.nombreRequester = accruedConsolidatedEntity.getNombreRequester();
        this.requesterEmail = accruedConsolidatedEntity.getRequesterEmail();
        this.nombreCreator = accruedConsolidatedEntity.getNombreCreator();
        this.creatorEmail = accruedConsolidatedEntity.getCreatorEmail();
        this.nombreJefeOwner = accruedConsolidatedEntity.getNombreJefeOwner();
        this.jefeDeOwner = accruedConsolidatedEntity.getJefeDeOwner();
        this.antiguedadPeriodo = accruedConsolidatedEntity.getAntiguedadPeriodo();
        this.origen = accruedConsolidatedEntity.getOrigen();
        this.cargo = accruedConsolidatedEntity.getCargo();
        this.abono = accruedConsolidatedEntity.getAbono();
        this.kpi = accruedConsolidatedEntity.getKpi();
        this.fechaIntegracion = accruedConsolidatedEntity.getFechaIntegracion();
    }

    public XxxAccruedConsolidatedEntity(XxxAccruedConsolidatedEntity xxxAccruedConsolidatedEntity) {
        this.id = xxxAccruedConsolidatedEntity.getId();
        this.llave = xxxAccruedConsolidatedEntity.getLlave();
        this.modulo = xxxAccruedConsolidatedEntity.getModulo();
        this.compania = xxxAccruedConsolidatedEntity.getCompania();
        this.cuenta = xxxAccruedConsolidatedEntity.getCuenta();
        this.local = xxxAccruedConsolidatedEntity.getLocal();
        this.flujo = xxxAccruedConsolidatedEntity.getFlujo();
        this.cc = xxxAccruedConsolidatedEntity.getCc();
        this.proyecto = xxxAccruedConsolidatedEntity.getProyecto();
        this.po = xxxAccruedConsolidatedEntity.getPo();
        this.recepcion = xxxAccruedConsolidatedEntity.getRecepcion();
        this.linea = xxxAccruedConsolidatedEntity.getLinea();
        this.numDocumento = xxxAccruedConsolidatedEntity.getNumDocumento();
        this.proveedor = xxxAccruedConsolidatedEntity.getProveedor();
        this.concepto = xxxAccruedConsolidatedEntity.getConcepto();
        this.moneda = xxxAccruedConsolidatedEntity.getMoneda();
        this.monto = xxxAccruedConsolidatedEntity.getMonto();
        this.montoGtq = xxxAccruedConsolidatedEntity.getMontoGtq();
        this.tc = xxxAccruedConsolidatedEntity.getTc();
        this.revaluacion = xxxAccruedConsolidatedEntity.getRevaluacion();
        this.montoRevaluado = xxxAccruedConsolidatedEntity.getMontoRevaluado();
        this.antiguedad = xxxAccruedConsolidatedEntity.getAntiguedad();
        this.status = xxxAccruedConsolidatedEntity.getStatus();
        this.cambiarAEstado = xxxAccruedConsolidatedEntity.getCambiarAEstado();
        this.justificacionProvision = xxxAccruedConsolidatedEntity.getJustificacionProvision();
        this.adjuntarArchivo = xxxAccruedConsolidatedEntity.getAdjuntarArchivo();
        this.fechaRecepcion = xxxAccruedConsolidatedEntity.getFechaRecepcion();
        this.nombreRequester = xxxAccruedConsolidatedEntity.getNombreRequester();
        this.requesterEmail = xxxAccruedConsolidatedEntity.getRequesterEmail();
        this.nombreCreator = xxxAccruedConsolidatedEntity.getNombreCreator();
        this.creatorEmail = xxxAccruedConsolidatedEntity.getCreatorEmail();
        this.nombreJefeOwner = xxxAccruedConsolidatedEntity.getNombreJefeOwner();
        this.jefeDeOwner = xxxAccruedConsolidatedEntity.getJefeDeOwner();
        this.antiguedadPeriodo = xxxAccruedConsolidatedEntity.getAntiguedadPeriodo();
        this.origen = xxxAccruedConsolidatedEntity.getOrigen();
        this.cargo = xxxAccruedConsolidatedEntity.getCargo();
        this.abono = xxxAccruedConsolidatedEntity.getAbono();
        this.kpi = xxxAccruedConsolidatedEntity.getKpi();
        this.fechaIntegracion = xxxAccruedConsolidatedEntity.getFechaIntegracion();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internal_id", nullable = true)
    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    @Basic
    @Column(name = "id", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "llave", nullable = true, length = 250)
    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    @Basic
    @Column(name = "modulo", nullable = true, length = 150)
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Basic
    @Column(name = "compania", nullable = true, length = 150)
    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Basic
    @Column(name = "cuenta", nullable = true, length = 150)
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Basic
    @Column(name = "local", nullable = true, length = 150)
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Basic
    @Column(name = "flujo", nullable = true, length = 150)
    public String getFlujo() {
        return flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    @Basic
    @Column(name = "cc", nullable = true, length = 150)
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Basic
    @Column(name = "proyecto", nullable = true, length = 150)
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Basic
    @Column(name = "po", nullable = true, length = 150)
    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    @Basic
    @Column(name = "recepcion", nullable = true, length = 150)
    public String getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(String recepcion) {
        this.recepcion = recepcion;
    }

    @Basic
    @Column(name = "linea", nullable = true, length = 150)
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Basic
    @Column(name = "num_documento", nullable = true, length = 150)
    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    @Basic
    @Column(name = "proveedor", nullable = true, length = 250)
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Basic
    @Column(name = "concepto", nullable = true, length = 250)
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Basic
    @Column(name = "moneda", nullable = true, length = 150)
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Basic
    @Column(name = "monto", nullable = true, precision = 2)
    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "monto_gtq", nullable = true, precision = 2)
    public Double getMontoGtq() {
        return montoGtq;
    }

    public void setMontoGtq(Double montoGtq) {
        this.montoGtq = montoGtq;
    }

    @Basic
    @Column(name = "tc", nullable = true, precision = 6)
    public Double getTc() {
        return tc;
    }

    public void setTc(Double tc) {
        this.tc = tc;
    }

    @Basic
    @Column(name = "revaluacion", nullable = true, length = 150)
    public String getRevaluacion() {
        return revaluacion;
    }

    public void setRevaluacion(String revaluacion) {
        this.revaluacion = revaluacion;
    }

    @Basic
    @Column(name = "monto_revaluado", nullable = true, precision = 2)
    public Double getMontoRevaluado() {
        return montoRevaluado;
    }

    public void setMontoRevaluado(Double montoRevaluado) {
        this.montoRevaluado = montoRevaluado;
    }

    @Basic
    @Column(name = "antiguedad", nullable = true)
    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 150)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "cambiar_a_estado", nullable = true, length = 150)
    public String getCambiarAEstado() {
        return cambiarAEstado;
    }

    public void setCambiarAEstado(String cambiarAEstado) {
        this.cambiarAEstado = cambiarAEstado;
    }

    @Basic
    @Column(name = "justificacion_provision", nullable = true, length = 250)
    public String getJustificacionProvision() {
        return justificacionProvision;
    }

    public void setJustificacionProvision(String justificacionProvision) {
        this.justificacionProvision = justificacionProvision;
    }

    @Basic
    @Column(name = "adjuntar_archivo", nullable = true, length = 150)
    public String getAdjuntarArchivo() {
        return adjuntarArchivo;
    }

    public void setAdjuntarArchivo(String adjuntarArchivo) {
        this.adjuntarArchivo = adjuntarArchivo;
    }

    @Basic
    @Column(name = "fecha_recepcion", nullable = true, length = 150)
    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Basic
    @Column(name = "nombre_requester", nullable = true, length = 150)
    public String getNombreRequester() {
        return nombreRequester;
    }

    public void setNombreRequester(String nombreRequester) {
        this.nombreRequester = nombreRequester;
    }

    @Basic
    @Column(name = "requester_email", nullable = true, length = 150)
    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    @Basic
    @Column(name = "nombre_creator", nullable = true, length = 150)
    public String getNombreCreator() {
        return nombreCreator;
    }

    public void setNombreCreator(String nombreCreator) {
        this.nombreCreator = nombreCreator;
    }

    @Basic
    @Column(name = "creator_email", nullable = true, length = 150)
    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    @Basic
    @Column(name = "nombre_jefe_owner", nullable = true, length = 150)
    public String getNombreJefeOwner() {
        return nombreJefeOwner;
    }

    public void setNombreJefeOwner(String nombreJefeOwner) {
        this.nombreJefeOwner = nombreJefeOwner;
    }

    @Basic
    @Column(name = "jefe_de_owner", nullable = true, length = 150)
    public String getJefeDeOwner() {
        return jefeDeOwner;
    }

    public void setJefeDeOwner(String jefeDeOwner) {
        this.jefeDeOwner = jefeDeOwner;
    }

    @Basic
    @Column(name = "antiguedad_periodo", nullable = true, length = 150)
    public String getAntiguedadPeriodo() {
        return antiguedadPeriodo;
    }

    public void setAntiguedadPeriodo(String antiguedadPeriodo) {
        this.antiguedadPeriodo = antiguedadPeriodo;
    }

    @Basic
    @Column(name = "origen", nullable = true, length = 150)
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Basic
    @Column(name = "cargo", nullable = true, length = 250)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Basic
    @Column(name = "abono", nullable = true, length = 250)
    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    @Basic
    @Column(name = "kpi", nullable = true, length = 150)
    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    @Basic
    @Column(name = "fecha_integracion", nullable = true)
    public Date getFechaIntegracion() {
        return fechaIntegracion;
    }

    public void setFechaIntegracion(Date fechaIntegracion) {
        this.fechaIntegracion = fechaIntegracion;
    }

    @Basic
    @Column(name = "comentarios", nullable = true, length = 500)
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxxAccruedConsolidatedEntity that = (XxxAccruedConsolidatedEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(llave, that.llave) && Objects.equals(modulo, that.modulo) && Objects.equals(compania, that.compania) && Objects.equals(cuenta, that.cuenta) && Objects.equals(local, that.local) && Objects.equals(flujo, that.flujo) && Objects.equals(cc, that.cc) && Objects.equals(proyecto, that.proyecto) && Objects.equals(po, that.po) && Objects.equals(recepcion, that.recepcion) && Objects.equals(linea, that.linea) && Objects.equals(numDocumento, that.numDocumento) && Objects.equals(proveedor, that.proveedor) && Objects.equals(concepto, that.concepto) && Objects.equals(moneda, that.moneda) && Objects.equals(monto, that.monto) && Objects.equals(montoGtq, that.montoGtq) && Objects.equals(tc, that.tc) && Objects.equals(revaluacion, that.revaluacion) && Objects.equals(montoRevaluado, that.montoRevaluado) && Objects.equals(antiguedad, that.antiguedad) && Objects.equals(status, that.status) && Objects.equals(cambiarAEstado, that.cambiarAEstado) && Objects.equals(justificacionProvision, that.justificacionProvision) && Objects.equals(adjuntarArchivo, that.adjuntarArchivo) && Objects.equals(fechaRecepcion, that.fechaRecepcion) && Objects.equals(nombreRequester, that.nombreRequester) && Objects.equals(requesterEmail, that.requesterEmail) && Objects.equals(nombreCreator, that.nombreCreator) && Objects.equals(creatorEmail, that.creatorEmail) && Objects.equals(nombreJefeOwner, that.nombreJefeOwner) && Objects.equals(jefeDeOwner, that.jefeDeOwner) && Objects.equals(antiguedadPeriodo, that.antiguedadPeriodo) && Objects.equals(origen, that.origen) && Objects.equals(cargo, that.cargo) && Objects.equals(abono, that.abono) && Objects.equals(kpi, that.kpi) && Objects.equals(fechaIntegracion, that.fechaIntegracion) && Objects.equals(comentarios, that.comentarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, llave, modulo, compania, cuenta, local, flujo, cc, proyecto, po, recepcion, linea, numDocumento, proveedor, concepto, moneda, monto, montoGtq, tc, revaluacion, montoRevaluado, antiguedad, status, cambiarAEstado, justificacionProvision, adjuntarArchivo, fechaRecepcion, nombreRequester, requesterEmail, nombreCreator, creatorEmail, nombreJefeOwner, jefeDeOwner, antiguedadPeriodo, origen, cargo, abono, kpi, fechaIntegracion, comentarios);
    }

    @Override
    public void setFechaCreacion(Timestamp fechaCreacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setUsuarioCreacion(String usuarioCreacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setFechaModificacion(Timestamp fechaModificacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setUsuarioModificacion(String usuarioModificacion) {
        // Do nothing because field is not part of this entity.
    }
}