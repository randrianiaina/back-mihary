package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Commentaire;
import mg.inclusiv.mihary.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable(value = "id") Long commentaireId)
            throws ResourceNotFoundException {
        Commentaire commentaire = commentaireService.getCommentaireById(commentaireId)
                .orElseThrow(() -> new ResourceNotFoundException("Commentaire non trouvé pour cet identifiant :: " + commentaireId));
        return ResponseEntity.ok().body(commentaire);
    }

    @PostMapping("")
    public Commentaire createCommentaire(@Valid @RequestBody Commentaire commentaire) {
        return commentaireService.createCommentaire(commentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable(value = "id") Long commentaireId,
                                                         @Valid @RequestBody Commentaire commentaireDetails) throws ResourceNotFoundException {
        Commentaire commentaire = commentaireService.getCommentaireById(commentaireId)
                .orElseThrow(() -> new ResourceNotFoundException("Commentaire non trouvé pour cet identifiant :: " + commentaireId));

        commentaire.setUtilisateur(commentaireDetails.getUtilisateur());
        commentaire.setDetailsCommentaire(commentaireDetails.getDetailsCommentaire());
        commentaire.setDateCommentaire(commentaireDetails.getDateCommentaire());
        final Commentaire updatedCommentaire = commentaireService.updateCommentaire(commentaire);
        return ResponseEntity.ok(updatedCommentaire);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCommentaire(@PathVariable(value = "id") Long commentaireId)
            throws ResourceNotFoundException {
        Commentaire commentaire = commentaireService.getCommentaireById(commentaireId)
                .orElseThrow(() -> new ResourceNotFoundException("Commentaire non trouvé pour cet identifiant :: " + commentaireId));

        commentaireService.deleteCommentaire(commentaire);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}