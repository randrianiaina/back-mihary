package mg.inclusiv.mihary.controller;



import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieController {

    private CategorieService categorieService;

    @GetMapping("")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }



    @PostMapping("")
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorieById(@PathVariable Long id) {
        categorieService.deleteCategorieById(id);
    }
}
