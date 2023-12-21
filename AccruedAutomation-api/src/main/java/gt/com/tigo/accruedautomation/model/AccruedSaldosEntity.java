package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;


@Entity
@Table(name = "accrued_saldos", schema = "", catalog = "")
public class AccruedSaldosEntity extends AbstractEntity {
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
    private Timestamp ultimaActualizacion;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String cambiarAEstado;

    @Id
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
    public Timestamp getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Timestamp ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Basic
    @Column(name = "attribute1", nullable = true, length = 150)
    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
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
    @Column(name = "attribute3", nullable = true, length = 150)
    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    @Basic
    @Column(name = "attribute4", nullable = true, length = 150)
    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    @Basic
    @Column(name = "attribute5", nullable = true, length = 150)
    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    @Basic
    @Column(name = "cambiar_a_estado", nullable = true, length = 150)
    public String getCambiarAEstado() {
        return cambiarAEstado;
    }

    public void setCambiarAEstado(String cambiarAEstado) {
        this.cambiarAEstado = cambiarAEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccruedSaldosEntity that = (AccruedSaldosEntity) o;

        if (id != that.id) return false;
        if (llave != null ? !llave.equals(that.llave) : that.llave != null) return false;
        if (poNumber != null ? !poNumber.equals(that.poNumber) : that.poNumber != null) return false;
        if (proveedor != null ? !proveedor.equals(that.proveedor) : that.proveedor != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;
        if (moneda != null ? !moneda.equals(that.moneda) : that.moneda != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (montoGtq != null ? !montoGtq.equals(that.montoGtq) : that.montoGtq != null) return false;
        if (antiguedad != null ? !antiguedad.equals(that.antiguedad) : that.antiguedad != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (justificacion != null ? !justificacion.equals(that.justificacion) : that.justificacion != null)
            return false;
        if (archivo != null ? archivo != that.archivo : that.archivo != null) return false;
        if (fechaRecepcion != null ? !fechaRecepcion.equals(that.fechaRecepcion) : that.fechaRecepcion != null)
            return false;
        if (nombreRequester != null ? !nombreRequester.equals(that.nombreRequester) : that.nombreRequester != null)
            return false;
        if (usuarioRequester != null ? !usuarioRequester.equals(that.usuarioRequester) : that.usuarioRequester != null)
            return false;
        if (nombreOwner != null ? !nombreOwner.equals(that.nombreOwner) : that.nombreOwner != null) return false;
        if (usuarioOwner != null ? !usuarioOwner.equals(that.usuarioOwner) : that.usuarioOwner != null) return false;
        if (nombreJefeOwner != null ? !nombreJefeOwner.equals(that.nombreJefeOwner) : that.nombreJefeOwner != null)
            return false;
        if (usuarioJefeOwner != null ? !usuarioJefeOwner.equals(that.usuarioJefeOwner) : that.usuarioJefeOwner != null)
            return false;
        if (antiguedadPeriodo != null ? !antiguedadPeriodo.equals(that.antiguedadPeriodo) : that.antiguedadPeriodo != null)
            return false;
        if (origen != null ? !origen.equals(that.origen) : that.origen != null) return false;
        if (entidad != null ? !entidad.equals(that.entidad) : that.entidad != null) return false;
        if (tipoCambio != null ? !tipoCambio.equals(that.tipoCambio) : that.tipoCambio != null) return false;
        if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
        if (abono != null ? !abono.equals(that.abono) : that.abono != null) return false;
        if (centroCosto != null ? !centroCosto.equals(that.centroCosto) : that.centroCosto != null) return false;
        if (fechaIntegracion != null ? !fechaIntegracion.equals(that.fechaIntegracion) : that.fechaIntegracion != null)
            return false;
        if (ultimaActualizacion != null ? !ultimaActualizacion.equals(that.ultimaActualizacion) : that.ultimaActualizacion != null)
            return false;
        if (attribute1 != null ? !attribute1.equals(that.attribute1) : that.attribute1 != null) return false;
        if (attribute2 != null ? !attribute2.equals(that.attribute2) : that.attribute2 != null) return false;
        if (attribute3 != null ? !attribute3.equals(that.attribute3) : that.attribute3 != null) return false;
        if (attribute4 != null ? !attribute4.equals(that.attribute4) : that.attribute4 != null) return false;
        if (attribute5 != null ? !attribute5.equals(that.attribute5) : that.attribute5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (llave != null ? llave.hashCode() : 0);
        result = 31 * result + (poNumber != null ? poNumber.hashCode() : 0);
        result = 31 * result + (proveedor != null ? proveedor.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + (moneda != null ? moneda.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (montoGtq != null ? montoGtq.hashCode() : 0);
        result = 31 * result + (antiguedad != null ? antiguedad.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (justificacion != null ? justificacion.hashCode() : 0);
        result = 31 * result + (archivo != null ? Arrays.hashCode(archivo) : 0);
        result = 31 * result + (fechaRecepcion != null ? fechaRecepcion.hashCode() : 0);
        result = 31 * result + (nombreRequester != null ? nombreRequester.hashCode() : 0);
        result = 31 * result + (usuarioRequester != null ? usuarioRequester.hashCode() : 0);
        result = 31 * result + (nombreOwner != null ? nombreOwner.hashCode() : 0);
        result = 31 * result + (usuarioOwner != null ? usuarioOwner.hashCode() : 0);
        result = 31 * result + (nombreJefeOwner != null ? nombreJefeOwner.hashCode() : 0);
        result = 31 * result + (usuarioJefeOwner != null ? usuarioJefeOwner.hashCode() : 0);
        result = 31 * result + (antiguedadPeriodo != null ? antiguedadPeriodo.hashCode() : 0);
        result = 31 * result + (origen != null ? origen.hashCode() : 0);
        result = 31 * result + (entidad != null ? entidad.hashCode() : 0);
        result = 31 * result + (tipoCambio != null ? tipoCambio.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (abono != null ? abono.hashCode() : 0);
        result = 31 * result + (centroCosto != null ? centroCosto.hashCode() : 0);
        result = 31 * result + (fechaIntegracion != null ? fechaIntegracion.hashCode() : 0);
        result = 31 * result + (ultimaActualizacion != null ? ultimaActualizacion.hashCode() : 0);
        result = 31 * result + (attribute1 != null ? attribute1.hashCode() : 0);
        result = 31 * result + (attribute2 != null ? attribute2.hashCode() : 0);
        result = 31 * result + (attribute3 != null ? attribute3.hashCode() : 0);
        result = 31 * result + (attribute4 != null ? attribute4.hashCode() : 0);
        result = 31 * result + (attribute5 != null ? attribute5.hashCode() : 0);
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
