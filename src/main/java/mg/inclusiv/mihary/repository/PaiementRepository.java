package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
