package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxCashManagmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxCashManagmentRepository extends JpaRepository<XxxCashManagmentEntity, Long>, JpaSpecificationExecutor<XxxCashManagmentEntity> {
}
