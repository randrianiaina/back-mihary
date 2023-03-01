package mg.inclusiv.mihary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDeal;
    @ManyToOne()
    @JoinColumn(name = "utilisateurId")
    private mg.inclusiv.mihary.entity.Utilisateur utilisateur;
    private Date dateDeal;
    private Double montantDeal;
    private String typeDeal;
    private String libelleDeal;
}
