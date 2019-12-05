package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.FieldTypeSingletonImpl;
import bib.parser.fields.IFieldType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Article extends Entry {

    protected static EntryType type = EntryType.ARTICLE;
    protected static Map<FieldType, IFieldType> requiredFields = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optionalFields = new LinkedHashMap<>();

    public Article(Map<FieldType, String> fields, String key) {
        super(fields, key);

        requiredFields.put(FieldType.AUTHOR, new FieldTypeSingletonImpl(FieldType.AUTHOR));
        requiredFields.put(FieldType.TITLE, new FieldTypeSingletonImpl(FieldType.TITLE));
        requiredFields.put(FieldType.JOURNAL, new FieldTypeSingletonImpl(FieldType.JOURNAL));
        requiredFields.put(FieldType.YEAR, new FieldTypeSingletonImpl(FieldType.YEAR));

        optionalFields.put(FieldType.VOLUME, new FieldTypeSingletonImpl(FieldType.VOLUME));
        optionalFields.put(FieldType.NUMBER, new FieldTypeSingletonImpl(FieldType.NUMBER));
        optionalFields.put(FieldType.PAGES, new FieldTypeSingletonImpl(FieldType.PAGES));
        optionalFields.put(FieldType.MONTH, new FieldTypeSingletonImpl(FieldType.MONTH));
        optionalFields.put(FieldType.NOTE, new FieldTypeSingletonImpl(FieldType.NOTE));
        optionalFields.put(FieldType.KEY, new FieldTypeSingletonImpl(FieldType.KEY));
    }

    public static EntryType getType() {
        return type;
    }
}
