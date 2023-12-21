package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AdmPermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<AdmPermisoEntity, Long>, JpaSpecificationExecutor<AdmPermisoEntity> {
}
