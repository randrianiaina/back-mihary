package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.LigneCommande;
import mg.inclusiv.mihary.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignecommande")
public class LigneCommandeController {
    @Autowired
    public LigneCommandeService ligneCommandeService;
    @GetMapping("/list")
    public List<LigneCommande> LigneCommandeList(){
        return ligneCommandeService.ligneCommandeList();
    }
    @PostMapping("/add")
    public void ajouterLigneCommande(@RequestBody LigneCommande LigneCommande){
        ligneCommandeService.saveLigneCommande(LigneCommande);
    }
    @DeleteMapping("/delete/{id}")
    public void supprimerLigneCommande(@PathVariable ("id")Long id){
        ligneCommandeService.deleteLigneCommandeById(id);}





}