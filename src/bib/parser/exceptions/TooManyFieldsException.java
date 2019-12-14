package bib.parser.exceptions;

public class TooManyFieldsException extends RuntimeException {
    public TooManyFieldsException() {
    }

    public TooManyFieldsException(String message) {
        super(message);
    }
}
