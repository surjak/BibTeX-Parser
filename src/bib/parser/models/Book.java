package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.exceptions.TooManyFieldsException;
import bib.parser.fields.FieldType;

import java.util.*;

/**
 * Class representing structure of book
 */
public class Book extends Entry {
    /**
     * Class fields
     */
    protected static EntryType type = EntryType.BOOK;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();

    /**
     * Constructor
     *
     * @param fields fields
     * @param key key
     */
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
        optionalFields.add(FieldType.ADDRESS);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        optionalFields.add(FieldType.MONTH);

        ArrayList<FieldType> li1 = new ArrayList<>() {{
            add(FieldType.AUTHOR);
            add(FieldType.EDITOR);
        }};
        listOLists.add(li1);
        super.filterFields(requiredFields, optionalFields, fields);

        checkValidity();

    }

    /**
     * Checks if all required fields were given and if fields aren't colliding
     */
    public void checkValidity() {
        listOLists.forEach(fieldTypes -> {
            int count = (int) fieldTypes.stream().map(fieldType -> fields.get(fieldType)).filter(Objects::nonNull).count();
            if (count == 0) {
                throw new RequiredFieldNotInEntry(type.toString());
            }
            if (count != 1) {
                throw new TooManyFieldsException("Too many fields in " + type);
            }
        });
        listOLists.forEach(fieldTypes -> {
            fieldTypes.forEach(fieldType -> requiredFields.remove(fieldType));
        });
        requiredFields.forEach(fieldType -> {
            String value = fields.get(fieldType);
            if (value == null) {
                throw new RequiredFieldNotInEntry(fieldType + "not in " + type);
            }
        });
    }
    /**
     * @return type of entry
     */
    public static EntryType getType() {
        return type;
    }
}
