package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Paiement;
import mg.inclusiv.mihary.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping("")
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @PostMapping("")
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        Paiement newPaiement = paiementService.createPaiement(paiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaiement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable(value = "id") Long paiementId)
            throws ResourceNotFoundException {
        Paiement paiement = paiementService.getPaiementById(paiementId);
        return ResponseEntity.ok().body(paiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable(value = "id") Long paiementId,
                                                   @RequestBody Paiement paiementDetails) throws ResourceNotFoundException {
        Paiement updatedPaiement = paiementService.updatePaiement(paiementId, paiementDetails);
        return ResponseEntity.ok(updatedPaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaiement(@PathVariable(value = "id") Long paiementId)
            throws ResourceNotFoundException {
        paiementService.deletePaiement(paiementId);
        return ResponseEntity.noContent().build();
    }
}