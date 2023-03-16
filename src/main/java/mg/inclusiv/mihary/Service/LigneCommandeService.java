package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.LigneCommande;
import mg.inclusiv.mihary.repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LigneCommandeService {
    @Autowired
    LigneCommandeRepository ligneCommandeRepository;

    public List<LigneCommande> ligneCommandeList(){
     return    ligneCommandeRepository.findAll();
    }

    public void deleteLigneCommandeById(Long id){
        ligneCommandeRepository.deleteById(id);
    }
    public LigneCommande saveLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepository.save(ligneCommande);
    }

}
