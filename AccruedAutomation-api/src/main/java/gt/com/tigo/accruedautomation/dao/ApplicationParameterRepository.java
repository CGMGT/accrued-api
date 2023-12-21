package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AdmParametroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationParameterRepository extends JpaRepository<AdmParametroEntity, Long>, JpaSpecificationExecutor<AdmParametroEntity> {

    AdmParametroEntity findByCodigo(String codigo);

    AdmParametroEntity findByNombre(String nombre);

}
