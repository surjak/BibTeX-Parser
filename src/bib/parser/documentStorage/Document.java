package bib.parser.documentStorage;

import bib.parser.fields.FieldType;
import bib.parser.models.Article;
import bib.parser.models.Entry;
import bib.parser.models.EntryType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Container of entries
 */
public class Document {
    /**
     * Map of entries
     */
    private Map<String, Entry> entryMap = new LinkedHashMap<>();

    /**
     * @return map of entries
     */
    public Map<String, Entry> getEntryMap() {
        return entryMap;
    }

    /**
     * Add Entry to map
     *
     * @param key key
     * @param entry entry
     */
    public void addEntry(String key, Entry entry) {
        entryMap.put(key, entry);
    }

    /**
     * Method that filter entryMap
     *
     * @param categories List of categories
     */
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

    /**
     * Method that filter entryMap
     *
     * @param authors List of authors
     */
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

    /**
     * Method that call print() on all entries
     */
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
