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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idDeal")
    private Integer idDeal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_idUtilisateur")
    private Utilisateur utilisateur;

    @Column(name = "dateDeal")
    private Date dateDeal;

    @Column(name = "montantDeal")
    private Double montantDeal;

    @Column(length = 50,name = "typeDeal")
    private String typeDeal;

    @Column(length = 50,name = "libelleDeal")
    private String libelleDeal;
}
