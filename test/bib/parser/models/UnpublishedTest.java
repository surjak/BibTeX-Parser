package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UnpublishedTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "12");
        fields.put(FieldType.TITLE, "12");
        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Unpublished unpublished = new Unpublished(fields, key);
        });
        fields.put(FieldType.NOTE, "a");
        Unpublished unpublished = new Unpublished(fields, key);

    }
}