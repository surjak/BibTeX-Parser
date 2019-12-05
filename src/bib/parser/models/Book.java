package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.FieldTypeSelectionImpl;
import bib.parser.fields.FieldTypeSingletonImpl;
import bib.parser.fields.IFieldType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Book extends Entry {
    protected static EntryType type = EntryType.BOOK;
    protected static Map<FieldType, IFieldType> required = new LinkedHashMap<>();
    protected static Map<FieldType, IFieldType> optional = new LinkedHashMap<>();

    public Book(Map<FieldType, String> fields, String key) {
        super(fields, key);
        required.put(FieldType.AUTHOR, new FieldTypeSelectionImpl(FieldType.AUTHOR, FieldType.EDITOR));
        required.put(FieldType.EDITOR,new FieldTypeSelectionImpl(FieldType.EDITOR, FieldType.AUTHOR));
        required.put(FieldType.TITLE,new FieldTypeSingletonImpl(FieldType.TITLE));
        required.put(FieldType.PUBLISHER,new FieldTypeSingletonImpl(FieldType.PUBLISHER));
        required.put(FieldType.YEAR,new FieldTypeSingletonImpl(FieldType.YEAR));

        optional.put(FieldType.VOLUME,new FieldTypeSingletonImpl(FieldType.VOLUME));
        optional.put(FieldType.SERIES,new FieldTypeSingletonImpl(FieldType.SERIES));
        optional.put(FieldType.EDITION,new FieldTypeSingletonImpl(FieldType.EDITION));
        optional.put(FieldType.MONTH,new FieldTypeSingletonImpl(FieldType.MONTH));
        optional.put(FieldType.NOTE,new FieldTypeSingletonImpl(FieldType.NOTE));
        optional.put(FieldType.KEY,new FieldTypeSingletonImpl(FieldType.KEY));
    }

    public static EntryType getType() {
        return type;
    }
}
