package net.kiranatos.softserve.jom.s7.t7;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://github.com/bodyk59/java-online-marathon-2/blob/b83cbcac4fb746055c9485617ab410755938e409/sprint09/task07.java

public class MyUtils {
   public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        List<Integer> list = stream.collect(Collectors.toList());
        return list.stream()
                .distinct()
                .filter(Objects::nonNull)
                .filter(i -> Collections.frequency(list, i) > 1)
                .sorted()
                .collect(Collectors.toList())
                .stream();
    }
}

/*
Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of 
the MyUtils class to return a sorted stream of duplicated elements of the input stream.
For example, for a given elements
[3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
you should get
[1, 2, 3]
*/