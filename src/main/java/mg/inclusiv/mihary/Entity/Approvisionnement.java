package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "approvisionnement")
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApprovisionnement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_idProduit")
    private Produit produit;

    private Integer quantite;

    private BigDecimal prixUnitaire;

    private LocalDateTime dateApprovisionnement;

    // Getters et setters
}
