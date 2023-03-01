package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Qualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualiteRepository extends JpaRepository<Qualite, Integer> {
}
