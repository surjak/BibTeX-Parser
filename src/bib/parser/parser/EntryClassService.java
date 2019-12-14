package bib.parser.parser;

import bib.parser.models.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class containing map with Entry classes
 */
public class EntryClassService {
    /**
     * Static map with Classes
     */
    public static Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>() {{
        put(EntryType.ARTICLE, Article.class);
        put(EntryType.BOOK, Book.class);
        put(EntryType.INPROCEEDINGS, Inproceedings.class);
        put(EntryType.CONFERENCE, Conference.class);
        put(EntryType.BOOKLET, Booklet.class);
        put(EntryType.INBOOK, Inbook.class);
        put(EntryType.INCOLLECTION, Incollection.class);
        put(EntryType.MANUAL, Manual.class);
        put(EntryType.MASTERSTHESIS, Mastersthesis.class);
        put(EntryType.PHDTHESIS, Phdthesis.class);
        put(EntryType.TECHREPORT, Techreport.class);
        put(EntryType.MISC, Misc.class);
        put(EntryType.UNPUBLISHED, Unpublished.class);
    }};

    /**
     * @param entryType type of entry
     * @return Class of EntryType
     */
    public static Class<? extends Entry> getClassFromEntryType(EntryType entryType) {
        return entryTypeMap.get(entryType);
    }

}
