package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long>, JpaSpecificationExecutor<EmpleadosEntity> {

    @Query( value = "SELECT DISTINCT correo_tigo FROM empleados WHERE correo_tigo LIKE %:name% ORDER BY correo_tigo ASC LIMIT 10", nativeQuery = true)
    List<Object> getEmployeesEmail(String name);

    List<EmpleadosEntity> findByCorreoTigo(String correoTigo);
}
