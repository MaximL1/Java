package md.codefactory.html.gramada;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Long id) {
        super("Could not find users " + id);
    }
}
