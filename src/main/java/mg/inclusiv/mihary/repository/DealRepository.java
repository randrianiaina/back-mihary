package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface DealRepository extends JpaRepository<Deal,Integer> {
    }

