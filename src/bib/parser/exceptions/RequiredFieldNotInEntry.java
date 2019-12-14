package bib.parser.exceptions;

/**
 * Exception thrown when Entry doesn't have all required fields
 */
public class RequiredFieldNotInEntry extends RuntimeException {
    public RequiredFieldNotInEntry() {
    }

    public RequiredFieldNotInEntry(String message) {
        super(message);
    }
}
