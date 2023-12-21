package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxAccruedIntegratedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxAccruedIntegratedRepository extends JpaRepository<XxxAccruedIntegratedEntity, Long>, JpaSpecificationExecutor<XxxAccruedIntegratedEntity> {

    @Query(
            value = "SELECT f_valida_integracion()",
            nativeQuery = true
    )
    int validarIntegracion();

}
