package bib.parser.parser;

import bib.parser.fields.FieldType;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    Parser parser = new Parser();
    @Test
    void parse() throws Exception {

        assertThrows(FileNotFoundException.class, ()->{
            parser.parse("gdzies");
        });

    }

    @Test
    void parseAttribute() {
        List<String> strings = new ArrayList<>();
        LinkedHashMap<FieldType, String> stringLinkedHashMap = new LinkedHashMap<>();
        strings.add("author = \"jan kowalski\"");
        stringLinkedHashMap.put(FieldType.AUTHOR, "jan kowalski");
        assertEquals(parser.parseAttribute(strings), stringLinkedHashMap);
    }

    @Test
    void parseValue() {
        String value = "\"ala ma { kota }\" # nov ";
        assertEquals(parser.parseValue(value), "ala ma  kota  November");
    }
}