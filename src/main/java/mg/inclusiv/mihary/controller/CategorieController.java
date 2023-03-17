package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategorieController {


    @Autowired
    private CategorieService categorieService;

    @GetMapping("")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") Long categorieId)
            throws ResourceNotFoundException {
        Categorie categorie = categorieService.getCategorieById(categorieId);
        return ResponseEntity.ok().body(categorie);
    }

    @PostMapping("")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieService.createCategorie(categorie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long categorieId,
                                                     @Valid @RequestBody Categorie categorieDetails) throws ResourceNotFoundException {
        Categorie updatedCategorie = categorieService.updateCategorie(categorieId, categorieDetails);
        return ResponseEntity.ok(updatedCategorie);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long categorieId)
            throws ResourceNotFoundException {
        categorieService.deleteCategorie(categorieId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}