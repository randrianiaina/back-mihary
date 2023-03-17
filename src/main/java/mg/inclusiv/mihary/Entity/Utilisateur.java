package mg.inclusiv.mihary.entity;


    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.List;

    @Entity
    @org.hibernate.annotations.Proxy(lazy=false)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Inheritance(strategy=InheritanceType.SINGLE_TABLE)

    @Table(name = "utilisateur")
    public class Utilisateur implements Serializable {
        @Id
        @Column(name="idUtilisateur", nullable=false, length=10)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(length = 12,nullable=false,unique = true)
        private String login;

        @Column(length = 32,nullable=false)
        private String mdpUtilisateur;

        @Column(length = 50,nullable=false)
        private String nomUtilisateur;

        @Column(length = 50,nullable=false)
        private String prenomUtilisateur;

        @Column(length = 50,nullable=false)
        private String adresseUtilisateur;

        @Column(length = 50,nullable=false)
        private String contactUtilisateur;

        @Column(length = 50,nullable=false,unique = true)
        private String email;

        @Column()
        private Double soldeUtilisateur;

        @Lob
        @Column()
        private byte[] photoUtilisateur;

        @Column(length = 10)
        private Long nifCoop;

        @Column(length = 17)
        private Long statCoop;

        @Column(length = 20,nullable=false)
        private String telephoneUtilisateur;

        @Column(length = 50)
        private String responsableCoop;

        @Column(length = 50)
        private String statutCompteCoop;

        @Column(length = 12)
        private Long cinAgriculeur;

        @ManyToOne(fetch = FetchType.LAZY)
        @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
        @JoinColumn(name = "cooperative_id")
        private Utilisateur cooperative;

        @JsonIgnore
        @OneToMany(mappedBy = "cooperative", fetch = FetchType.LAZY)
        @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
        private List<Utilisateur> agriculteurs;

        @JsonIgnore
        @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
        @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
        private List<Commande> commandes;

        public enum TypeUtilisateur {
            COOPERATIVE,
            AGRICULTEUR,
            CLIENT
        }

        @Enumerated(EnumType.STRING)
        private TypeUtilisateur typeUtilisateur;

        public void setTypeUtilisateur(String typeUtilisateur) {
            this.typeUtilisateur = TypeUtilisateur.valueOf(typeUtilisateur);
        }
    }
