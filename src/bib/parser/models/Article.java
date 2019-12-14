package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Article extends Entry {

    protected static EntryType type = EntryType.ARTICLE;

    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();


    public Article(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.JOURNAL);
        requiredFields.add(FieldType.YEAR);
        requiredFields.add(FieldType.TITLE);
        optionalFields.add(FieldType.VOLUME);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.NUMBER);
        optionalFields.add(FieldType.PAGES);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);

        super.filterFields(requiredFields, optionalFields, fields);

        checkValidity();
    }

    public void checkValidity() {
        requiredFields.forEach(fieldType -> {
            String value = fields.get(fieldType);
            if (value == null) {
                throw new RequiredFieldNotInEntry(fieldType + "not in " + type);
            }
        });
    }

    public static EntryType getType() {
        return type;
    }
}
