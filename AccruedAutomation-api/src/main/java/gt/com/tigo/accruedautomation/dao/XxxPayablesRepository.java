package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxPayablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxPayablesRepository extends JpaRepository<XxxPayablesEntity, Long>, JpaSpecificationExecutor<XxxPayablesEntity> {
}
