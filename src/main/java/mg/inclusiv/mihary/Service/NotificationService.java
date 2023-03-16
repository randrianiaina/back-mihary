package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Notification;
import mg.inclusiv.mihary.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> notificationList(){
        return  notificationRepository.findAll();
    }

    public Notification saveNotif(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }
}
