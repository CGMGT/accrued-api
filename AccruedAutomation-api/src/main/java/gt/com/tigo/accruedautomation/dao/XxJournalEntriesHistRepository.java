package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxJournalEntriesHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxJournalEntriesHistRepository extends JpaRepository<XxJournalEntriesHistEntity, Long>, JpaSpecificationExecutor<XxJournalEntriesHistEntity> {
}
