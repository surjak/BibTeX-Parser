package bib.parser.parser;

import bib.parser.documentStorage.Document;
import bib.parser.fields.FieldType;
import bib.parser.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Parser {


    public Parser() {
    }


    public Document parse(String name) throws Exception {
        Document document = new Document();
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            if (scanner.findInLine(Pattern.compile("@(\\w+)\\s*\\{")) != null) {
                String model = scanner.match().group(1).toLowerCase();
                if (model.toLowerCase().equals("string")) {
                    parseStringValue(scanner);

                } else {
                    Entry entry = parseModel(scanner, model.toLowerCase());
                    if (entry != null) {
                        document.addEntry(entry.getKey(), entry);
                    }
                }

            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }


        }
        return document;
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
            StringService.stringMap.put(stringName, value);
        }

    }

    private String parseInside(Scanner scanner) throws Exception {
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

        throw new Exception("Parse inside - end }");
    }

    private Entry parseModel(Scanner scanner, String model) throws Exception {
        EntryType entryType;
        try {
            entryType = EntryType.valueOf(model.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
        if (entryType == null) {
            return null;
        }

        String body = parseInside(scanner);
        List<String> strings = new ArrayList<>(Arrays.asList(body.split(",")));

        String key = strings.get(0);
        strings.remove(0);
        LinkedHashMap<FieldType, String> fields;
        fields = parseAttribute(strings);
        Class<? extends Entry> classObject = EntryClassService.getClassFromEntryType(entryType);

        Entry record = classObject.getConstructor(Map.class, String.class).newInstance(fields, key);
        return record;
    }

    private LinkedHashMap<FieldType, String> parseAttribute(List<String> strings) {
        LinkedHashMap<FieldType, String> fieldTypeStringLinkedHashMap = new LinkedHashMap<>();
        strings.forEach(s -> {

            List<String> name_valueList = new ArrayList<>(Arrays.asList(s.split("=")));

            try {

                FieldType fieldType = FieldType.valueOf(name_valueList.get(0).trim().toUpperCase());
                name_valueList.remove(0);
                StringBuilder stringBuilder = new StringBuilder();
                name_valueList.forEach(value -> stringBuilder.append(value));
                fieldTypeStringLinkedHashMap.put(fieldType, stringBuilder.toString());
            } catch (IllegalArgumentException e) {

            }
        });
        return fieldTypeStringLinkedHashMap;
    }


}
