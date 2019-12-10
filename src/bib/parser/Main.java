package bib.parser;


import bib.parser.models.*;
import bib.parser.parser.Parser;
import bib.parser.parser.StringService;


import java.util.HashMap;

import java.util.Map;

public class Main {
    private static Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>();

    private static void initMap() {
        entryTypeMap.put(EntryType.ARTICLE, Article.class);
        entryTypeMap.put(EntryType.BOOK, Book.class);
        entryTypeMap.put(EntryType.INPROCEEDINGS, Inproceedings.class);
        entryTypeMap.put(EntryType.CONFERENCE, Conference.class);
        entryTypeMap.put(EntryType.BOOKLET, Booklet.class);
        entryTypeMap.put(EntryType.INBOOK, Inbook.class);
        entryTypeMap.put(EntryType.INCOLLECTION, Incollection.class);
        entryTypeMap.put(EntryType.MANUAL, Manual.class);
        entryTypeMap.put(EntryType.MASTERSTHESIS, Mastersthesis.class);
        entryTypeMap.put(EntryType.PHDTHESIS, Phdthesis.class);
        entryTypeMap.put(EntryType.TECHREPORT, Techreport.class);
        entryTypeMap.put(EntryType.MISC, Misc.class);
        entryTypeMap.put(EntryType.UNPUBLISHED, Unpublished.class);
    }

    public static void main(String[] args) throws Exception {
        initMap();
        Parser parser = new Parser();
        parser.parse(args[0]);
    }

}
