package bib.parser.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {
    @Test
    void getMonth() {
    assertEquals(StringService.stringMap.get("nov"), "November");
    }

    @Test
    void getValue(){
        StringService.stringMap.put("key", "value");
        assertEquals(StringService.stringMap.get("key"), "value");
    }
}