package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idApprovisionnement;
    private LocalDate dateajout;
    private Double qteajout;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Produit produit;
}
