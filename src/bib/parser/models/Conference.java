package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;
import bib.parser.fields.MultipleFieldTypeImpl;
import bib.parser.fields.SingleFieldTypeImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Conference extends Entry{
    protected static EntryType type = EntryType.CONFERENCE;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Conference(Map<FieldType, String> fields, String key) {
        super(fields, key);
        requiredFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.BOOKTITLE, new SingleFieldTypeImpl(FieldType.BOOKTITLE));
        requiredFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));
        optionalFields.put(FieldType.EDITOR, new SingleFieldTypeImpl(FieldType.EDITOR));
        optionalFields.put(FieldType.VOLUME, new MultipleFieldTypeImpl(FieldType.VOLUME, FieldType.NUMBER));
        optionalFields.put(FieldType.NUMBER, new MultipleFieldTypeImpl(FieldType.NUMBER, FieldType.VOLUME));
        optionalFields.put(FieldType.SERIES, new SingleFieldTypeImpl(FieldType.SERIES));
        optionalFields.put(FieldType.PAGES, new SingleFieldTypeImpl(FieldType.PAGES));
        optionalFields.put(FieldType.ADDRESS, new SingleFieldTypeImpl(FieldType.ADDRESS));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.ORGANIZATION, new SingleFieldTypeImpl(FieldType.ORGANIZATION));
        optionalFields.put(FieldType.PUBLISHER, new SingleFieldTypeImpl(FieldType.PUBLISHER));
        optionalFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));
    }

    public static EntryType getType() {
        return type;
    }
}
