package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhdthesisTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "a");
        fields.put(FieldType.SCHOOL, "a");
        fields.put(FieldType.YEAR, "a");

        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Phdthesis manual = new Phdthesis(fields, key);
        });
        fields.put(FieldType.TITLE, "a");
        Phdthesis manual = new Phdthesis(fields, key);
    }
}