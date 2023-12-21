package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.TestEntity;
import gt.com.tigo.accruedautomation.util.repository.DefaultCatalogRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>, JpaSpecificationExecutor<TestEntity>, DefaultCatalogRepository {

    @Query(
            value = "SELECT " +
                    "id, " +
                    "item_name " +
                    "FROM test " +
                    "ORDER BY item_name ASC",
            nativeQuery = true
    )
    List<Object> getCatalog();

}
