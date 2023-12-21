package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.CustomReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomReportRepository extends JpaRepository<CustomReportEntity, Long>, JpaSpecificationExecutor<CustomReportEntity> {
}
