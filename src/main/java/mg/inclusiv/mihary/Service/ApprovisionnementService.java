package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Approvisionnement;
import mg.inclusiv.mihary.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement getApprovisionnementById(Long id) throws ResourceNotFoundException {
        return approvisionnementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Approvisionnement introuvable avec l'id : " + id));
    }

    public Approvisionnement saveApprovisionnement(Approvisionnement approvisionnement) {
        return approvisionnementRepository.save(approvisionnement);
    }

    public Approvisionnement updateApprovisionnement(Long id, Approvisionnement approvisionnementDetails) throws ResourceNotFoundException {
        Approvisionnement approvisionnement = approvisionnementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Approvisionnement introuvable avec l'id : " + id));

        approvisionnement.setProduit(approvisionnementDetails.getProduit());
        approvisionnement.setQuantiteApprovisionnement(approvisionnementDetails.getQuantiteApprovisionnement());
        approvisionnement.setPrixUnitaire(approvisionnementDetails.getPrixUnitaire());
        approvisionnement.setDateApprovisionnement(approvisionnementDetails.getDateApprovisionnement());
        approvisionnement.setUtilisateur(approvisionnementDetails.getUtilisateur());

        return approvisionnementRepository.save(approvisionnement);
    }

    public void deleteApprovisionnement(Long id) throws ResourceNotFoundException {
        Approvisionnement approvisionnement = approvisionnementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Approvisionnement introuvable avec l'id : " + id));
        approvisionnementRepository.delete(approvisionnement);
    }
}
