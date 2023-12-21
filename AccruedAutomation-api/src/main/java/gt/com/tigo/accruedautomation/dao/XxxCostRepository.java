package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxCostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxCostRepository extends JpaRepository<XxxCostEntity, Long>, JpaSpecificationExecutor<XxxCostEntity> {
}
