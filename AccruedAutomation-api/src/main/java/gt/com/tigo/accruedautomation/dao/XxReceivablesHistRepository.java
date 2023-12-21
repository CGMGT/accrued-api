package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxReceivablesHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxReceivablesHistRepository extends JpaRepository<XxReceivablesHistEntity, Long>, JpaSpecificationExecutor<XxReceivablesHistEntity> {
}
