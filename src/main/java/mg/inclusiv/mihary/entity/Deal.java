package mg.inclusiv.mihary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDeal;

    private Date dateDeal;
    private Double montantDeal;
    private String typeDeal;
    private String libelleDeal;

  @ManyToOne
    private Utilisateur utilisateur;

}
