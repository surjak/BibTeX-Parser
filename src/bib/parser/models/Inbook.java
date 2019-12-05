package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.MultipleFieldTypeImpl;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inbook extends Entry {
    protected static EntryType type = EntryType.INBOOK;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Inbook(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.put(FieldType.AUTHOR, new MultipleFieldTypeImpl(FieldType.AUTHOR, FieldType.EDITOR));
        requiredFields.put(FieldType.EDITOR, new MultipleFieldTypeImpl(FieldType.EDITOR, FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.CHAPTER, new MultipleFieldTypeImpl(FieldType.CHAPTER, FieldType.PAGES));
        requiredFields.put(FieldType.PAGES, new MultipleFieldTypeImpl(FieldType.PAGES, FieldType.CHAPTER));
        requiredFields.put(FieldType.PUBLISHER, new SingleFieldTypeImpl(FieldType.PUBLISHER));
        requiredFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));

        optionalFields.put(FieldType.VOLUME, new MultipleFieldTypeImpl(FieldType.VOLUME, FieldType.NUMBER));
        optionalFields.put(FieldType.NUMBER, new MultipleFieldTypeImpl(FieldType.NUMBER, FieldType.VOLUME));
        optionalFields.put(FieldType.SERIES, new SingleFieldTypeImpl(FieldType.SERIES));
        optionalFields.put(FieldType.TYPE, new SingleFieldTypeImpl(FieldType.TYPE));
        optionalFields.put(FieldType.ADDRESS, new SingleFieldTypeImpl(FieldType.ADDRESS));
        optionalFields.put(FieldType.EDITION, new SingleFieldTypeImpl(FieldType.EDITION));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
    }

    public static EntryType getType() {
        return type;
    }
}
