
package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.time.LocalDateTime;



    @Entity
    @Table(name = "notification")
    public class Notification {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idNotification;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "utilisateur_idUtilisateur")
        private Utilisateur utilisateur;

        @Column(length = 50)
        private String messageNotification;

        private Boolean lu;

        private LocalDateTime dateNotification;

        // Getters et setters
    }
