package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;
    private LocalDate dateCommande;
    @Column(length = 50)
    private String refCommande;
    @Column(length = 50,nullable = true)
    private String statutCommande;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesDeCommande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;

    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    private Paiement paiement;

}
