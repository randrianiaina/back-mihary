package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.util.Date;

public class Paiement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idPaiement;
    @ManyToOne
    @JoinColumn(name = "utilisateurId")
    private mg.inclusiv.mihary.entity.Utilisateur utilisateur;
    private Date datePaiement;
    private Double montanPaiement;
    private String modePaiement;;
}
