package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VRepAccruedHistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface VRepAccruedHistoricoRepository extends JpaRepository<VRepAccruedHistoricoEntity, Long>, JpaSpecificationExecutor<VRepAccruedHistoricoEntity> {

}
