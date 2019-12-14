package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {
Article article;
String key = "key";
    Map<FieldType, String> fields;
    @Test
    void checkValidity() {
        fields = new HashMap<>();
        fields.put(FieldType.AUTHOR, "a");
        fields.put(FieldType.YEAR, "a");
        fields.put(FieldType.JOURNAL, "a");
        fields.put(FieldType.PUBLISHER, "a");
        assertThrows(RequiredFieldNotInEntry.class, ()->{
            article = new Article(fields,key);
        });
        fields.put(FieldType.TITLE, "a");
        article = new Article(fields,key);
    }
}