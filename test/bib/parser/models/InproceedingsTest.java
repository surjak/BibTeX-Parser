package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InproceedingsTest {

    @Test
    void checkValidity() {
        String key = "key";
        Map<FieldType, String> fields = new HashMap<>();
        fields.put(FieldType.YEAR, "12");
        fields.put(FieldType.AUTHOR, "12");
        fields.put(FieldType.TITLE, "12");


        assertThrows(RequiredFieldNotInEntry.class, () -> {
            Inproceedings inproceedings = new Inproceedings(fields, key);
        });
        fields.put(FieldType.BOOKTITLE, "a");
        Inproceedings inproceedings = new Inproceedings(fields, key);
        fields.put(FieldType.VOLUME, "12");
        fields.put(FieldType.NUMBER, "12");
        assertThrows(TooManyFieldsException.class, () -> {
            Inproceedings inproceedings1 = new Inproceedings(fields, key);
        });
    }

}