package mg.inclusiv.mihary.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer utilisateurId;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String mdp;

    @Column(nullable = false)
    private String  nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double solde;

    //private Blob photo;

    @Column(nullable = true)
    private long nifcoop;

    @Column(nullable = true)
    private long statcoop;

    @Column(nullable = true)
    private String responsable;

    @Column(nullable = true)
    private String statutcomptecoop;

    @Column(nullable = true)
    private long cinagr;

    @OneToMany(mappedBy = "deal")
    private List<Deal> deal;

    @OneToMany(mappedBy = "approvisionnement")
    private List<Approvisionnement> appro;

    @OneToMany(mappedBy = "commande")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "paiement")
    private List<Paiement> paiements;

}
