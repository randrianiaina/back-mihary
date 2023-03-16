package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Approvisionnement;
import mg.inclusiv.mihary.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovisionnementService {
    @Autowired
    ApprovisionnementRepository approvisionnementRepository;
    public List<Approvisionnement> approvisionnementList (){
        return approvisionnementRepository.findAll();
    }
    public Approvisionnement saveApprovisionnement(Approvisionnement approvisionnement){
        return approvisionnementRepository.save(approvisionnement);
    }
    public void deleteApprovisionnement(Long id) {
        approvisionnementRepository.deleteById(id);
    }
    public Optional<Approvisionnement> findByIdApprovisionnement(Long id){
        return approvisionnementRepository.findById(id);
    }
}
