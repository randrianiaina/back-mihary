package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Commande;
import mg.inclusiv.mihary.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande getCommandeById(Long commandeId) throws ResourceNotFoundException {
        return commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + commandeId));
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande updateCommande(Long commandeId, Commande commandeDetails) throws ResourceNotFoundException {
        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + commandeId));
        commande.setDateCommande(commandeDetails.getDateCommande());
        commande.setRefCommande(commandeDetails.getRefCommande());
        commande.setStatutCommande(commandeDetails.getStatutCommande());
        commande.setLignesDeCommande(commandeDetails.getLignesDeCommande());
        commande.setUtilisateur(commandeDetails.getUtilisateur());
        final Commande updatedCommande = commandeRepository.save(commande);
        return updatedCommande;
    }

    public void deleteCommande(Long commandeId) throws ResourceNotFoundException {
        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + commandeId));
        commandeRepository.delete(commande);
    }
}