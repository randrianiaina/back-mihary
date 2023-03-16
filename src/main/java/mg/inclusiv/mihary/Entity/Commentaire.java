package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;


    @Column(length = 200)
    private String detailsCommentaire;

    private LocalDateTime dateCommentaire;

    // Getters et setters
}
