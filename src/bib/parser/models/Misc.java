package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Misc extends Entry {
    protected static EntryType type = EntryType.MISC;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Misc(Map<FieldType, String> fields, String key) {
        super(fields, key);
        optionalFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        optionalFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        optionalFields.put(FieldType.HOWPUBLISHED, new SingleFieldTypeImpl(FieldType.HOWPUBLISHED));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
        super.checkValidity(requiredFields, optionalFields, fields);
    }

    public static EntryType getType() {
        return type;
    }
}
