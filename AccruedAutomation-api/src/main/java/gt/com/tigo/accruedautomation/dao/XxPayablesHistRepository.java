package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxPayablesHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxPayablesHistRepository extends JpaRepository<XxPayablesHistEntity, Long>, JpaSpecificationExecutor<XxPayablesHistEntity> {
}
