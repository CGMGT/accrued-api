package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.AdmGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<AdmGrupoEntity, Long>, JpaSpecificationExecutor<AdmGrupoEntity> {

    AdmGrupoEntity findByNombre(String nombre);

    AdmGrupoEntity findByNombreAndActivo(String nombre, Boolean activo);

    @Query(value = "SELECT DISTINCT ag.*\n" +
            "FROM adm_usuario_rel_grupo au\n" +
            "    inner join adm_usuario a\n" +
            "        on a.id = au.usuario\n" +
            "    inner join adm_grupo ag on ag.id = au.grupo\n" +
            "where au.usuario = :idUser and ag.nombre in ('CAPEX', 'OPEX')", nativeQuery = true)
    List<AdmGrupoEntity> findAllByIdUser(Long idUser);

    @Query(value = "SELECT ag.*\n" +
            "FROM adm_grupo ag \n" +
            "WHERE NOMBRE = (select valor from adm_parametro where codigo = 'USER_DEFAULT_GROUP' limit 1) ", nativeQuery = true)
    List<AdmGrupoEntity> findDefaultGroup();

}
