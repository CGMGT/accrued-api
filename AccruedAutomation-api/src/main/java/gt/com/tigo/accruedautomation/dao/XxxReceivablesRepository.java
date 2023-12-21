package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxReceivablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxReceivablesRepository extends JpaRepository<XxxReceivablesEntity, Long>, JpaSpecificationExecutor<XxxReceivablesEntity> {
}
