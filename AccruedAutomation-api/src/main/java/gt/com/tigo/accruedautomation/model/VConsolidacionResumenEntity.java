package gt.com.tigo.accruedautomation.model;

import gt.com.tigo.accruedautomation.util.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "v_consolidacion_resumen", schema = "", catalog = "")
public class VConsolidacionResumenEntity extends AbstractEntity {
    private Long id;
    private String compania;
    private String cuenta;
    private Double montoGtq;
    private Double montoBalance;
    private Double diferencia;

    @Id
    @Basic
    @Column(name = "id", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "compania", nullable = true, length = -1)
    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Basic
    @Column(name = "cuenta", nullable = true, length = -1)
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Basic
    @Column(name = "monto_gtq", nullable = true, precision = 0)
    public Double getMontoGtq() {
        return montoGtq;
    }

    public void setMontoGtq(Double montoGtq) {
        this.montoGtq = montoGtq;
    }

    @Basic
    @Column(name = "monto_balance", nullable = true, precision = 0)
    public Double getMontoBalance() {
        return montoBalance;
    }

    public void setMontoBalance(Double montoBalance) {
        this.montoBalance = montoBalance;
    }

    @Basic
    @Column(name = "diferencia", nullable = true, precision = 0)
    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VConsolidacionResumenEntity that = (VConsolidacionResumenEntity) o;
        return Objects.equals(compania, that.compania) &&
                Objects.equals(cuenta, that.cuenta) &&
                Objects.equals(montoGtq, that.montoGtq) &&
                Objects.equals(montoBalance, that.montoBalance) &&
                Objects.equals(diferencia, that.diferencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compania, cuenta, montoGtq, montoBalance, diferencia);
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
