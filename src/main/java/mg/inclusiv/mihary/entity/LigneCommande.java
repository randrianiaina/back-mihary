package mg.inclusiv.mihary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ligneCommande")
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private double qtecommande;




}
