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

    public void findByAuthor(String author){

       ArrayList<Entry> list = (ArrayList<Entry>) entryMap.values().stream().filter(entry -> {

           String value = entry.getFields().get(FieldType.AUTHOR);


           String[] splitedValue = value.split("and");
           for (String val : splitedValue){
               if (val.trim().equals(author)) return true;
           }

           return false;
       }).collect(Collectors.toList());
        list.forEach(li -> System.out.println(li.getFields().get(FieldType.AUTHOR)));
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
