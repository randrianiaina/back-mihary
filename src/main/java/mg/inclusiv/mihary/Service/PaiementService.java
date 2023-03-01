package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Paiement;
import mg.inclusiv.mihary.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaiementService {
    @Autowired
    PaiementRepository paiementRepository;
    public List<Paiement> paiementList()
    {
        return paiementRepository.findAll();
    }
    public void save(Paiement paiement){
        paiementRepository.save(paiement);
    }
    public void delete(Integer id){
        paiementRepository.deleteById(id);
    }
}
