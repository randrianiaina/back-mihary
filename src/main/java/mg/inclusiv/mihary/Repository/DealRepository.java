package mg.inclusiv.mihary.Repository;

import mg.inclusiv.mihary.Entity.Deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface DealRepository extends JpaRepository<Deal,Integer> {
    }

