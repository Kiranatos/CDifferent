package net.kiranatos.softserve.jom.s6.t6;

import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(1);
        list1.add(13);
        list1.add(5);
        list1.add(-10);
        int max = MyUtils.findMaxByCondition(list1, x -> x % 2 == 0);
        System.out.println(max);
    }
}

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        return numbers
                .stream()
                .filter(pr)
                .max(Comparator.naturalOrder())
                .get();	     
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();       
    int getFilterdValue(BiFunction<List<Integer>,Predicate<Integer>,Integer> bif, Predicate<Integer> pr) {        
        return bif.apply(values, pr);     
    }
    
    int getMaxValueByCondition(Predicate<Integer> predicate) {         
        return getFilterdValue((List<Integer> a, Predicate<Integer> b) -> MyUtils.findMaxByCondition(a, b), 
                predicate);
    }
}

/*
Implement a static method findMaxByCondition(...) of MyUtils class that takes 
List of integers as a first parameter and predicate as a second and returns the 
max value from the list that satisfies the condition of the predicate.

Also, implement getFilterdValue(...) method of User class. 
The getFilteredValue(...) method should be able to take MyUtils.findMaxByCondition(...) 
as a first parameter and Predicate as a second. This method should return 
an integer value, evaluated from User's field values using the first and second 
parameters of getFilterdValue(...) method.

One more method that needs to be implemented in User class is getMaxValueByCondition(...). 
This method has one Predicate parameter. The implementation should call 
getFilterdValue(...) method with MyUtils.findMaxByCondition(...) as a first 
parameter and passed along Predicate as a second.
*/
