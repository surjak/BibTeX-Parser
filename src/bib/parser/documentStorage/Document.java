package bib.parser.documentStorage;

import bib.parser.fields.FieldType;
import bib.parser.models.Article;
import bib.parser.models.Entry;

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

    // TODO: 11.12.2019  
//    public Map<String, Entry> findByAuthor(String author) {
//        Map<String, Entry> stringEntryMap = new LinkedHashMap<>();
//        entryMap.forEach((s, entry) -> {
//            String value = entry.getFields().get(FieldType.AUTHOR);
//            if (value!=null){
//                String[] splitedValue = value.split("and");
//                for (String val : splitedValue) {
//                    if (val.trim().equals(author)) {
//                        stringEntryMap.put(entry.getKey(), entry);}
//                }
//            }
//
//        });
//
//        return stringEntryMap;
//    }


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
