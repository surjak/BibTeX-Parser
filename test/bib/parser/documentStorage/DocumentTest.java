package bib.parser.documentStorage;

import bib.parser.fields.FieldType;
import bib.parser.models.Article;
import bib.parser.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {
    Document document;
    Map<FieldType, String> fields = new HashMap<>();

    @BeforeEach
    void setUp() {
        String key = "ala";
        fields.put(FieldType.AUTHOR, "At1 and At2 Kowalski");
        fields.put(FieldType.JOURNAL, "Kowslaki");
        fields.put(FieldType.YEAR, "123");
        fields.put(FieldType.TITLE, "Potop");
        fields.put(FieldType.PAGES, "800");
        document = new Document();
        document.addEntry("ala", new Article(fields, key));
    }

    @Test
    void getEntryMap() {
        Map<FieldType, String> fields2 = new HashMap<>();
        fields2.put(FieldType.AUTHOR, "At1 and At2 Kowalski");
        fields2.put(FieldType.JOURNAL, "Kowslaki");
        fields2.put(FieldType.YEAR, "123");
        fields2.put(FieldType.TITLE, "Potop");
        fields2.put(FieldType.PAGES, "800");
        assertEquals(fields, fields2);
    }

    @Test
    void addEntry() {
        fields.put(FieldType.PUBLISHER, "aa");
        document.addEntry("key2", new Book(fields, "key2"));
        assertEquals(document.getEntryMap().size(), 2);
    }

    @Test
    void findByCategories() {

        fields.put(FieldType.PUBLISHER, "aa");
        document.addEntry("key2", new Book(fields, "key2"));
        List<String> list = new ArrayList<>();
        list.add("booklet");
        document.findByCategories(list);
        assertEquals(document.getEntryMap().size(),0);
    }

    @Test
    void findByAuthor() {
        List<String> list = new ArrayList<>();
        list.add("Nowak");
        document.findByAuthor(list);
        assertEquals(document.getEntryMap().size(),0);
    }
}