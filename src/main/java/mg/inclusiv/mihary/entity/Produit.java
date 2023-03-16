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
    private Long idProduit;

    @Column(length = 50)
    private String nomProduit;

    @Column(length = 50)
    private String descriptionProduit;

    private BigDecimal prixProduit;

    @Column(nullable = true)
    private Blob photoProduit;

    @Column(nullable = true)
    private Integer stockProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_idCategorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<Approvisionnement> approvisionnements;


    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<LigneCommande> lignesDeCommande;

    // Getters et setters
}

