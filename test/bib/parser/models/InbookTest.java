package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InbookTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.YEAR, "12");
        fields.put(FieldType.PUBLISHER, "12");
        fields.put(FieldType.TITLE, "12");

        fields.put(FieldType.CHAPTER, "12");

        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Inbook conference = new Inbook(fields, key);
        });
        fields.put(FieldType.EDITOR, "a");
        Inbook conference = new Inbook(fields, key);
        fields.put(FieldType.AUTHOR, "12");
        fields.put(FieldType.PAGES, "12");
        assertThrows(TooManyFieldsException.class, () -> {
            Inbook conference2 = new Inbook(fields, key);
        });
    }
}