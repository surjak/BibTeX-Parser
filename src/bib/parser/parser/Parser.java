package bib.parser.parser;

import bib.parser.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Parser {
    private Map<EntryType, Class<? extends Entry>> entryTypeMap = new HashMap<>();

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


    public void parse(String name) throws Exception {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            if (scanner.findInLine(Pattern.compile("@(\\w+)\\s*\\{")) != null) {
                String model = scanner.match().group(1).toLowerCase();
                if (model.toLowerCase().equals("string")) {
                    parseStringValue(scanner);

                } else {
                    // TODO: 10.12.2019
                }

            }
            scanner.nextLine();

        }
    }


    private void parseStringValue(Scanner scanner) throws Exception {

        String string = this.parseInside(scanner);

        String[] strings = string.split(",");
        for (String str : strings) {

            Matcher whiteSpaces = Pattern.compile("\\s+").matcher(str);

            if (whiteSpaces.matches()) continue;
            Matcher record = (Pattern.compile("\\s*([a-zA-Z]\\w*)\\s*=\\s*(\\S.*)\\s*")).matcher(str);
            if (!record.matches())
                throw new Exception("cos poszlo nie tak");
            String stringName = record.group(1);
            String value = record.group(2);
            System.out.println(stringName);
            System.out.println(value);
            StringService.stringMap.put(stringName,value);
        }

    }

    private String parseInside(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        char c = ' ';
        int countOfBrackets = 1;
        while (scanner.hasNext() && countOfBrackets > 0) {
            try {
                c = scanner.findInLine(".").charAt(0);

            } catch (NullPointerException e) {
                stringBuilder.append("\n");
                scanner.nextLine();
                continue;
            }
            if (c == '{') countOfBrackets++;
            else if (c == '}') countOfBrackets--;
            if (countOfBrackets > 0) {
                stringBuilder.append(c);
            }
            if (countOfBrackets == 0) {
                return stringBuilder.toString();
            }


        }

        return stringBuilder.toString();
    }


}
