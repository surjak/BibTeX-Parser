package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TechreportTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "12");
        fields.put(FieldType.INSTITUTION, "12");
        fields.put(FieldType.TITLE, "12");
        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Techreport techreport = new Techreport(fields, key);
        });
        fields.put(FieldType.YEAR, "a");
        Techreport techreport = new Techreport(fields, key);


        fields.put(FieldType.VOLUME, "12");
        fields.put(FieldType.NUMBER, "12");
        assertThrows(TooManyFieldsException.class, () -> {
            Techreport techreport1 = new Techreport(fields, key);
        });
    }
}