package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplateEntity, Long>, JpaSpecificationExecutor<EmailTemplateEntity> {
}
