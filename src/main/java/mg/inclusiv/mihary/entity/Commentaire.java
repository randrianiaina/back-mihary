package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommentaire")
    private Long idCommentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;


    @Column(length = 200,name = "detailsCommentaire")
    private String detailsCommentaire;

    @Column(name = "dateCommentaire")
    private LocalDateTime dateCommentaire;

    // Getters et setters
}
