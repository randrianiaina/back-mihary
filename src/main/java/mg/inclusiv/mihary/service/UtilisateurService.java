package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.entity.Utilisateur;
import mg.inclusiv.mihary.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> cooperativeList() {return utilisateurRepository.findAll();}

    public Utilisateur saveUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUser(int id) {utilisateurRepository.deleteById(id); }



}
