package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class representing structure of entry
 */
public abstract class Entry {

    /**
     * Class fields
     */
    protected Map<FieldType, String> fields;
    protected String key;
    private EntryType entryType;

    /**
     * @param entryType type of entry
     */
    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    /**
     * @return type of entry
     */
    public EntryType getEntryType() {
        return entryType;
    }

    /**
     * Constructor
     *
     * @param fields fields
     * @param key key
     */
    public Entry(Map<FieldType, String> fields, String key) {
        this.fields = fields;
        this.key = key;
    }

    /**
     * @return fields
     */
    public Map<FieldType, String> getFields() {
        return fields;
    }

    /**
     * set fields
     *
     * @param fields fields
     */
    public void setFields(Map<FieldType, String> fields) {
        this.fields = fields;
    }

    /**
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set key
     *
     * @param key key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Method removes all fields that aren't in optional or required fields
     *
     * @param requiredFields required fields
     * @param optionalFields optional fields
     * @param ownFields fields
     */
    public void filterFields(List<FieldType> requiredFields, List<FieldType> optionalFields, Map<FieldType, String> ownFields) {
        List<FieldType> myFields = new ArrayList<>();
        myFields.addAll(requiredFields);
        myFields.addAll(optionalFields);
        fields = myFields.stream()
                .filter(ownFields::containsKey)
                .collect(Collectors.toMap(Function.identity(), ownFields::get, (s, s2) -> {
                    return s;
                },LinkedHashMap::new ));
    }

    /**
     * Method that prints single entry
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("_");
        }
        sb.append("\n");
        for (int i = 0; i < 100; i++) {
            sb.append("-");
        }
        sb.append("\n");
        String recordData = "| " + entryType + "   " + key;
        sb.append(recordData);
        for (int i = recordData.length(); i < 99; i++) {
            sb.append(" ");
        }
        sb.append("|");
        sb.append("\n");
        for (int i = 0; i < 100; i++) {
            sb.append("-");
        }
        sb.append("\n");

        fields.forEach((fieldType, s) -> {
            sb.append(printOneAttribute(fieldType, s));
            sb.append("\n");
        });
        sb.append("\n\n");
        System.out.println(sb.toString());
    }

    /**
     * Method that formats one attribute
     *
     * @param fieldType type of field
     * @param s string
     * @return formatted string
     */
    private String printOneAttribute(FieldType fieldType, String s) {
        String name = "| " + fieldType;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (int i = name.length(); i < 20; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("|");
        stringBuilder.append("  ");
        if (fieldType == FieldType.AUTHOR || fieldType == FieldType.EDITOR) {
            String[] authors = s.split("and");
            for (String author : authors) {
                stringBuilder.append("* ");
                stringBuilder.append(author.trim());
                if (author.length() < 74) {
                    for (int i = author.trim().length(); i < 74; i++) {
                        stringBuilder.append(" ");
                    }
                }
                stringBuilder.append("|");
                stringBuilder.append("\n");
                for (int i = 0; i < 20; i++) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append("|  ");
            }
            stringBuilder.delete(stringBuilder.length() - 24, stringBuilder.length());
            stringBuilder.append("\n");
            for (int i = 0; i < 100; i++) {
                stringBuilder.append("-");
            }
            return stringBuilder.toString();
        }
        List<String> strings = divideString(s);
        strings.forEach(o -> {

            stringBuilder.append(o);
            if (o.length() < 76) {
                for (int i = o.length(); i < 76; i++) {
                    stringBuilder.append(" ");

                }
            }
            stringBuilder.append("|");
            stringBuilder.append("\n");
            for (int i = 0; i < 20; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("|  ");
        });


        stringBuilder.delete(stringBuilder.length() - 24, stringBuilder.length());
        stringBuilder.append("\n");
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    /**
     * Returns list of divided strings
     *
     * @param s string
     * @return list of strings divided into parts
     */
    public List<String> divideString(String s) {
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        divide(stringBuilder, strings);
        return strings;
    }

    /**
     * Method that help dividing strings
     *
     * @param stringBuilder string builder
     * @param strings list of strings
     */
    public void divide(StringBuilder stringBuilder, List<String> strings) {
        if (stringBuilder.length() < 74) {
            strings.add(stringBuilder.toString());
            return;
        }
        strings.add(stringBuilder.substring(0, 74));
        divide(stringBuilder.delete(0, 74), strings);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(fields, entry.fields) &&
                Objects.equals(key, entry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, key);
    }
}
