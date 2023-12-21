package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxBalanceHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxBalanceHistRepository extends JpaRepository<XxBalanceHistEntity, Long>, JpaSpecificationExecutor<XxBalanceHistEntity> {
}
