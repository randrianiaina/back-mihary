package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Integer> {
}
