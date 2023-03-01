package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Utilisateur;
import mg.inclusiv.mihary.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cooperative")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping("/list")
    public List<Utilisateur> cooperativeList(){
        return utilisateurService.cooperativeList();
    }

    @PostMapping("/addUser")
    public void ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.saveUser(utilisateur);
    }

    @DeleteMapping(path="/deleteUser/{id}")
    public void supprimerUtilisateur(@PathVariable Integer id){
        utilisateurService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public void modifierUtilisateur(@RequestBody Utilisateur utilisateur){utilisateurService.saveUser(utilisateur);}
}
