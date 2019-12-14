package bib.parser.exceptions;

/**
 * Exception thrown when value wasn't found in StringService
 */
public class ValueNotInStringMapException extends RuntimeException {
    public ValueNotInStringMapException() {
    }

    public ValueNotInStringMapException(String message) {
        super(message);
    }
}
