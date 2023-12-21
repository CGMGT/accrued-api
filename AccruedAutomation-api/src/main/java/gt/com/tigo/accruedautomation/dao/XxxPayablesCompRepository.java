package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxPayablesCompEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxPayablesCompRepository extends JpaRepository<XxxPayablesCompEntity, Long>, JpaSpecificationExecutor<XxxPayablesCompEntity> {
}
