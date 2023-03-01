package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }
}
