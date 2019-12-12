package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Manual extends Entry {
    protected static EntryType type = EntryType.MANUAL;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();

    public Manual(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.TITLE);

        optionalFields.add(FieldType.AUTHOR);
        optionalFields.add(FieldType.ORGANIZATION);
        optionalFields.add(FieldType.ADDRESS);
        optionalFields.add(FieldType.EDITION);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        super.checkValidity(requiredFields, optionalFields, fields);
    }
}
