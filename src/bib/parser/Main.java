package bib.parser;

import bib.parser.documentStorage.Document;
import bib.parser.fields.FieldType;
import bib.parser.inputHandler.InputHandler;
import bib.parser.models.*;
import bib.parser.parser.Parser;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>();

    private static void initMap(){
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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, FileNotFoundException, ClassNotFoundException {
        initMap();
    }

}
