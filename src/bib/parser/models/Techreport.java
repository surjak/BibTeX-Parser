package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Techreport extends Entry {
    protected static EntryType type = EntryType.TECHREPORT;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Techreport(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.INSTITUTION, new SingleFieldTypeImpl(FieldType.INSTITUTION));
        requiredFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));

        optionalFields.put(FieldType.TYPE, new SingleFieldTypeImpl(FieldType.TYPE));
        optionalFields.put(FieldType.ADDRESS, new SingleFieldTypeImpl(FieldType.ADDRESS));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
    }

    public static EntryType getType() {
        return type;
    }
}
