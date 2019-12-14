package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ManualTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Manual manual = new Manual(fields, key);
        });
        fields.put(FieldType.TITLE, "a");
        Manual manual = new Manual(fields, key);

    }
}