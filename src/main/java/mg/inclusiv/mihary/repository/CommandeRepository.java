package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
