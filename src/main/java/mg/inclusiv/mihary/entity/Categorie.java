package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    @OneToMany(mappedBy = "categorie")
    private List<mg.inclusiv.mihary.entity.Produit> produits;

    // Getters et setters
}

