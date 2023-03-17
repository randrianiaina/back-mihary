package mg.inclusiv.mihary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategorie", nullable=false, length=10)
    private Long idCategorie;

    @Column(name ="nomCategorie",nullable = false ,length = 50)
    private String nomCategorie;

    @Column(length = 50,name = "descriptionCategorie",nullable = false)
    private String descriptionCategorie;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<mg.inclusiv.mihary.entity.Produit> produits;


    // Getters et setters
}

