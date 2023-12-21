package gt.com.tigo.accruedautomation.dao;

import gt.com.tigo.accruedautomation.model.NotificacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduledNotificationsRepository extends JpaRepository<NotificacionesEntity, Long>, JpaSpecificationExecutor<NotificacionesEntity> {

    List<NotificacionesEntity> findAllByPeriodoAndStatus(String periodo, String status);
}
