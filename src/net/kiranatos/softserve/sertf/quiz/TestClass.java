package net.kiranatos.softserve.sertf.quiz;

import java.util.*;
import java.util.stream.Stream;

public class TestClass {

    public static void main(String[] args) {
        Stream<String> names = Stream.of("Sarah Adams", "Suzy Pinnell", "Paul Basgall");
        Stream<String> firstNames = names.map(e -> e.split(" ")[0]);
        //Stream<String> firstNames = names.reduce(e -> e.split(" ")[0]);
        //Stream<String> firstNames = names.filter(e -> e.split(" ")[0]);
        //Stream<String> firstNames = names.forEach(e -> e.split(" ")[0]);
        
        firstNames.forEach(System.out::println);
        
        D d = new D( );
        System.out.println(d instanceof A);

    }
}

class A { }
class B extends A { }
class C extends B { }
class D extends C { }

