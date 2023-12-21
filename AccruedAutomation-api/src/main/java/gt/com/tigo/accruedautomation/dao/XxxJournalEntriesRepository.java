package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxJournalEntriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxJournalEntriesRepository extends JpaRepository<XxxJournalEntriesEntity, Long>, JpaSpecificationExecutor<XxxJournalEntriesEntity> {
}
