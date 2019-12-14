package bib.parser.models;

import bib.parser.exceptions.RequiredFieldNotInEntry;
import bib.parser.fields.FieldType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class representing structure of masterthesis
 */
public class Mastersthesis extends Entry {
    /**
     * Class fields
     */
    protected static EntryType type = EntryType.MASTERSTHESIS;
    protected List<FieldType> requiredFields = new LinkedList<>();
    protected List<FieldType> optionalFields = new LinkedList<>();
    private ArrayList<ArrayList<FieldType>> listOLists = new ArrayList<ArrayList<FieldType>>();
    /**
     * Constructor
     *
     * @param fields fields
     * @param key key
     */
    public Mastersthesis(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.add(FieldType.AUTHOR);
        requiredFields.add(FieldType.TITLE);
        requiredFields.add(FieldType.SCHOOL);
        requiredFields.add(FieldType.YEAR);

        optionalFields.add(FieldType.TYPE);
        optionalFields.add(FieldType.ADDRESS);
        optionalFields.add(FieldType.MONTH);
        optionalFields.add(FieldType.NOTE);
        optionalFields.add(FieldType.KEY);
        super.filterFields(requiredFields, optionalFields, fields);

        checkValidity();

    }

    /**
     * Checks if all required fields were given and if fields aren't colliding
     */
    public void checkValidity() {
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
