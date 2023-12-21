package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxAccruedConsolidatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxAccruedConsolidatedRepository extends JpaRepository<XxxAccruedConsolidatedEntity, Long>, JpaSpecificationExecutor<XxxAccruedConsolidatedEntity> {

    @Query(
            value = "SELECT f_valida_consolidacion()",
            nativeQuery = true
    )
    int validarConsolidado();

}
