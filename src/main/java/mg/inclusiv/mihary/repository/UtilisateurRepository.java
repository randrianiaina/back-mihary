package mg.inclusiv.mihary.repository;

import mg.inclusiv.mihary.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByLogin(String login);
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByTypeUtilisateur(Utilisateur.TypeUtilisateur typeUtilisateur);
    List<Utilisateur> findByCooperativeIdAndTypeUtilisateur(Integer cooperativeId, Utilisateur.TypeUtilisateur typeUtilisateur);
}
