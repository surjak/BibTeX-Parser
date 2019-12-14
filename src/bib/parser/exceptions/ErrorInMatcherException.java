package bib.parser.exceptions;

public class ErrorInMatcherException extends RuntimeException {
    public ErrorInMatcherException() {
    }

    public ErrorInMatcherException(String message) {
        super(message);
    }
}
