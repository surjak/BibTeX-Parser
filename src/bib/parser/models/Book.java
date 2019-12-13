package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Book extends Entry {
    protected static EntryType type = EntryType.BOOK;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();

    public Book(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.EDITOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.PUBLISHER);
        requiredFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.VOLUME);
        optionalFields.add(FieldType.SERIES);
        optionalFields.add(FieldType.EDITION);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        checkValidity();

    }
    public void checkValidity() {
        // TODO: 13.12.2019
    }
    public static EntryType getType() {
        return type;
    }
}
