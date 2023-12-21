package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "", catalog = "")
public class EmpleadosEntity extends AbstractEntity {
    private Long id;
    private String codigo;
    private String estado;
    private String nombreEmpleado;
    private String correoTigo;
    private String nombreJefe;
    private String correoJefe;
    private String unidadDeNegocio;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigo", nullable = false, length = 100)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "nombre_empleado", nullable = true, length = 200)
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Basic
    @Column(name = "correo_tigo", nullable = true, length = 100)
    public String getCorreoTigo() {
        return correoTigo;
    }

    public void setCorreoTigo(String correoTigo) {
        this.correoTigo = correoTigo;
    }

    @Basic
    @Column(name = "nombre_jefe", nullable = true, length = 200)
    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    @Basic
    @Column(name = "correo_jefe", nullable = true, length = 100)
    public String getCorreoJefe() {
        return correoJefe;
    }

    public void setCorreoJefe(String correoJefe) {
        this.correoJefe = correoJefe;
    }

    @Basic
    @Column(name = "unidad_de_negocio", nullable = true, length = 100)
    public String getUnidadDeNegocio() {
        return unidadDeNegocio;
    }

    public void setUnidadDeNegocio(String unidadDeNegocio) {
        this.unidadDeNegocio = unidadDeNegocio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosEntity that = (EmpleadosEntity) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(nombreEmpleado, that.nombreEmpleado) &&
                Objects.equals(correoTigo, that.correoTigo) &&
                Objects.equals(nombreJefe, that.nombreJefe) &&
                Objects.equals(correoJefe, that.correoJefe) &&
                Objects.equals(unidadDeNegocio, that.unidadDeNegocio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, estado, nombreEmpleado, correoTigo, nombreJefe, correoJefe, unidadDeNegocio);
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
