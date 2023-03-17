package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Categorie;
import mg.inclusiv.mihary.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long categorieId) throws ResourceNotFoundException {
        return categorieRepository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + categorieId));
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Long categorieId, Categorie categorieDetails) throws ResourceNotFoundException {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + categorieId));

        categorie.setNomCategorie(categorieDetails.getNomCategorie());
        categorie.setDescriptionCategorie(categorieDetails.getDescriptionCategorie());

        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Long categorieId) throws ResourceNotFoundException {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + categorieId));

        categorieRepository.delete(categorie);
    }
}