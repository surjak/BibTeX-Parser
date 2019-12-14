package bib.parser.exceptions;


/**
 * Exception thrown when Matcher can't match any value
 */
public class ErrorInMatcherException extends RuntimeException {
    public ErrorInMatcherException() {
    }

    public ErrorInMatcherException(String message) {
        super(message);
    }
}
