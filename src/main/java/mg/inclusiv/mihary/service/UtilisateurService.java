package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Utilisateur;
import mg.inclusiv.mihary.exception.UtilisateurNotFoundException;
import mg.inclusiv.mihary.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurService {


    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            return utilisateur.get();
        } else {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteById(Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            utilisateurRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }
    }

    public List<Utilisateur> findAllCooperatives() {
        return utilisateurRepository.findByTypeUtilisateur(Utilisateur.TypeUtilisateur.COOPERATIVE);
    }

    public List<Utilisateur> findAllAgriculteurs() {
        return utilisateurRepository.findByTypeUtilisateur(Utilisateur.TypeUtilisateur.AGRICULTEUR);
    }

    public List<Utilisateur> findAgriculteursByCooperativeId(Integer id) {
        return utilisateurRepository.findByCooperativeIdAndTypeUtilisateur(id, Utilisateur.TypeUtilisateur.AGRICULTEUR);
    }

    public Utilisateur findByLogin(String login) {
        return utilisateurRepository.findByLogin(login);
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur update(Integer id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
            existingUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
            existingUtilisateur.setLogin(utilisateur.getLogin());
            existingUtilisateur.setMdpUtilisateur(utilisateur.getMdpUtilisateur());
            existingUtilisateur.setAdresseUtilisateur(utilisateur.getAdresseUtilisateur());
            existingUtilisateur.setTelephoneUtilisateur(utilisateur.getTelephoneUtilisateur());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setCooperative(utilisateur.getCooperative());
            return utilisateurRepository.save(existingUtilisateur);
        } else {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id);
        }
    }
    public Utilisateur updateSolde(Integer id, double montant) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException(id));

        double nouveauSolde = utilisateur.getSoldeUtilisateur() + montant;
        utilisateur.setSoldeUtilisateur(nouveauSolde);

        return utilisateurRepository.save(utilisateur);
    }
}