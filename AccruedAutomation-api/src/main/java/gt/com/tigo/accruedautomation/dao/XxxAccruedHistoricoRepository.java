package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.XxxAccruedHistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface XxxAccruedHistoricoRepository extends JpaRepository<XxxAccruedHistoricoEntity, Long>, JpaSpecificationExecutor<XxxAccruedHistoricoEntity> {
}
