package bib.parser;


import bib.parser.documentStorage.Document;
import bib.parser.models.*;
import bib.parser.parser.Parser;
import bib.parser.parser.StringService;


import java.util.HashMap;

import java.util.Map;

public class Main {



    public static void main(String[] args) throws Exception {

        Parser parser = new Parser();
        Document document = parser.parse(args[0]);

//        document.findByAuthor("Marek Grechuta").forEach((s, entry) -> {
//            System.out.println("___________________________________");
//            System.out.println(s);
//            entry.getFields().forEach((fieldType, s1) -> {
//                System.out.println(fieldType + " ------ " + s1);
//            });
//            System.out.println("____________________________________");
//        });



//        document.getEntryMap().forEach((s, entry) -> {
//            System.out.println("___________________________________");
//            System.out.println(entry.getEntryType());
//            System.out.println(s);
//            entry.getFields().forEach((fieldType, s1) -> {
//                System.out.println(fieldType + " ------ " + s1);
//            });
//            System.out.println("____________________________________");
//        });

        document.print();
    }

}
