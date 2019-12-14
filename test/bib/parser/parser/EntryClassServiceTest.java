package bib.parser.parser;

import bib.parser.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryClassServiceTest {

    @Test
    void getClassFromEntryType() {
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.ARTICLE), Article.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.BOOK), Book.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.BOOKLET), Booklet.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.CONFERENCE), Conference.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.INBOOK), Inbook.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.INCOLLECTION), Incollection.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.INPROCEEDINGS), Inproceedings.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.MANUAL), Manual.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.MASTERSTHESIS), Mastersthesis.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.MISC), Misc.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.PHDTHESIS), Phdthesis.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.TECHREPORT), Techreport.class);
        assertEquals(EntryClassService.getClassFromEntryType(EntryType.UNPUBLISHED), Unpublished.class);
    }
}