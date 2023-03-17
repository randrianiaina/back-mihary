package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        return optionalProduit.orElse(null);
    }

    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
