package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
