package gt.com.tigo.accruedautomation.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ADM_PARAMETRO", schema = "", catalog = "")
public class AdmParametroInternalEntity {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String valor;
    private Boolean activo;
    private String tipo;
    private String valoresDisponibles;
    private Boolean modificable;
    private String categoria;
    private Timestamp fechaModificacion;
    private String usuarioModificacion;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODIGO", nullable = false, length = 250)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    @Column(name = "VALOR", nullable = true)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "ACTIVO", nullable = true)
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean estado) {
        this.activo = estado;
    }

    @Basic
    @Column(name = "TIPO", nullable = false, length = 250)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "VALORES_DISPONIBLES", nullable = true, length = 1000)
    public String getValoresDisponibles() {
        return valoresDisponibles;
    }

    public void setValoresDisponibles(String valoresDisponibles) {
        this.valoresDisponibles = valoresDisponibles;
    }

    @Basic
    @Column(name = "MODIFICABLE", nullable = false)
    public Boolean getModificable() {
        return modificable;
    }

    public void setModificable(Boolean modificable) {
        this.modificable = modificable;
    }

    @Basic
    @Column(name = "CATEGORIA", nullable = false, length = 250)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "FECHA_MODIFICACION", nullable = true)
    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Basic
    @Column(name = "USUARIO_MODIFICACION", nullable = true, length = 50)
    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

}
