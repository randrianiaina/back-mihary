package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Commentaire;
import mg.inclusiv.mihary.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;
    @GetMapping("/list")
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.commentaireList();
    }
    @PostMapping("/new")
    public Commentaire saveCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.saveCommentaire(commentaire);
    }
    @DeleteMapping("/{id}")
    public void deleteCommentaireById(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
    }
}
