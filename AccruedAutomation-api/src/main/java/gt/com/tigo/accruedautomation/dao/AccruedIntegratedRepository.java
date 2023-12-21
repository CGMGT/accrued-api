package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AccruedIntegratedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccruedIntegratedRepository extends JpaRepository<AccruedIntegratedEntity, Long>, JpaSpecificationExecutor<AccruedIntegratedEntity> {

    @Query(
            value = "SELECT f_accrued_valida_integracion(?)",
            nativeQuery = true
    )
    int procesarIntegracion(String usuario);

}
