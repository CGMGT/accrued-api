package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.HistoricoProcesosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoricoProcesosRepository extends JpaRepository<HistoricoProcesosEntity, Long>, JpaSpecificationExecutor<HistoricoProcesosEntity> {
    @Query( value = "SELECT DISTINCT estado AS value, estado AS label FROM historico_procesos ORDER BY estado ASC LIMIT 10" , nativeQuery = true)
    List<Object> getStatus();

    @Query( value = "SELECT DISTINCT usuario_ejecucion FROM historico_procesos WHERE usuario_ejecucion LIKE %:usuario% ORDER BY usuario_ejecucion ASC LIMIT 10", nativeQuery = true)
    List<Object> getUserProcesos(String usuario);

    @Query( value = "SELECT DISTINCT nombre FROM historico_procesos WHERE nombre LIKE %:nombre% ORDER BY nombre ASC LIMIT 10", nativeQuery = true)
    List<Object> getNombreProceso(String nombre);

    @Query( value = "SELECT * " +
            "FROM historico_procesos " +
            "WHERE nombre " +
            "LIKE %:name% " +
            "AND descripcion " +
            "LIKE %:period% " +
            "ORDER BY fecha_inicial_ejecucion " +
            "DESC LIMIT 10", nativeQuery = true)
    List<HistoricoProcesosEntity> getMostRecentProcess(String name, String period);

    @Query( value = "SELECT * " +
            "FROM historico_procesos " +
            "WHERE estado = 'F' " +
            "AND fecha_inicial_ejecucion = (" +
            "   SELECT MAX(fecha_inicial_ejecucion) " +
            "   FROM historico_procesos " +
            "   WHERE nombre = :name " +
            "   AND descripcion LIKE (" +
            "       SELECT concat('%', valor, '%') " +
            "       FROM adm_parametro " +
            "       WHERE codigo = 'PERIODO'" +
            "   )" +
            ")",
            nativeQuery = true)
    List<HistoricoProcesosEntity> getSuccessValidation(String name);

    @Query(value = "SELECT * " +
            "FROM historico_procesos " +
            "WHERE estado = 'F' " +
            "AND fecha_inicial_ejecucion = (" +
            "   SELECT MAX(fecha_inicial_ejecucion) " +
            "   FROM historico_procesos " +
            "   WHERE nombre = :name " +
            "   AND descripcion LIKE (" +
            "       SELECT concat('%',valor,'%') " +
            "       FROM adm_parametro " +
            "       WHERE codigo = 'PERIODO'" +
            "   )" +
            ") " +
            "AND fecha_inicial_ejecucion > (" +
            "    SELECT DISTINCT h2.fecha_inicial_ejecucion " +
            "    FROM historico_procesos h2 " +
            "    WHERE h2.estado = 'F' " +
            "    AND h2.fecha_inicial_ejecucion = (" +
            "        SELECT MAX(h3.fecha_inicial_ejecucion) " +
            "        FROM historico_procesos h3 " +
            "        WHERE h3.nombre = :typeValidation " +
            "        AND h3.descripcion LIKE (" +
            "            SELECT concat('%', p0.valor, '%') " +
            "            FROM adm_parametro p0 " +
            "            WHERE p0.codigo = 'PERIODO'" +
            "        )" +
            "    )" +
            ")",
            nativeQuery = true)
    List<HistoricoProcesosEntity> getSuccessProcess(String name, String typeValidation);


}
