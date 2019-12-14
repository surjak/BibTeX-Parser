package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {

    @Test
    void checkValidity() {

        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.YEAR, "12");
        fields.put(FieldType.BOOKTITLE, "12");
        fields.put(FieldType.TITLE, "12");
        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Conference conference = new Conference(fields, key);
        });
        fields.put(FieldType.EDITOR, "a");

        fields.put(FieldType.AUTHOR, "12");

        fields.put(FieldType.VOLUME, "12");
        fields.put(FieldType.NUMBER, "12");
        assertThrows(TooManyFieldsException.class, () -> {
            Conference conference = new Conference(fields, key);
        });

    }
}