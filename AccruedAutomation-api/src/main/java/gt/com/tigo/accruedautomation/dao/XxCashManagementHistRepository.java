package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxCashManagmentHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxCashManagementHistRepository extends JpaRepository<XxCashManagmentHistEntity, Long>, JpaSpecificationExecutor<XxCashManagmentHistEntity> {
}
