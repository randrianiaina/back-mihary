package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @GetMapping("/list")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    @PostMapping("/new")
    public Produit saveProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
    @DeleteMapping("/{id}")
    public void deleteProduitById(@PathVariable Long id) {
        produitService.deleteProduitById(id);
    }

    @PutMapping(path="/edit")
    public void updateProduit(@RequestBody Produit produit)
    {produitService.saveProduit(produit);}
}
