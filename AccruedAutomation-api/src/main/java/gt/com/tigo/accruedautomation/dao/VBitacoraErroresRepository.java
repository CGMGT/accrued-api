package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.VBitacoraErroresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VBitacoraErroresRepository extends JpaRepository<VBitacoraErroresEntity, Long>, JpaSpecificationExecutor<VBitacoraErroresEntity> {

    @Query( value = "SELECT DISTINCT source_type FROM v_bitacora_errores ORDER BY source_type ASC LIMIT 10", nativeQuery = true)
    List<Object> getSourceType(String sourceType);


}
