package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "historico_procesos", schema = "", catalog = "")
public class HistoricoProcesosEntity extends AbstractEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Timestamp fechaInicialEjecucion;
    private Timestamp fechaFinalEjecucion;
    private Double tiempoEjecucion;
    private Integer numRegistrosCargados;
    private String usuarioEjecucion;
    private String statusResultado;
    private String commentsResultado;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 150)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "estado", nullable = true, length = 10)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "fecha_inicial_ejecucion", nullable = false)
    public Timestamp getFechaInicialEjecucion() {
        return fechaInicialEjecucion;
    }

    public void setFechaInicialEjecucion(Timestamp fechaInicialEjecucion) {
        this.fechaInicialEjecucion = fechaInicialEjecucion;
    }

    @Basic
    @Column(name = "fecha_final_ejecucion", nullable = true)
    public Timestamp getFechaFinalEjecucion() {
        return fechaFinalEjecucion;
    }

    public void setFechaFinalEjecucion(Timestamp fechaFinalEjecucion) {
        this.fechaFinalEjecucion = fechaFinalEjecucion;
    }

    @Basic
    @Column(name = "tiempo_ejecucion", nullable = true, precision = 2)
    public Double getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Basic
    @Column(name = "num_registros_cargados", nullable = true, precision = 0)
    public Integer getNumRegistrosCargados() {
        return numRegistrosCargados;
    }

    public void setNumRegistrosCargados(Integer numRegistrosCargados) {
        this.numRegistrosCargados = numRegistrosCargados;
    }

    @Basic
    @Column(name = "usuario_ejecucion", nullable = true, length = 100)
    public String getUsuarioEjecucion() {
        return usuarioEjecucion;
    }

    public void setUsuarioEjecucion(String usuarioEjecucion) {
        this.usuarioEjecucion = usuarioEjecucion;
    }

    @Basic
    @Column(name = "status_resultado", nullable = true, length = 50)
    public String getStatusResultado() {
        return statusResultado;
    }

    public void setStatusResultado(String statusResultado) {
        this.statusResultado = statusResultado;
    }

    @Basic
    @Column(name = "comments_resultado", nullable = true, length = 250)
    public String getCommentsResultado() {
        return commentsResultado;
    }

    public void setCommentsResultado(String commentsResultado) {
        this.commentsResultado = commentsResultado;
    }

    @Basic
    @Column(name = "attribute1", nullable = true, length = 250)
    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    @Basic
    @Column(name = "attribute2", nullable = true, length = 250)
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Basic
    @Column(name = "attribute3", nullable = true, length = 250)
    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    @Basic
    @Column(name = "attribute4", nullable = true, length = 250)
    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    @Basic
    @Column(name = "attribute5", nullable = true, length = 250)
    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    @Basic
    @Column(name = "attribute6", nullable = true, length = 250)
    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    @Basic
    @Column(name = "attribute7", nullable = true, length = 250)
    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoProcesosEntity that = (HistoricoProcesosEntity) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(fechaInicialEjecucion, that.fechaInicialEjecucion) &&
                Objects.equals(fechaFinalEjecucion, that.fechaFinalEjecucion) &&
                Objects.equals(tiempoEjecucion, that.tiempoEjecucion) &&
                Objects.equals(numRegistrosCargados, that.numRegistrosCargados) &&
                Objects.equals(usuarioEjecucion, that.usuarioEjecucion) &&
                Objects.equals(statusResultado, that.statusResultado) &&
                Objects.equals(commentsResultado, that.commentsResultado) &&
                Objects.equals(attribute1, that.attribute1) &&
                Objects.equals(attribute2, that.attribute2) &&
                Objects.equals(attribute3, that.attribute3) &&
                Objects.equals(attribute4, that.attribute4) &&
                Objects.equals(attribute5, that.attribute5) &&
                Objects.equals(attribute6, that.attribute6) &&
                Objects.equals(attribute7, that.attribute7);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, estado, fechaInicialEjecucion, fechaFinalEjecucion, tiempoEjecucion, numRegistrosCargados, usuarioEjecucion, statusResultado, commentsResultado, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7);
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
