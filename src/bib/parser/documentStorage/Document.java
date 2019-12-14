package bib.parser.documentStorage;

import bib.parser.fields.FieldType;
import bib.parser.models.Article;
import bib.parser.models.Entry;
import bib.parser.models.EntryType;

import java.util.*;
import java.util.stream.Collectors;

public class Document {
    private Map<String, Entry> entryMap = new LinkedHashMap<>();

    public Map<String, Entry> getEntryMap() {
        return entryMap;
    }

    public void addEntry(String key, Entry entry) {
        entryMap.put(key, entry);
    }

    public void findByCategories(List<String> categories) {
        List<EntryType> entryTypes = new ArrayList<>();
        categories.forEach(s -> {
            String cat = s.trim().toUpperCase();
            try {
                entryTypes.add(EntryType.valueOf(cat));
            } catch (IllegalArgumentException e) {
            }
        });
        Map<String, Entry> newEntryMap = new LinkedHashMap<>();
        entryMap.forEach((s, entry) -> {
            if (entryTypes.contains(entry.getEntryType())) {
                newEntryMap.put(s, entry);
            }
        });
        entryMap = newEntryMap;
    }

    public void findByAuthor(List<String> authors) {

        Map<String, Entry> authorEntryMap = new LinkedHashMap<>();
        entryMap.forEach((s, entry) -> {
            String value = entry.getFields().get(FieldType.AUTHOR);
            if (value != null) {
                String[] splitedValue = value.split("and");
                for (String val : splitedValue) {
                    if (authors.contains(val.toUpperCase().trim())) {
                        authorEntryMap.put(s, entry);
                    }
                }
            }
        });
        entryMap = authorEntryMap;
    }

    public void print() {
        entryMap.forEach((s, entry) -> entry.print());
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
