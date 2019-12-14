package bib.parser.exceptions;

public class ValueNotInStringMapException extends RuntimeException {
    public ValueNotInStringMapException() {
    }

    public ValueNotInStringMapException(String message) {
        super(message);
    }
}
