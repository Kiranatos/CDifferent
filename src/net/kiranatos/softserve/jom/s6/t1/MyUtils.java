package net.kiranatos.softserve.jom.s6.t1;

import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {
    public static int getCount(int[] array, Predicate<Integer> lambda) {
        return (int)Arrays.stream(array).boxed().filter(lambda).count();
    }
    
    public static void main(String[] args) {
        System.out.println( MyUtils.getCount(new int[] {1, 2, 3, -1, -5, 0}, i -> i > 2) );
    }
}

/*
Implement a static method getCount(...) that takes an array of integers as the first parameter. 
The second parameter is a functional interface that works with integers and defines a some condition.

The method should return the count of elements in the array that satisfy the condition defined by the second argument.
*/