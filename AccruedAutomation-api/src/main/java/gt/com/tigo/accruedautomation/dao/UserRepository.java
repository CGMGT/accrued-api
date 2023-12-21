package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AdmUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AdmUsuarioEntity, Long>, JpaSpecificationExecutor<AdmUsuarioEntity> {

    AdmUsuarioEntity findByUuid(String uuid);

    AdmUsuarioEntity findByCorreoElectronico(String correoElectronico);

}
