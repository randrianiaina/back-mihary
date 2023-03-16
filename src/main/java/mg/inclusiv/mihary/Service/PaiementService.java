package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Paiement;
import mg.inclusiv.mihary.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaiementService {
    @Autowired
    PaiementRepository paiementRepository;

    public List<Paiement> getAllPaiement() {
       return paiementRepository.findAll();
    }

    public Paiement savePaiement(Paiement paiement){
        return paiementRepository.save(paiement);
    }
    public void deletePaiement(Long id){
        paiementRepository.deleteById(id);
    }
}
