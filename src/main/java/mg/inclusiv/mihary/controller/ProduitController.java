package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }



    @PostMapping("")
    public Produit saveProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
    @DeleteMapping("/{id}")
    public void deleteProduitById(@PathVariable Long id) {
        produitService.deleteProduitById(id);
    }
}
