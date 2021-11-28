package net.kiranatos.javarush.q3threads.lvl1;

import java.util.HashSet;
import java.util.Set;

/* Java Multithreading level 1, lection 5, task 1

Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с 
правилами реализации этих методов.
Метод main не участвует в тестировании.

Old variant: package com.javarush.test.level21.lesson05.task01; */

public class ThreadsL1L05T1 {
    
    static class Solution {
        private final String first, last;
        
        public Solution(String first, String last) {
            this.first = first;
            this.last = last;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Solution solution = (Solution) o;
            
            if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
            return !(last != null ? !last.equals(solution.last) : solution.last != null);
        }
        
        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (last != null ? last.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
