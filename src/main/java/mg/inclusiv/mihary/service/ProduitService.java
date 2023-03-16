package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }


    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    public void findProduitById(Long id){
        produitRepository.findById(id);
    }


}
