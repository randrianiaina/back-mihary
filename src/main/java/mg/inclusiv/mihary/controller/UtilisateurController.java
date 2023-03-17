package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Utilisateur;
import mg.inclusiv.mihary.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Integer id) {
        return utilisateurService.findById(id);
    }

    @GetMapping
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @PostMapping
    public Utilisateur create(@RequestBody @Valid Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Integer id, @RequestBody @Valid Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        utilisateurService.deleteById(id);
    }

    @GetMapping("/cooperatives")
    public List<Utilisateur> findAllCooperatives() {
        return utilisateurService.findAllCooperatives();
    }

    @GetMapping("/agriculteurs")
    public List<Utilisateur> findAllAgriculteurs() {
        return utilisateurService.findAllAgriculteurs();
    }

    @GetMapping("/cooperatives/{id}/agriculteurs")
    public List<Utilisateur> findAgriculteursByCooperativeId(@PathVariable Integer id) {
        return utilisateurService.findAgriculteursByCooperativeId(id);
    }

    @GetMapping("/login/{login}")
    public Utilisateur findByLogin(@PathVariable String login) {
        return utilisateurService.findByLogin(login);
    }

    @GetMapping("/email/{email}")
    public Utilisateur findByEmail(@PathVariable String email) {
        return utilisateurService.findByEmail(email);
    }

    @PutMapping("/{id}/solde")
    public Utilisateur updateSolde(@PathVariable Integer id, @RequestParam double montant) {
        return utilisateurService.updateSolde(id, montant);
    }
}