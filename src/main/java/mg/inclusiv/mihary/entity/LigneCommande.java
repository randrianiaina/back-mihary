package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ligneCommande")
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLigneCommande")
    private Long idLigneCommande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_idUtilisateur")
    private Commande commande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_idProduit")
    private Produit produit;

    @Column(name = "quantiteLigneCommande")
    private Integer quantiteLigneCommande;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
