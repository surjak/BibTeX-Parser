package bib.parser.parser;

import bib.parser.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
    private  Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>();
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



    public void parse(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {


           if (scanner.findInLine( Pattern.compile("@(\\w+)\\s*\\{"))!=null){
               String model = scanner.match().group(1).toLowerCase();
               System.out.println(model);
           }
           scanner.nextLine();

        }
    }

}
