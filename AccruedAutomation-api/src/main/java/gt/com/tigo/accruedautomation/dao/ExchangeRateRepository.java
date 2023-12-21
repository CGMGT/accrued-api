package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.TiposCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<TiposCambioEntity, Long>, JpaSpecificationExecutor<TiposCambioEntity> {

    TiposCambioEntity findByFecha(Date date);

    @Query(
            value = "SELECT dia, referencia " +
                    "FROM (" +
                    "SELECT to_char(fecha, 'MON DD') AS dia, referencia " +
                    "FROM tipos_cambio " +
                    "ORDER BY fecha DESC LIMIT 7) exchangeRate " +
                    "ORDER BY exchangeRate.dia ASC",
            nativeQuery = true
    )
    List<Object> getExchangeRateLast7Days();

}
