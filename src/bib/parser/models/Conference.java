package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;

import java.util.*;

public class Conference extends Entry {
    protected static EntryType type = EntryType.CONFERENCE;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();

    public Conference(Map<FieldType, String> fields, String key) {
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
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        ArrayList<FieldType> li1 = new ArrayList<>() {{
            add(FieldType.VOLUME);
            add(FieldType.NUMBER);
        }};
        listOLists.add(li1);
        super.filterFields(requiredFields, optionalFields, fields);

        checkValidity();

    }

    public void checkValidity() {
        listOLists.forEach(fieldTypes -> {
            int count = (int) fieldTypes.stream().map(fieldType -> fields.get(fieldType)).filter(Objects::nonNull).count();
            if (count >= 2) {
                throw new TooManyFieldsException(" in " + type);
            }
        });
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
