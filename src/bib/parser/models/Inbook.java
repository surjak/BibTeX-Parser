package bib.parser.models;

import bib.parser.fields.FieldType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Inbook extends Entry {
    protected static EntryType type = EntryType.INBOOK;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();
    public Inbook(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.EDITOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.CHAPTER);
        requiredFields.add(FieldType.PAGES);
        requiredFields.add(FieldType.PUBLISHER);
        requiredFields.add(FieldType.YEAR);

        optionalFields.add(FieldType.VOLUME);
        optionalFields.add(FieldType.NUMBER);
        optionalFields.add(FieldType.SERIES);
        optionalFields.add(FieldType.TYPE);
        optionalFields.add(FieldType.ADDRESS);
        optionalFields.add(FieldType.EDITION);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.YEAR);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        ArrayList<FieldType> li1 = new ArrayList<>() {{
            add(FieldType.AUTHOR);
            add(FieldType.EDITOR);
        }};
        listOLists.add(li1);
        ArrayList<FieldType> li2 = new ArrayList<>() {{
            add(FieldType.CHAPTER);
            add(FieldType.PAGES);
        }};
        listOLists.add(li2);
        ArrayList<FieldType> li3 = new ArrayList<>() {{
            add(FieldType.VOLUME);
            add(FieldType.NUMBER);
        }};
        listOLists.add(li3);
        checkValidity();

    }
    public void checkValidity() {
        // TODO: 13.12.2019
    }
    public static EntryType getType() {
        return type;
    }
}
