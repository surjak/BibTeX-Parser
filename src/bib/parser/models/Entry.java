package bib.parser.models;

import bib.parser.fields.FieldType;
import bib.parser.fields.IFieldType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Entry {
    protected Map<FieldType, String> fields;
    protected String key;

    public Entry(Map<FieldType, String> fields, String key) {
        this.fields = fields;
        this.key = key;
    }

    public Map<FieldType, String> getFields() {
        return fields;
    }

    public void setFields(Map<FieldType, String> fields) {
        this.fields = fields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void checkValidity(Map<FieldType, IFieldType> requiredFields, Map<FieldType, IFieldType> optionalFields, Map<FieldType, String> ownFields){
        // TODO: 10.12.2019
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(fields, entry.fields) &&
                Objects.equals(key, entry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, key);
    }
}
