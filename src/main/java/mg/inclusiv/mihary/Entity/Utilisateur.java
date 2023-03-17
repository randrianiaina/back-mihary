package mg.inclusiv.mihary.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUtilisateur;
    @Column(length = 12)
    private String loginUtilisateur;
    @Column(length = 32)
    private String mdpUtilisateur;
    @Column(length = 50)
    private String  nomUtilisateur;
    @Column(length = 50)
    private String adresseUtilisateur;
    @Column(length = 50)
    private String contactUtilisateur;
    @Column(length = 50)
    private String emailUtilisateur;
    @Column(nullable = true)
    private double soldeUtilisateur;
    @Column(nullable = true)
    private Blob photoUtilisateur;
    @Column(length = 10,nullable = true)
    private long nifCoop;
    @Column(length = 17,nullable = true)
    private long statCoop;
    @Column(length = 50,nullable = true)
    private String responsableCoop;
    @Column(length = 50,nullable = true)
    private String statutCompteCoop;
    @Column(length = 50,nullable = false)
    private String typeCompteUtilisateur;
    @Column(length = 12,nullable = true)
    private long cinAgriculeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cooperative_id")
    private Utilisateur cooperative;

    @OneToMany(mappedBy = "cooperative", fetch = FetchType.LAZY)
    private List<Utilisateur> agriculteur;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private List<Commande> commandes;

        public enum TypeUtilisateur {
            COOPERATIVE,
            AGRICULTEUR,
            CLIENT
        }

        @Enumerated(EnumType.STRING)
        private TypeUtilisateur typeUtilisateur;

}
