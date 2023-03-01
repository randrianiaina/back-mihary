package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
