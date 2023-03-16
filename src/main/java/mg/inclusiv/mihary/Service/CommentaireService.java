package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Commentaire;
import mg.inclusiv.mihary.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    public List<Commentaire> commentaireList(){
        return commentaireRepository.findAll();
    }

    public Commentaire saveCommentaire(Commentaire commentaire){
        return commentaireRepository.save(commentaire);
    }
    public void deleteCommentaire(Long id){
        commentaireRepository.deleteById(id);
    }
    public Optional<Commentaire> findByIdCommentaire(Long id) {
        return commentaireRepository.findById(id);
    }
}
