package bib.parser.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Class containing strings
 */
public class StringService {
    /**
     * static map of strings
     */
    public static Map<String, String> stringMap = new HashMap<>(){{
        put("jan", "January");
        put("feb", "February");
        put("mar", "March");
        put("apr", "April");
        put("may", "May");
        put("jun", "June");
        put("jul", "July");
        put("aug", "August");
        put("sep", "September");
        put("oct", "October");
        put("nov", "November");
        put("dec", "December");

    }};
}
