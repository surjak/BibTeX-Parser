package bib.parser.exceptions;

public class RequiredFieldNotInEntry extends RuntimeException {
    public RequiredFieldNotInEntry() {
    }

    public RequiredFieldNotInEntry(String message) {
        super(message);
    }
}
