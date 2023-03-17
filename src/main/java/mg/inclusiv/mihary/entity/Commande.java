package mg.inclusiv.mihary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Long idCommande;

    @Column(name = "dateCommande")
    private LocalDate dateCommande;

    @Column(length = 50,name = "refCommande")
    private String refCommande;

    @Column(length = 50,name = "statutCommande")
    private String statutCommande;

    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesDeCommande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;

    @JsonIgnore
    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    private Paiement paiement;

}
