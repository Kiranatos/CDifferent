package net.kiranatos.softserve.jom.s6.t5;

import java.util.function.Predicate;
import java.util.Set;

class MyUtils {
   
   public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> set){
       return s -> {
           for (Predicate<Integer> p : set) {
               if (!p.test(s)) return false;
           }
           return true;
       };
   }
   
}

public class Task5 {

}

/*
Implement a static method getPredicateFromSet(...) in MyUtils class.

The getPredicateFromSet method should take a Set of predicates working with 
integers as a parameter and return a predicate with the functionality of all 
predicates in the set invoked and connected by logical AND.
*/