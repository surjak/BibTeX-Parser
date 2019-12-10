package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.MultipleFieldTypeImpl;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Incollection extends Entry {
    protected static EntryType type = EntryType.INCOLLECTION;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Incollection(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.BOOKTITLE, new SingleFieldTypeImpl(FieldType.BOOKTITLE));
        requiredFields.put(FieldType.PUBLISHER, new SingleFieldTypeImpl(FieldType.PUBLISHER));
        requiredFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));

        optionalFields.put(FieldType.EDITOR, new SingleFieldTypeImpl(FieldType.EDITOR));
        optionalFields.put(FieldType.VOLUME, new MultipleFieldTypeImpl(FieldType.VOLUME, FieldType.NUMBER));
        optionalFields.put(FieldType.NUMBER, new MultipleFieldTypeImpl(FieldType.NUMBER, FieldType.VOLUME));
        optionalFields.put(FieldType.SERIES, new SingleFieldTypeImpl(FieldType.SERIES));
        optionalFields.put(FieldType.TYPE, new SingleFieldTypeImpl(FieldType.TYPE));
        optionalFields.put(FieldType.CHAPTER, new SingleFieldTypeImpl(FieldType.CHAPTER));
        optionalFields.put(FieldType.PAGES, new SingleFieldTypeImpl(FieldType.PAGES));
        optionalFields.put(FieldType.ADDRESS, new SingleFieldTypeImpl(FieldType.ADDRESS));
        optionalFields.put(FieldType.EDITION, new SingleFieldTypeImpl(FieldType.EDITION));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
        super.checkValidity(requiredFields, optionalFields, fields);
    }

    public static EntryType getType() {
        return type;
    }
}
