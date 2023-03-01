package mg.inclusiv.mihary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable=false, length=10)
    private Integer id;

    @ManyToOne
    @JoinColumns(value={ @JoinColumn(name="produitsid", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKQualite283251"))
    private Produit produit;

    @Column(name="Typequalite", nullable=true, length=255)
    private String typequalite;

    @Column(name="Prixvente", nullable=true)
    private double prixvente;
}
