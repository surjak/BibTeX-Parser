package bib.parser.parser;

import bib.parser.documentStorage.Document;
import bib.parser.exceptions.BracketNotFoundException;
import bib.parser.exceptions.ErrorInMatcherException;
import bib.parser.exceptions.ValueNotInStringMapException;
import bib.parser.fields.FieldType;
import bib.parser.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Class parsing file to object form
 */
public class Parser {


    /**
     * No args constructor
     */
    public Parser() {
    }


    /**
     * Method that parse file
     *
     * @param name path to file
     * @return
     * @throws Exception when file wasn't found
     */
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


    /**
     * Method that parse @String
     *
     * @param scanner scanner
     */
    public void parseStringValue(Scanner scanner)  {

        String string = this.parseInside(scanner);

        String[] strings = string.split(",");
        for (String str : strings) {

            Matcher whiteSpaces = Pattern.compile("\\s+").matcher(str);

            if (whiteSpaces.matches()) continue;
            Matcher attribute = (Pattern.compile("\\s*([a-zA-Z]\\w*)\\s*=\\s*(\\S.*)\\s*")).matcher(str);
            if (!attribute.matches())
                throw new ErrorInMatcherException("error in : "+str);
            String stringName = attribute.group(1);
            String value = parseValue(attribute.group(2));
            StringService.stringMap.put(stringName, value);
        }

    }

    /**
     * Method that parse file inside brackets
     *
     * @param scanner scanner
     * @return string
     */
    public String parseInside(Scanner scanner) {
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

        throw new BracketNotFoundException("closing } not found in " + stringBuilder.toString());
    }

    /**
     * Method that returns entry
     *
     * @param scanner scanner
     * @param model string
     * @return entry
     * @throws Exception
     */
    public Entry parseModel(Scanner scanner, String model) throws Exception {
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
        Class<? extends Entry> classObj = EntryClassService.getClassFromEntryType(entryType);

        Entry entry = classObj.getConstructor(Map.class, String.class).newInstance(fields, key);
        entry.setEntryType(entryType);
        return entry;
    }

    /**
     * Parse list of Strings to map FieldType - String
     *
     * @param strings list of strings
     * @return map of FieldType-String
     */
    public LinkedHashMap<FieldType, String> parseAttribute(List<String> strings) {
        LinkedHashMap<FieldType, String> fieldTypeStringLinkedHashMap = new LinkedHashMap<>();
        strings.forEach(s -> {

            List<String> name_valueList = new ArrayList<>(Arrays.asList(s.split("=")));

            try {

                FieldType fieldType = FieldType.valueOf(name_valueList.get(0).trim().toUpperCase());

                String value = parseValue(name_valueList.get(1).trim());

                fieldTypeStringLinkedHashMap.put(fieldType, value);
            } catch (IllegalArgumentException e) {

            }
        });
        return fieldTypeStringLinkedHashMap;
    }

    /**
     * Method that removes all \{ , \" and \} from string and make string concatenation
     *
     * @param value string
     * @return string
     */
    public String parseValue(String value) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] values = value.split("#");
        for (String s : values) {
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(0);
            boolean isDigit = (c >= '0' && c <= '9');
            int j = 0;
            if (s.trim().charAt(0) != '"' && s.trim().charAt(0) != '{' && !isDigit) {

                String mapValue = StringService.stringMap.get(s.trim());
                if (mapValue == null) {
                    throw new ValueNotInStringMapException("value not in map");
                }
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int i = 0; i < mapValue.length(); i++) {
                    if (mapValue.charAt(i) == '{') continue;
                    if (mapValue.charAt(i) == '}') continue;
                    if (mapValue.charAt(i) == '"') continue;
                    stringBuilder1.append(mapValue.charAt(i));
                }


                stringBuilder.append(stringBuilder1.toString());
                continue;
            }


            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '{') continue;
                if (s.charAt(i) == '}') continue;
                if (s.charAt(i) == '"') continue;
                sb.append(s.charAt(i));
            }
            stringBuilder.append(sb.toString());
        }
        return stringBuilder.toString();

    }

}
