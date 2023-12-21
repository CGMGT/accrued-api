package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "po_solicitudes", schema = "", catalog = "")
public class PoSolicitudesEntity extends AbstractEntity {
    private Long id;
    private String poNumber;
    private String proveedor;
    private String concepto;
    private String usuarioRequesterOrigen;
    private String usuarioRequesterDestino;
    private String comentariosSolicitud;
    private String usuarioCreacion;
    private Timestamp fechaCreacion;
    private String usuarioModificacion;
    private Timestamp fechaModificacion;
    private String statusAprobacion;
    private String comentariosAprobacion;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private Long parentId;

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
    @Column(name = "po_number", nullable = false, length = 150)
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
    @Column(name = "usuario_requester_origen", nullable = false, length = 200)
    public String getUsuarioRequesterOrigen() {
        return usuarioRequesterOrigen;
    }

    public void setUsuarioRequesterOrigen(String usuarioRequesterOrigen) {
        this.usuarioRequesterOrigen = usuarioRequesterOrigen;
    }

    @Basic
    @Column(name = "usuario_requester_destino", nullable = false, length = 200)
    public String getUsuarioRequesterDestino() {
        return usuarioRequesterDestino;
    }

    public void setUsuarioRequesterDestino(String usuarioRequesterDestino) {
        this.usuarioRequesterDestino = usuarioRequesterDestino;
    }

    @Basic
    @Column(name = "comentarios_solicitud", nullable = true, length = 250)
    public String getComentariosSolicitud() {
        return comentariosSolicitud;
    }

    public void setComentariosSolicitud(String comentariosSolicitud) {
        this.comentariosSolicitud = comentariosSolicitud;
    }

    @Basic
    @Column(name = "usuario_creacion", nullable = true, length = 200)
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    @Basic
    @Column(name = "fecha_creacion", nullable = false)
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "usuario_modificacion", nullable = true, length = 200)
    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Basic
    @Column(name = "fecha_modificacion", nullable = true)
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "status_aprobacion", nullable = true, length = 50)
    public String getStatusAprobacion() {
        return statusAprobacion;
    }

    public void setStatusAprobacion(String statusAprobacion) {
        this.statusAprobacion = statusAprobacion;
    }

    @Basic
    @Column(name = "comentarios_aprobacion", nullable = true, length = 250)
    public String getComentariosAprobacion() {
        return comentariosAprobacion;
    }

    public void setComentariosAprobacion(String comentariosAprobacion) {
        this.comentariosAprobacion = comentariosAprobacion;
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
    @Column(name = "parent_id", nullable = false)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoSolicitudesEntity that = (PoSolicitudesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(poNumber, that.poNumber) && Objects.equals(proveedor, that.proveedor) && Objects.equals(concepto, that.concepto) && Objects.equals(usuarioRequesterOrigen, that.usuarioRequesterOrigen) && Objects.equals(usuarioRequesterDestino, that.usuarioRequesterDestino) && Objects.equals(comentariosSolicitud, that.comentariosSolicitud) && Objects.equals(usuarioCreacion, that.usuarioCreacion) && Objects.equals(fechaCreacion, that.fechaCreacion) && Objects.equals(usuarioModificacion, that.usuarioModificacion) && Objects.equals(fechaModificacion, that.fechaModificacion) && Objects.equals(statusAprobacion, that.statusAprobacion) && Objects.equals(comentariosAprobacion, that.comentariosAprobacion) && Objects.equals(attribute1, that.attribute1) && Objects.equals(attribute2, that.attribute2) && Objects.equals(attribute3, that.attribute3) && Objects.equals(attribute4, that.attribute4) && Objects.equals(attribute5, that.attribute5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poNumber, proveedor, concepto, usuarioRequesterOrigen, usuarioRequesterDestino, comentariosSolicitud, usuarioCreacion, fechaCreacion, usuarioModificacion, fechaModificacion, statusAprobacion, comentariosAprobacion, attribute1, attribute2, attribute3, attribute4, attribute5);
    }
}
