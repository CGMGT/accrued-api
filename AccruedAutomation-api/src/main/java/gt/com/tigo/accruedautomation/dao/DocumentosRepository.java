package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.DocumentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepository extends JpaRepository<DocumentosEntity, Long>, JpaSpecificationExecutor<DocumentosEntity> {

    void deleteByTipoEntidadAndIdEntidad(String tipoEntidad, Long idEntidad);

}
