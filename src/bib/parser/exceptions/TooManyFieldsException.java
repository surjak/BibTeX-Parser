package bib.parser.exceptions;

/**
 * Exception thrown when record have colliding fields
 */
public class TooManyFieldsException extends RuntimeException {
    public TooManyFieldsException() {
    }

    public TooManyFieldsException(String message) {
        super(message);
    }
}
