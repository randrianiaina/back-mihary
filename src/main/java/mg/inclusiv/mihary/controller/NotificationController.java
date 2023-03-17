package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Notification;
import mg.inclusiv.mihary.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping("")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable(value = "id") Long notificationId)
            throws ResourceNotFoundException {
        Notification notification = notificationService.getNotificationById(notificationId);
        return ResponseEntity.ok().body(notification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable(value = "id") Long notificationId,
                                                     @RequestBody Notification notification) {
        notification.setIdNotification(notificationId);
        notificationService.updateNotification(notification);
        return ResponseEntity.ok("Notification mise à jour avec succès.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable(value = "id") Long notificationId)
            throws ResourceNotFoundException {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok("Notification supprimée avec succès.");
    }
}
