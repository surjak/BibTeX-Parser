package bib.parser.parser;

import java.util.HashMap;
import java.util.Map;

public class StringService {
    public  static Map<String, String> strings(){
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "John");
        return stringMap;
    }


}
