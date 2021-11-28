package net.kiranatos.softserve.jom.s7.t6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://github.com/bodyk59/java-online-marathon-2/blob/b83cbcac4fb746055c9485617ab410755938e409/sprint09/task06.java
// https://github.com/bbogdasha/java-online-marathon
public class MyUtils {
    public static void main(String[] args) {
        List<Stream<String>> list = new ArrayList<>();
        list.add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
        list.add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
        list.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));
        list.add(Stream.of("", "", ""));
        list.add(Stream.of("(093)-11-22-788"));
        list.add(Stream.of(""));
        //list.add(null);

        MyUtils myUtils = new MyUtils();
        String result = myUtils.phoneNumbers(list).entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue().collect(Collectors.joining(", ")))
                .collect(Collectors.joining(",\n"));
        System.out.println(result);
    }

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if (list == null) {
            throw new NullPointerException("Invalid parameters");
        }

        return list.stream()
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .map(s -> s.replaceAll("\\W", ""))
                .filter(s -> !s.isEmpty())
                .map(s -> s.length() == 7 ? "loc".concat(s) : s.length() == 5 ? "err".concat(s) : s)
                .distinct()
                .sorted()
                .collect(Collectors.toMap(s -> s.substring(0, 3), 
                        s -> Stream.of(s.substring(3)),
                        Stream::concat));
        
//        return list.stream()
//                .flatMap(s -> s)
//                .filter(s -> (s != null) && (!s.isEmpty()))
//                .map(s -> s.replaceAll("[^\\d]", ""))
//                .map(s -> s.length() == 7 ? "loc".concat(s) : s.length() < 7 ? "err".concat(s) : s)
//                .distinct()
//                .collect(Collectors.groupingBy(s -> s.substring(0, 3)))
//                .entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        e -> e.getValue().stream().map(s -> s.substring(3))
//                                .sorted()));

        //Second Solution
//        return list.stream()
//                .flatMap(s -> s)
//                .filter(s -> (s != null) && (!s.isEmpty()))
//                .map(s -> s.replaceAll("[^\\d]", ""))
//                .map(s -> s.length() == 7 ? "loc" .concat(s) : s.length() < 7 ? "err" .concat(s) : s)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toMap(
//                        s -> s.substring(0, 3),
//                        s -> Stream.of(s.substring(3)),
//                        Stream::concat));
    }

}

/*
Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) 
method of the MyUtils class to build a Map of all phone numbers.

The key of Map is code of network and value contains sorted list of phones.
Remove all spaces, brakets and dashes from phone numbers.

For example, for a given
[["093 987 65 43", "(050)1234567", "12-345"], 
["067-21-436-57", "050-2345678", "0939182736", "224-19-28"], 
["(093)-11-22-334", "044 435-62-18", "721-73-45"]]

you should get
{"050"=["1234567", "2345678"], 
"067"=["2143657"], 
"093"=["1122334", "9182736", "9876543"], 
"044"=["4356218"], 
"loc"=["2241928", "7217345"], 
"err"=["12345"]}
*/
