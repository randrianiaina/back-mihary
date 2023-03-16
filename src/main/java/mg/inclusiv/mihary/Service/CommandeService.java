package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Commande;
import mg.inclusiv.mihary.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    public List<Commande> commandeList(){
        return commandeRepository.findAll();
    }

    public Commande saveCommande( Commande commande){
        return commandeRepository.save(commande);
    }

    public void deleteCommande(Long id){
        commandeRepository.deleteById(id);
    }


    public Optional<Commande> findByIdCommande(Long id) {
        return commandeRepository.findById(id);
    }

}
