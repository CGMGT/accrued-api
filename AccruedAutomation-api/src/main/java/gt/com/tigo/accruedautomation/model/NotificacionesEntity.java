package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "notificaciones", schema = "", catalog = "")
public class NotificacionesEntity extends AbstractEntity {
    private long id;
    private String periodo;
    private Timestamp fecha1;
    private String statusFecha1;
    private Timestamp fecha2;
    private String statusFecha2;
    private Timestamp fecha3;
    private String statusFecha3;
    private Timestamp fecha4;
    private String statusFecha4;
    private String status;
    private String usuarioCreacion;
    private Timestamp fechaCreacion;
    private String usuarioModificacion;
    private Timestamp fechaModificacion;
    private String attribute1;
    private String attribute2;
    private String attribute3;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "periodo", nullable = false, length = 150)
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Basic
    @Column(name = "fecha_1", nullable = true)
    public Timestamp getFecha1() {
        return fecha1;
    }

    public void setFecha1(Timestamp fecha1) {
        this.fecha1 = fecha1;
    }

    @Basic
    @Column(name = "status_fecha_1", nullable = true, length = 50)
    public String getStatusFecha1() {
        return statusFecha1;
    }

    public void setStatusFecha1(String statusFecha1) {
        this.statusFecha1 = statusFecha1;
    }

    @Basic
    @Column(name = "fecha_2", nullable = true)
    public Timestamp getFecha2() {
        return fecha2;
    }

    public void setFecha2(Timestamp fecha2) {
        this.fecha2 = fecha2;
    }

    @Basic
    @Column(name = "status_fecha_2", nullable = true, length = 50)
    public String getStatusFecha2() {
        return statusFecha2;
    }

    public void setStatusFecha2(String statusFecha2) {
        this.statusFecha2 = statusFecha2;
    }

    @Basic
    @Column(name = "fecha_3", nullable = true)
    public Timestamp getFecha3() {
        return fecha3;
    }

    public void setFecha3(Timestamp fecha3) {
        this.fecha3 = fecha3;
    }

    @Basic
    @Column(name = "status_fecha_3", nullable = true, length = 50)
    public String getStatusFecha3() {
        return statusFecha3;
    }

    public void setStatusFecha3(String statusFecha3) {
        this.statusFecha3 = statusFecha3;
    }

    @Basic
    @Column(name = "fecha_4", nullable = true)
    public Timestamp getFecha4() {
        return fecha4;
    }

    public void setFecha4(Timestamp fecha4) {
        this.fecha4 = fecha4;
    }

    @Basic
    @Column(name = "status_fecha_4", nullable = true, length = 50)
    public String getStatusFecha4() {
        return statusFecha4;
    }

    public void setStatusFecha4(String statusFecha4) {
        this.statusFecha4 = statusFecha4;
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
    @Column(name = "usuario_creacion", nullable = false, length = 150)
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
    @Column(name = "usuario_modificacion", nullable = true, length = 150)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificacionesEntity that = (NotificacionesEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(periodo, that.periodo)) return false;
        if (!Objects.equals(fecha1, that.fecha1)) return false;
        if (!Objects.equals(statusFecha1, that.statusFecha1)) return false;
        if (!Objects.equals(fecha2, that.fecha2)) return false;
        if (!Objects.equals(statusFecha2, that.statusFecha2)) return false;
        if (!Objects.equals(fecha3, that.fecha3)) return false;
        if (!Objects.equals(statusFecha3, that.statusFecha3)) return false;
        if (!Objects.equals(fecha4, that.fecha4)) return false;
        if (!Objects.equals(statusFecha4, that.statusFecha4)) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(usuarioCreacion, that.usuarioCreacion))
            return false;
        if (!Objects.equals(fechaCreacion, that.fechaCreacion))
            return false;
        if (!Objects.equals(usuarioModificacion, that.usuarioModificacion))
            return false;
        if (!Objects.equals(fechaModificacion, that.fechaModificacion))
            return false;
        if (!Objects.equals(attribute1, that.attribute1)) return false;
        if (!Objects.equals(attribute2, that.attribute2)) return false;
        if (!Objects.equals(attribute3, that.attribute3)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (fecha1 != null ? fecha1.hashCode() : 0);
        result = 31 * result + (statusFecha1 != null ? statusFecha1.hashCode() : 0);
        result = 31 * result + (fecha2 != null ? fecha2.hashCode() : 0);
        result = 31 * result + (statusFecha2 != null ? statusFecha2.hashCode() : 0);
        result = 31 * result + (fecha3 != null ? fecha3.hashCode() : 0);
        result = 31 * result + (statusFecha3 != null ? statusFecha3.hashCode() : 0);
        result = 31 * result + (fecha4 != null ? fecha4.hashCode() : 0);
        result = 31 * result + (statusFecha4 != null ? statusFecha4.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (usuarioCreacion != null ? usuarioCreacion.hashCode() : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (usuarioModificacion != null ? usuarioModificacion.hashCode() : 0);
        result = 31 * result + (fechaModificacion != null ? fechaModificacion.hashCode() : 0);
        result = 31 * result + (attribute1 != null ? attribute1.hashCode() : 0);
        result = 31 * result + (attribute2 != null ? attribute2.hashCode() : 0);
        result = 31 * result + (attribute3 != null ? attribute3.hashCode() : 0);
        return result;
    }
}
