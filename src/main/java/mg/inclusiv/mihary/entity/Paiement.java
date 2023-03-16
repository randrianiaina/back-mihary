package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refPaiement;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_idCommande")
    private Commande commande;

    private BigDecimal montantPaiement;

    @Column(length = 50)
    private String modePaiement;

    @Column(length = 50)
    private String statutPaiement;

    private LocalDateTime datePaiement;

    // Getters et setters
}
