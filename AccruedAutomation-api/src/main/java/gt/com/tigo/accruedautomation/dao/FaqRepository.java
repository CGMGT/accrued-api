package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.FaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<FaqEntity, Long>, JpaSpecificationExecutor<FaqEntity> {
}
