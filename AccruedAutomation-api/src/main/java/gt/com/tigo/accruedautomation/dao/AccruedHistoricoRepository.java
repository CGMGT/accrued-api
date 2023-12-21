package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AccruedHistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccruedHistoricoRepository extends JpaRepository<AccruedHistoricoEntity, Long>, JpaSpecificationExecutor<AccruedHistoricoEntity> {
}
