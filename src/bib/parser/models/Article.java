package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.SingleFieldTypeImpl;
import bib.parser.fields.IFieldType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Article extends Entry {

    protected static EntryType type = EntryType.ARTICLE;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Article(Map<FieldType, String> fields, String key) {
        super(fields, key);

        requiredFields.put(FieldType.AUTHOR, new SingleFieldTypeImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new SingleFieldTypeImpl(FieldType.TITLE));
        requiredFields.put(FieldType.JOURNAL, new SingleFieldTypeImpl(FieldType.JOURNAL));
        requiredFields.put(FieldType.YEAR, new SingleFieldTypeImpl(FieldType.YEAR));

        optionalFields.put(FieldType.VOLUME, new SingleFieldTypeImpl(FieldType.VOLUME));
        optionalFields.put(FieldType.NUMBER, new SingleFieldTypeImpl(FieldType.NUMBER));
        optionalFields.put(FieldType.PAGES, new SingleFieldTypeImpl(FieldType.PAGES));
        optionalFields.put(FieldType.MONTH, new SingleFieldTypeImpl(FieldType.MONTH));
        optionalFields.put(FieldType.NOTE, new SingleFieldTypeImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new SingleFieldTypeImpl(FieldType.KEY));

        super.checkValidity(requiredFields, optionalFields, fields);
    }

    public static EntryType getType() {
        return type;
    }
}
