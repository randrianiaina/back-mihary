package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Paiement;
import mg.inclusiv.mihary.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    public PaiementService paiementService;
    @GetMapping("/list")
    public List<Paiement> PaiementList(){
        return paiementService.getAllPaiement();
    }
    @PostMapping("/add")
    public void ajouterPaiement(@RequestBody Paiement Paiement){
        paiementService.savePaiement(Paiement);
    }
    @DeleteMapping("/delete/{id}")
    public void supprimerPaiement(@PathVariable ("id")Long id){
        paiementService.deletePaiement(id);}





}