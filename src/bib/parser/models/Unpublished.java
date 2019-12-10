package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Unpublished extends Entry {
    protected static EntryType type = EntryType.UNPUBLISHED;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Unpublished(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));

        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
        super.checkValidity(requiredFields, optionalFields, fields);
    }

    public static EntryType getType() {
        return type;
    }
}
