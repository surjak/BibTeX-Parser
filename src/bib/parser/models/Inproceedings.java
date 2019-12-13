package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Inproceedings extends Entry {
    protected static EntryType type = EntryType.INPROCEEDINGS;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();
    public Inproceedings(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.BOOKTITLE);
        requiredFields.add(FieldType.YEAR);

        optionalFields.add(FieldType.EDITOR);
        optionalFields.add(FieldType.VOLUME);
        optionalFields.add(FieldType.NUMBER);
        optionalFields.add(FieldType.SERIES);
        optionalFields.add(FieldType.PAGES);
        optionalFields.add(FieldType.ADDRESS);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.ORGANIZATION);
        optionalFields.add(FieldType.PUBLISHER);
        optionalFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        ArrayList<FieldType> li1 = new ArrayList<>() {{
            add(FieldType.VOLUME);
            add(FieldType.NUMBER);
        }};
        listOLists.add(li1);
        checkValidity();

    }
    public void checkValidity() {
        // TODO: 13.12.2019
    }
    public static EntryType getType() {
        return type;
    }
}
