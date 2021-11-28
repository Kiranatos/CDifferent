package net.kiranatos.softserve.jom.s6.t3;

import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
public class App {
    
    public static BinaryOperator<String> greetingOperator = 
            (parameter1, parameter2) -> 
                    "Hello " + parameter1 + " " + parameter2 + "!!!";
    
    public static List<String> createGreetings
        (List<Person> people, BinaryOperator<String> biOp) {
       List<String> list = new ArrayList<>();
        for (Person per : people) {
            list.add(biOp.apply(per.name, per.surname));
        }
       return list;       
    }
}

/*
Suppose, we have the next class Person:
class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }    
}

Add to App class static field greetingOperator of type BinaryOperator . 

The greetingOperator should create a new string as a result by the rule: 
"Hello " + parameter1 + " " + parameter2 + "!!!"

Create a static method createGreetings(...) that takes two parameters: 
List<Person> and BinaryOperator and generates List<String> as a result. 
We should be able to pass greetingOperator as a parameter here.

Please, use the second parameter in creating the result.
*/

class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }    
}