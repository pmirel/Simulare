package Domain;

public class AgendaValidatorExceptions extends RuntimeException {
    AgendaValidatorExceptions(String message) {

        super("Agenda Validator Exception ||| " + message);
    }
}