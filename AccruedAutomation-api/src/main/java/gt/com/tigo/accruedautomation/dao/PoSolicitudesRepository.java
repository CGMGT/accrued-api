package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.PoSolicitudesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

@Repository
public interface PoSolicitudesRepository extends JpaRepository<PoSolicitudesEntity, Long>, JpaSpecificationExecutor<PoSolicitudesEntity> {



}
