package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "v_rep_po_historico", schema = "", catalog = "")
public class VRepPoHistoricoEntity extends AbstractEntity {
    private Long id;
    private String llave;
    private String nombreEntidad;
    private String poNumber;
    private String recepcion;
    private String proveedor;
    private String concepto;
    private String moneda;
    private Double monto;
    private Double montoGtq;
    private Integer antiguedad;
    private String status;
    private String cambiarAEstado;
    private String justificacion;
    private byte[] archivo;
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
    private String cargo;
    private String abono;
    private String centroCosto;
    private Date fechaIntegracion;
    private Date ultimaActualizacion;
    private String attribute2;
    private String periodo;

    @Id
    @Basic
    @Column(name = "id", nullable = true)
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
    @Column(name = "nombre_entidad", nullable = true, length = 150)
    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
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
    @Column(name = "recepcion", nullable = true, length = 150)
    public String getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(String recepcion) {
        this.recepcion = recepcion;
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
    @Column(name = "cambiar_a_estado", nullable = true, length = 1000)
    public String getCambiarAEstado() {
        return cambiarAEstado;
    }

    public void setCambiarAEstado(String cambiarAEstado) {
        this.cambiarAEstado = cambiarAEstado;
    }

    @Basic
    @Column(name = "justificacion", nullable = true, length = 1000)
    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Basic
    @Column(name = "archivo", nullable = true)
    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
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
    @Column(name = "cargo", nullable = true, length = 150)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Basic
    @Column(name = "abono", nullable = true, length = 150)
    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
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

    @Basic
    @Column(name = "attribute2", nullable = true, length = 150)
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Basic
    @Column(name = "periodo", nullable = true, length = 150)
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VRepPoHistoricoEntity that = (VRepPoHistoricoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(llave, that.llave) && Objects.equals(nombreEntidad, that.nombreEntidad) && Objects.equals(poNumber, that.poNumber) && Objects.equals(recepcion, that.recepcion) && Objects.equals(proveedor, that.proveedor) && Objects.equals(concepto, that.concepto) && Objects.equals(moneda, that.moneda) && Objects.equals(monto, that.monto) && Objects.equals(montoGtq, that.montoGtq) && Objects.equals(antiguedad, that.antiguedad) && Objects.equals(status, that.status) && Objects.equals(justificacion, that.justificacion) && Arrays.equals(archivo, that.archivo) && Objects.equals(fechaRecepcion, that.fechaRecepcion) && Objects.equals(nombreRequester, that.nombreRequester) && Objects.equals(usuarioRequester, that.usuarioRequester) && Objects.equals(nombreOwner, that.nombreOwner) && Objects.equals(usuarioOwner, that.usuarioOwner) && Objects.equals(nombreJefeOwner, that.nombreJefeOwner) && Objects.equals(usuarioJefeOwner, that.usuarioJefeOwner) && Objects.equals(antiguedadPeriodo, that.antiguedadPeriodo) && Objects.equals(origen, that.origen) && Objects.equals(entidad, that.entidad) && Objects.equals(tipoCambio, that.tipoCambio) && Objects.equals(cargo, that.cargo) && Objects.equals(abono, that.abono) && Objects.equals(centroCosto, that.centroCosto) && Objects.equals(fechaIntegracion, that.fechaIntegracion) && Objects.equals(ultimaActualizacion, that.ultimaActualizacion) && Objects.equals(attribute2, that.attribute2) && Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, llave, nombreEntidad, poNumber, recepcion, proveedor, concepto, moneda, monto, montoGtq, antiguedad, status, justificacion, fechaRecepcion, nombreRequester, usuarioRequester, nombreOwner, usuarioOwner, nombreJefeOwner, usuarioJefeOwner, antiguedadPeriodo, origen, entidad, tipoCambio, cargo, abono, centroCosto, fechaIntegracion, ultimaActualizacion, attribute2, periodo);
        result = 31 * result + Arrays.hashCode(archivo);
        return result;
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
