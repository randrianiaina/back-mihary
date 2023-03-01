package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.Service.PaiementService;

import mg.inclusiv.mihary.entity.Paiement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PaiementController {
    public PaiementService paiementService;
    @GetMapping("/list")
    public List<Paiement> paiementList(){return paiementService.paiementList();}
    @PostMapping("/addPaiement")
    public void ajouterPaiement(@RequestBody Paiement paiement){
        paiementService.save(paiement);
    }
    @DeleteMapping("/deletePaiement/{id}")
    public void supprimerPaiement(@PathVariable("id")Integer id){
        paiementService.delete(id);}
}
