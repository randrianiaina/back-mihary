package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Produit;
import mg.inclusiv.mihary.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("")
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @PostMapping("")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable(value = "id") Long produitId)
            throws ResourceNotFoundException {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit non trouvé pour cet identifiant :: " + produitId));
        return ResponseEntity.ok().body(produit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") Long produitId,
                                                 @RequestBody Produit produitDetails) throws ResourceNotFoundException {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit non trouvé pour cet identifiant :: " + produitId));

        produit.setNomProduit(produitDetails.getNomProduit());
        produit.setPrixProduit(produitDetails.getPrixProduit());
        produit.setDescriptionProduit(produitDetails.getDescriptionProduit());
        produit.setPhotoProduit(produitDetails.getPhotoProduit());
        final Produit updatedProduit = produitRepository.save(produit);
        return ResponseEntity.ok(updatedProduit);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long produitId)
            throws ResourceNotFoundException {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit non trouvé pour cet identifiant :: " + produitId));

        produitRepository.delete(produit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

