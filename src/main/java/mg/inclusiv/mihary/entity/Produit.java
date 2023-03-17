package mg.inclusiv.mihary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "idProduit" )
    private Long idProduit;

    @Column(length = 50,name = "nomProduit")
    private String nomProduit;

    @Column(length = 200,name = "descriptionProduit")
    private String descriptionProduit;
    @Column(name = "prixProduit")
    private BigDecimal prixProduit;

    @Column(name = "photoProduit")
    private Blob photoProduit;

    @Column(name = "stockProduit" )
    private Integer stockProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_idCategorie")
    private Categorie categorie;

    @JsonIgnore
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<Approvisionnement> approvisionnements;

    @JsonIgnore
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<LigneCommande> lignesDeCommande;

    // Getters et setters
}

