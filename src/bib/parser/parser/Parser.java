package bib.parser.parser;

import bib.parser.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private  Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>();
    public int lineNumber = 0;
    public Parser() {
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

    public void readFile(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        System.out.println("-----------------------------------------------------------");
        while(scanner.hasNextLine()) {
            lineNumber++;
            System.out.println(scanner.nextLine());

        }
    }
}
