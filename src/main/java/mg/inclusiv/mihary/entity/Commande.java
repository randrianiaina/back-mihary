package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produit")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
