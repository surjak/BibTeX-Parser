package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Misc extends Entry {
    protected static EntryType type = EntryType.MISC;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();

    public Misc(Map<FieldType, String> fields, String key) {
        super(fields, key);
        optionalFields.add(FieldType.AUTHOR);
        optionalFields.add(FieldType.TITLE);
        optionalFields.add(FieldType.HOWPUBLISHED);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        super.checkValidity(requiredFields, optionalFields, fields);
    }

    public static EntryType getType() {
        return type;
    }
}
