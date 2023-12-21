package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VRepPoHistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VRepPoHistoricoRepository extends JpaRepository<VRepPoHistoricoEntity, Long>, JpaSpecificationExecutor<VRepPoHistoricoEntity> {
}
