package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Commande;
import mg.inclusiv.mihary.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommadeController {
    @Autowired
    private CommandeService commandeService;
    @GetMapping("/list")
    public List<Commande> getAllCommandes() {
        return commandeService.commandeList();
    }
    @PostMapping("/new")
    public Commande saveCommande(@RequestBody Commande Commande) {
        return commandeService.saveCommande(Commande);
    }
    @DeleteMapping("/{id}")
    public void deleteCommandeById(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
