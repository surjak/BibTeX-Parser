package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;
    Map<FieldType, String> fields;
    String key = "key1";

    @Test
    void checkValidity() {
        fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "a");

        fields.put(FieldType.TITLE, "a");
        fields.put(FieldType.PUBLISHER, "a");
        assertThrows(RequiredFieldNotInEntry.class, ()->{
            book = new Book(fields,key);
        });
        fields.put(FieldType.EDITOR, "a");
        assertThrows(TooManyFieldsException.class, ()->{
                book = new Book(fields,key);
        });

    }
}