package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VIntegracionResumenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VIntegracionResumenRepository extends JpaRepository<VIntegracionResumenEntity, Long>, JpaSpecificationExecutor<VIntegracionResumenEntity> {
}
