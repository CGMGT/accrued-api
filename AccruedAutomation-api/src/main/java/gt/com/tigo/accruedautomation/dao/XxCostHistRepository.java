package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxCostHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxCostHistRepository extends JpaRepository<XxCostHistEntity, Long>, JpaSpecificationExecutor<XxCostHistEntity> {
}
