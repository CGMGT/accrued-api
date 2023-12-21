package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.PeriodosEntity;
import gt.com.tigo.accruedautomation.util.repository.DefaultCatalogRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodosRepository extends JpaRepository<PeriodosEntity, Long>, JpaSpecificationExecutor<PeriodosEntity>, DefaultCatalogRepository {

    @Query(
            value = "SELECT nombre AS value, nombre AS label " +
                    "FROM periodos " +
                    "WHERE TO_DATE(nombre, 'MM-YYYY') <= NOW() " +
                    "ORDER BY id DESC " +
                    "LIMIT 12",
            nativeQuery = true
    )
    List<Object> getCatalog();

    @Query( value = "SELECT DISTINCT nombre FROM periodos WHERE nombre LIKE %:name% ORDER BY nombre ASC LIMIT 10", nativeQuery = true)
    List<Object> getPeriodsByName(String name);

    @Query(
            value = "SELECT nombre " +
                    "FROM periodos " +
                    "WHERE TO_DATE(nombre, 'MM-YYYY') <= NOW() " +
                    "ORDER BY id DESC " +
                    "LIMIT 12",
            nativeQuery = true
    )
    List<Object> getCatalogRecent();

}
