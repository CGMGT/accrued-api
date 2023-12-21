package gt.com.tigo.accruedautomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ADM_PERMISO", schema = "", catalog = "")
public class AdmPermisoEntity extends AbstractEntity {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private List<AdmGrupoEntity> grupos;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 250)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 1000)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ACTIVO", nullable = false)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "CODIGO", nullable = false, length = 250)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "permisos")
    public List<AdmGrupoEntity> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<AdmGrupoEntity> grupos) {
        this.grupos = grupos;
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
