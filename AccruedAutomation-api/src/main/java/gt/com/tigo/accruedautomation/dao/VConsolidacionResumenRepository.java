package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VConsolidacionResumenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VConsolidacionResumenRepository extends JpaRepository<VConsolidacionResumenEntity, Long>, JpaSpecificationExecutor<VConsolidacionResumenEntity> {
}
