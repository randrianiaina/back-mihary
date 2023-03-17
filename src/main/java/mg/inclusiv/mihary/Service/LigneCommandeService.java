package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.LigneCommande;
import mg.inclusiv.mihary.repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public List<LigneCommande> getAllLigneCommandes() {
        return ligneCommandeRepository.findAll();
    }

    public LigneCommande getLigneCommandeById(Long id) throws ResourceNotFoundException {
        return ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ligne de commande non trouvée pour cet identifiant :: " + id));
    }

    public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    public LigneCommande updateLigneCommande(Long id, LigneCommande ligneCommandeDetails) throws ResourceNotFoundException {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ligne de commande non trouvée pour cet identifiant :: " + id));

        ligneCommande.setQuantiteLigneCommande(ligneCommandeDetails.getQuantiteLigneCommande());
        ligneCommande.setPrixUnitaire(ligneCommandeDetails.getPrixUnitaire());

        return ligneCommandeRepository.save(ligneCommande);
    }

    public void deleteLigneCommande(Long id) throws ResourceNotFoundException {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ligne de commande non trouvée pour cet identifiant :: " + id));

        ligneCommandeRepository.delete(ligneCommande);
    }
}


