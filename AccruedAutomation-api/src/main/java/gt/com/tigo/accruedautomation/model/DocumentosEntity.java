package gt.com.tigo.accruedautomation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "documentos", schema = "", catalog = "")
public class DocumentosEntity extends AbstractEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Long tamanio;
    private String estado;
    private byte[] contenido;
    private String tipoEntidad;
    private Long idEntidad;
    private Timestamp fechaCreacion;
    private String usuarioCreacion;

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
    @Column(name = "nombre", nullable = false, length = 150)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "tipo", nullable = false, length = 150)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "tamanio", nullable = false)
    public Long getTamanio() {
        return tamanio;
    }

    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
    }

    @Basic
    @Column(name = "estado", nullable = false, length = -1)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonIgnore
    @Basic
    @Column(name = "contenido", nullable = false)
    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "tipo_entidad", nullable = true, length = 150)
    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    @Basic
    @Column(name = "id_entidad", nullable = true)
    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
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
    @Column(name = "usuario_creacion", nullable = false, length = 150)
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    @Override
    public void setFechaModificacion(Timestamp fechaModificacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public void setUsuarioModificacion(String usuarioModificacion) {
        // Do nothing because field is not part of this entity.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentosEntity that = (DocumentosEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(tipo, that.tipo) && Objects.equals(tamanio, that.tamanio) && Objects.equals(estado, that.estado) && Arrays.equals(contenido, that.contenido) && Objects.equals(tipoEntidad, that.tipoEntidad) && Objects.equals(idEntidad, that.idEntidad) && Objects.equals(fechaCreacion, that.fechaCreacion) && Objects.equals(usuarioCreacion, that.usuarioCreacion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, nombre, descripcion, tipo, tamanio, estado, tipoEntidad, idEntidad, fechaCreacion, usuarioCreacion);
        result = 31 * result + Arrays.hashCode(contenido);
        return result;
    }
}
