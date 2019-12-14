package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Unpublished extends Entry {
    protected static EntryType type = EntryType.UNPUBLISHED;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();
    public Unpublished(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.NOTE);

        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.KEY);
        super.filterFields(requiredFields, optionalFields, fields);

        checkValidity();

    }
    public void checkValidity() {
    }
    public static EntryType getType() {
        return type;
    }
}
