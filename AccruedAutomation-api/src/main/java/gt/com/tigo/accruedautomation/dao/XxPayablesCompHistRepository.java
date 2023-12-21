package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxPayablesCompHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxPayablesCompHistRepository extends JpaRepository<XxPayablesCompHistEntity, Long>, JpaSpecificationExecutor<XxPayablesCompHistEntity> {
}
