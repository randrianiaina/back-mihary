package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Notification;
import mg.inclusiv.mihary.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification createNotification(Notification notification) {
        notification.setDateNotification(LocalDateTime.now());
        notification.setLu(false);
        return notificationRepository.save(notification);
    }

    public Notification getNotificationById(Long notificationId) throws ResourceNotFoundException {
        return notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification non trouvée pour cet identifiant :: " + notificationId));
    }

    public void updateNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    public void deleteNotification(Long notificationId) throws ResourceNotFoundException {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification non trouvée pour cet identifiant :: " + notificationId));
        notificationRepository.delete(notification);
    }
}
