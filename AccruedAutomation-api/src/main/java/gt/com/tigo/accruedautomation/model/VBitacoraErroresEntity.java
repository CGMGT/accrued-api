package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "v_bitacora_errores", schema = "", catalog = "")
public class VBitacoraErroresEntity extends AbstractEntity {
    private Long logId;
    private Timestamp logTimestamp;
    private String errorMessage;
    private String sourceType;
    private String sourceName;

    @Id
    @Basic
    @Column(name = "log_id", nullable = true, precision = 0)
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "log_timestamp", nullable = true)
    public Timestamp getLogTimestamp() {
        return logTimestamp;
    }

    public void setLogTimestamp(Timestamp logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    @Basic
    @Column(name = "error_message", nullable = true, length = -1)
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Basic
    @Column(name = "source_type", nullable = true, length = -1)
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Basic
    @Column(name = "source_name", nullable = true, length = -1)
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VBitacoraErroresEntity that = (VBitacoraErroresEntity) o;
        return Objects.equals(logId, that.logId) &&
                Objects.equals(logTimestamp, that.logTimestamp) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(sourceType, that.sourceType) &&
                Objects.equals(sourceName, that.sourceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, logTimestamp, errorMessage, sourceType, sourceName);
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
