package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
