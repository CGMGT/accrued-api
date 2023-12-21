package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AccruedSaldosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccruedSaldosRepository extends JpaRepository<AccruedSaldosEntity, Long>, JpaSpecificationExecutor<AccruedSaldosEntity> {
}
