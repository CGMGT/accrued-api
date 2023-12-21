package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxPurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxPurchaseOrderRepository extends JpaRepository<XxPurchaseOrderEntity, Long>, JpaSpecificationExecutor<XxPurchaseOrderEntity> {
}
