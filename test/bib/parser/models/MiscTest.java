package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MiscTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        Misc manual = new Misc(fields, key);
    }
}