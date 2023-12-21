package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VRepAccruedConsolidadoHistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VRepAccruedConsolidadoHistRepository extends JpaRepository<VRepAccruedConsolidadoHistEntity, Long>, JpaSpecificationExecutor<VRepAccruedConsolidadoHistEntity> {
}
