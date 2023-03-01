package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Double qteCommande;

    private Double prixActuel;

}
