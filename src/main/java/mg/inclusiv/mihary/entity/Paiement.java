package mg.inclusiv.mihary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refPaiement")
    private Long refPaiement;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_idCommande")
    private Commande commande;

    @Column(name = "montantPaiement")
    private BigDecimal montantPaiement;

    @Column(length = 50,name ="modePaiement" )
    private String modePaiement;

    @Column(length = 50,name ="statutPaiement" )
    private String statutPaiement;

    @Column(name = "datePaiement")
    private LocalDateTime datePaiement;

    // Getters et setters
}
