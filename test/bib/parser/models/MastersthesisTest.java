package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MastersthesisTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "a");
        fields.put(FieldType.SCHOOL, "a");
        fields.put(FieldType.YEAR, "a");

        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Mastersthesis manual = new Mastersthesis(fields, key);
        });
        fields.put(FieldType.TITLE, "a");
        Mastersthesis manual = new Mastersthesis(fields, key);

    }
}