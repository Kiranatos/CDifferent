package net.kiranatos.softserve.jom.s7.t5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public static void main(String[] args) {
 Map<String, Stream<String>> map = new HashMap<>();
        map.put("Desktop", Stream.of(" iVan", "PeTro ", " Ira "));
        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
        map.put("Spring", Stream.of("Ivan", "Anna"));
//        map.put("Desktop", null);

        MyUtils myUtils = new MyUtils();
        myUtils.nameList(map).forEach(System.out::println);
    }
    
   public Stream<String> nameList(Map<String, Stream<String>> map) {
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Stream<String>> entry : map.entrySet()){
            if (entry.getValue() != null) result.addAll(entry.getValue().collect(Collectors.toList()));
        }

        return result.stream()
                .filter(el -> el != null && !el.trim().isEmpty() && !el.equals(""))
                .map(str -> str.replaceAll(" ", ""))
                .map(String::toLowerCase)
                .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                .distinct()
                .sorted();
    }
}

/*
Let the key of Map is project name and value contains list of participants.
Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class
to build sorted stream of all participants without duplication.
Please ignore null or empty strings, extra spaces and case sensitivity.
Throw NullPointerException if map is null.

For example, for a given map
{"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
you should get
["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
*/