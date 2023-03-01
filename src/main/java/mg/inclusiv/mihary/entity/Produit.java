package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private BigDecimal prix;

    private Integer quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



    // Getters et setters
}

