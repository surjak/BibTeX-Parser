package bib.parser.exceptions;

/**
 * Exception thrown when record doesn't have closing bracket
 */
public class BracketNotFoundException extends RuntimeException {
    public BracketNotFoundException() {
    }

    public BracketNotFoundException(String message) {
        super(message);
    }
}
