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
    private Long idCategorie;
    @Column(length = 50)
    private String nomCategorie;
    @Column(length = 50,nullable = true)
    private String descriptionCategorie;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;


    // Getters et setters
}

