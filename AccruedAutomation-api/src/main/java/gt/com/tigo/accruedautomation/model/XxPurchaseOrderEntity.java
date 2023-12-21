package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "xx_purchase_order", schema = "", catalog = "")
public class XxPurchaseOrderEntity extends AbstractEntity {
    private Long id;
    private String llave;
    private String poNumber;
    private String proveedor;
    private String concepto;
    private String moneda;
    private Double monto;
    private Double montoGtq;
    private Integer antiguedad;
    private String status;
    private Long justificacion;
    private Boolean adjuntarArchivo;
    private Date fechaRecepcion;
    private String nombreRequester;
    private String usuarioRequester;
    private String nombreOwner;
    private String usuarioOwner;
    private String nombreJefeOwner;
    private String usuarioJefeOwner;
    private String antiguedadPeriodo;
    private String origen;
    private String entidad;
    private Double tipoCambio;
    private Double cargo;
    private Double abono;
    private String centroCosto;
    private Date fechaIntegracion;
    private Date ultimaActualizacion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "llave", nullable = true, length = 150)
    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    @Basic
    @Column(name = "po_number", nullable = true, length = 150)
    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
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
    @Column(name = "concepto", nullable = true, length = 1000)
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Basic
    @Column(name = "moneda", nullable = true, length = 50)
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
    @Column(name = "antiguedad", nullable = true)
    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "justificacion", nullable = true, precision = 0)
    public Long getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(Long justificacion) {
        this.justificacion = justificacion;
    }

    @Basic
    @Column(name = "adjuntar_archivo", nullable = true)
    public Boolean getAdjuntarArchivo() {
        return adjuntarArchivo;
    }

    public void setAdjuntarArchivo(Boolean adjuntarArchivo) {
        this.adjuntarArchivo = adjuntarArchivo;
    }

    @Basic
    @Column(name = "fecha_recepcion", nullable = true)
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Basic
    @Column(name = "nombre_requester", nullable = true, length = 250)
    public String getNombreRequester() {
        return nombreRequester;
    }

    public void setNombreRequester(String nombreRequester) {
        this.nombreRequester = nombreRequester;
    }

    @Basic
    @Column(name = "usuario_requester", nullable = true, length = 150)
    public String getUsuarioRequester() {
        return usuarioRequester;
    }

    public void setUsuarioRequester(String usuarioRequester) {
        this.usuarioRequester = usuarioRequester;
    }

    @Basic
    @Column(name = "nombre_owner", nullable = true, length = 250)
    public String getNombreOwner() {
        return nombreOwner;
    }

    public void setNombreOwner(String nombreOwner) {
        this.nombreOwner = nombreOwner;
    }

    @Basic
    @Column(name = "usuario_owner", nullable = true, length = 150)
    public String getUsuarioOwner() {
        return usuarioOwner;
    }

    public void setUsuarioOwner(String usuarioOwner) {
        this.usuarioOwner = usuarioOwner;
    }

    @Basic
    @Column(name = "nombre_jefe_owner", nullable = true, length = 250)
    public String getNombreJefeOwner() {
        return nombreJefeOwner;
    }

    public void setNombreJefeOwner(String nombreJefeOwner) {
        this.nombreJefeOwner = nombreJefeOwner;
    }

    @Basic
    @Column(name = "usuario_jefe_owner", nullable = true, length = 150)
    public String getUsuarioJefeOwner() {
        return usuarioJefeOwner;
    }

    public void setUsuarioJefeOwner(String usuarioJefeOwner) {
        this.usuarioJefeOwner = usuarioJefeOwner;
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
    @Column(name = "entidad", nullable = true, length = 150)
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Basic
    @Column(name = "tipo_cambio", nullable = true, precision = 6)
    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Basic
    @Column(name = "cargo", nullable = true, precision = 2)
    public Double getCargo() {
        return cargo;
    }

    public void setCargo(Double cargo) {
        this.cargo = cargo;
    }

    @Basic
    @Column(name = "abono", nullable = true, precision = 2)
    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    @Basic
    @Column(name = "centro_costo", nullable = true, length = 150)
    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
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
    @Column(name = "ultima_actualizacion", nullable = true)
    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XxPurchaseOrderEntity that = (XxPurchaseOrderEntity) o;
        return Objects.equals(llave, that.llave) && Objects.equals(poNumber, that.poNumber) && Objects.equals(proveedor, that.proveedor) && Objects.equals(concepto, that.concepto) && Objects.equals(moneda, that.moneda) && Objects.equals(monto, that.monto) && Objects.equals(montoGtq, that.montoGtq) && Objects.equals(antiguedad, that.antiguedad) && Objects.equals(status, that.status) && Objects.equals(justificacion, that.justificacion) && Objects.equals(adjuntarArchivo, that.adjuntarArchivo) && Objects.equals(fechaRecepcion, that.fechaRecepcion) && Objects.equals(nombreRequester, that.nombreRequester) && Objects.equals(usuarioRequester, that.usuarioRequester) && Objects.equals(nombreOwner, that.nombreOwner) && Objects.equals(usuarioOwner, that.usuarioOwner) && Objects.equals(nombreJefeOwner, that.nombreJefeOwner) && Objects.equals(usuarioJefeOwner, that.usuarioJefeOwner) && Objects.equals(antiguedadPeriodo, that.antiguedadPeriodo) && Objects.equals(origen, that.origen) && Objects.equals(entidad, that.entidad) && Objects.equals(tipoCambio, that.tipoCambio) && Objects.equals(cargo, that.cargo) && Objects.equals(abono, that.abono) && Objects.equals(centroCosto, that.centroCosto) && Objects.equals(fechaIntegracion, that.fechaIntegracion) && Objects.equals(ultimaActualizacion, that.ultimaActualizacion) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(llave, poNumber, proveedor, concepto, moneda, monto, montoGtq, antiguedad, status, justificacion, adjuntarArchivo, fechaRecepcion, nombreRequester, usuarioRequester, nombreOwner, usuarioOwner, nombreJefeOwner, usuarioJefeOwner, antiguedadPeriodo, origen, entidad, tipoCambio, cargo, abono, centroCosto, fechaIntegracion, ultimaActualizacion, id);
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
