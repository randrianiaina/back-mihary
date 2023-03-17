package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.LigneCommande;
import mg.inclusiv.mihary.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligne-commande")
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping("")
    public List<LigneCommande> getAllLigneCommandes() {
        return ligneCommandeService.getAllLigneCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        LigneCommande ligneCommande = ligneCommandeService.getLigneCommandeById(id);
        return ResponseEntity.ok().body(ligneCommande);
    }

    @PostMapping("")
    public LigneCommande createLigneCommande(@RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.createLigneCommande(ligneCommande);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommande> updateLigneCommande(@PathVariable(value = "id") Long id,
                                                             @RequestBody LigneCommande ligneCommandeDetails)
            throws ResourceNotFoundException {
        LigneCommande updatedLigneCommande = ligneCommandeService.updateLigneCommande(id, ligneCommandeDetails);
        return ResponseEntity.ok(updatedLigneCommande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneCommande(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ligneCommandeService.deleteLigneCommande(id);
        return ResponseEntity.noContent().build();
    }
}