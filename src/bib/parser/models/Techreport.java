package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Techreport extends Entry {
    protected static EntryType type = EntryType.TECHREPORT;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();

    public Techreport(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.INSTITUTION);
        requiredFields.add(FieldType.YEAR);

        optionalFields.add(FieldType.TYPE);
        optionalFields.add(FieldType.ADDRESS);
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
