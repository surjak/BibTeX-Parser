package bib.parser.documentStorage;

import bib.parser.models.Entry;

import java.util.*;

public class Document {
    private Map<String, Entry> entryMap = new LinkedHashMap<>();

    public Map<String, Entry> getEntryMap() {
        return entryMap;
    }
    public void addEntry(String key, Entry entry) {
        entryMap.put(key, entry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document that = (Document) o;
        return entryMap.equals(that.entryMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryMap);
    }
}
