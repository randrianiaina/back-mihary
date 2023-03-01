package mg.inclusiv.mihary.entity;


import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer utilisateurId;
    private String login;
    private String mdp;
    private String  nom;
    private String adresse;
    private String contact;
    private String email;
    private double solde;
    //private Blob photo;
    private long nifcoop;
    private long statcoop;
    private String responsable;
    private String statutcomptecoop;
    private long cinagr;




}
