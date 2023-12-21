package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AccruedConsolidatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccruedConsolidatedRepository extends JpaRepository<AccruedConsolidatedEntity, Long>, JpaSpecificationExecutor<AccruedConsolidatedEntity> {

    @Query(
            value = "SELECT f_accrued_ejecuta_integracion(?)",
            nativeQuery = true
    )
    int procesarConsolidado(String usuario);

}
