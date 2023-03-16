package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Notification;
import mg.inclusiv.mihary.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    public NotificationService notificationService;
    @GetMapping("/list")
    public List<Notification> NotificationList(){
        return notificationService.notificationList();
    }
    @PostMapping("/add")
    public void ajouterNotification(@RequestBody Notification Notification){
        notificationService.saveNotif(Notification);
    }
    @DeleteMapping("/delete/{id}")
    public void supprimerNotification(@PathVariable("id")Long id){
        notificationService.deleteNotificationById(id);}





}
