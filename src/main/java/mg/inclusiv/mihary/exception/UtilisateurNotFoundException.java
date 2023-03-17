package mg.inclusiv.mihary.exception;

public class UtilisateurNotFoundException extends RuntimeException {
    public UtilisateurNotFoundException(Integer id) {
        super("Utilisateur non trouvé avec l'ID : " + id);
    }
}
