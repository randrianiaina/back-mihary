package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private BigDecimal prix;

    private Blob photoProduit;

    private Integer quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "approvisionnement")
    private List<Approvisionnement> appro;

    @OneToOne(mappedBy = "panier")
    private Panier panier;

    // Getters et setters
}

