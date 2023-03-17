package mg.inclusiv.mihary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Proxy(lazy=false)
@Entity
@Table(name = "approvisionnement")
public class Approvisionnement {
    @Id
    @Column(name = "idApprovisionnement",nullable = false,length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApprovisionnement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur",referencedColumnName = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_idProduit",referencedColumnName = "idProduit")
    private Produit produit;

    @Column(name="quantiteApprovisionnement", nullable=false)
    private Integer quantiteApprovisionnement;

    @Column(name="prixUnitaire", nullable=false)
    private BigDecimal prixUnitaire;

    @Column(name="dateApprovisionnement", nullable=false)
    private LocalDateTime dateApprovisionnement;

    // Getters et setters
}
