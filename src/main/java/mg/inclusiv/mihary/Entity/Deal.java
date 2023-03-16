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
    //transaction effectuer par la Cooperative
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idDeal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;
    private Date dateDeal;
    private Double montantDeal;

    @Column(length = 50)
    private String typeDeal;
    @Column(length = 50,nullable = true)
    private String libelleDeal;
}
