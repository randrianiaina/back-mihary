package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/list")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }
    @PostMapping("/new")
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorieById(@PathVariable Long id) {
        categorieService.deleteCategorieById(id);
    }
}
