package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Paiement;
import mg.inclusiv.mihary.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement getPaiementById(Long paiementId) throws ResourceNotFoundException {
        return paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement non trouvé pour cet identifiant :: " + paiementId));
    }

    public Paiement updatePaiement(Long paiementId, Paiement paiementDetails) throws ResourceNotFoundException {
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement non trouvé pour cet identifiant :: " + paiementId));

        paiement.setMontantPaiement(paiementDetails.getMontantPaiement());
        paiement.setModePaiement(paiementDetails.getModePaiement());
        paiement.setStatutPaiement(paiementDetails.getStatutPaiement());
        return paiementRepository.save(paiement);
    }

    public void deletePaiement(Long paiementId) throws ResourceNotFoundException {
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement non trouvé pour cet identifiant :: " + paiementId));
        paiementRepository.delete(paiement);
    }
}