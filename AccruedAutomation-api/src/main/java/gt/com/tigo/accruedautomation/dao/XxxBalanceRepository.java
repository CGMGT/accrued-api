package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxBalanceRepository extends JpaRepository<XxxBalanceEntity, Long>, JpaSpecificationExecutor<XxxBalanceEntity> {
    @Query(
            value = "SELECT f_accrued_carga_manual(?,?)",
            nativeQuery = true
    )
    int ejecutarCargaManual(String usuario, String modulo);
}
