package bib.parser.exceptions;

public class BracketNotFoundException extends RuntimeException {
    public BracketNotFoundException() {
    }

    public BracketNotFoundException(String message) {
        super(message);
    }
}
