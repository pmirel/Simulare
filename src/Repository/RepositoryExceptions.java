package Repository;

public class RepositoryExceptions extends RuntimeException {
    RepositoryExceptions(String message) {

        super("Repository Exception ||| " + message);
    }
}