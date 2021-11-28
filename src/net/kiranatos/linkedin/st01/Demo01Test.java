package net.kiranatos.linkedin.st01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo01Test {
    public static void main(String[] args) {        
        System.out.println("What is the output of this code?");
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);
        /*
        2true
        3true [CORRECT]
        3false
        A runtime exception is thrown
        */
        System.out.println("*************************************");
        
        System.out.println("What is the output of this code?");
        int[] sampleNumbers = {8, 5, 3, 1};
        System.out.println(sampleNumbers[2]);
        /*
        5
        3 [CORRECT]
        8
        1
        */
        System.out.println("*************************************");
        
        System.out.println("Given the string \"strawberries\" saved in a variable called fruit, what would fruit.substring(2,5) return?");
        String fruit = "strawberries";
        System.out.println(fruit.substring(2,5));
        /*
        rawb
        raw [CORRECT]
        traw
        awb
        */
        System.out.println("*************************************");
        
        System.out.println("What statement returns true if \"nifty\" is of type String?");                        
        /*
        "nifty".getType() == String
        "nifty" instanceof String [CORRECT]
        "nifty".getType().equals("String")
        "nifty".getClass().getSimpleName() == "String"
        */
        System.out.println("nifty".getClass().getSimpleName() == "String");
        System.out.println("nifty" instanceof String);
        System.out.println("*************************************");
        
        System.out.println("What is the value of myCharacter after line 3 is run?");
        char myCharacter = "piper".charAt(3);
        System.out.println(myCharacter);
        /*
        e [CORRECT]
        r
        p
        i
        */
        System.out.println("*************************************");
        
        System.out.println("What is the result of this code?");
        /* try {
            System.out.println("Hello World");
        } catch(Exception e){
            System.out.println("e");            
        } catch (ArithmeticException e){
            System.out.println("e");
        } finally {
            System.out.println("!");
        }
        
        It will not compile because the second catch statement is unreacheble [CORRECT]
        It will throw a runtime exception
        Hello World!
        Hello World
        */
        System.out.println("*************************************");
        
        System.out.println("Which is the most reliable expression for testing whether the values of two string variables are the same?");
         /*         
        string1.equals(string2) [I THINK CORRECT]
        string1 = string2
        string1 == string2
        string1.matches(string2)       
        */
        System.out.println("*************************************");
        
        /* When should you use a static method?
        when your method is dependent on the specific instance that calls it
        when you want your method to be available independently of class instances [I THINK CORRECT]
        when your method is related to the object's characteristics
        when your method uses an object's instance variable
        */
        
        /*
        What phrase indicates that a function receives a copy of each argument passed to it rather than a reference to the objects themselves?
        API call
        pass by occurrence
        pass by value [I THINK CORRECT]
        pass by reference
        */
        
        /* In Java, what is the scope of a method's argument or parameter?
        neither inside nor outside the method
        outside the method
        inside the method [I THINK CORRECT]
        both inside and outside the method        
        */
        
        /* By implementation encapsulation, you cannot directly access the class's ____ properties unless you are writing code inside the class itself.
        private [I THINK CORRECT]
        protected
        public
        package-private (no explict modifier)        
        */
        
        System.out.println("What is the output of this code?");
        String message = "Hello world!";
        //String newMessage = message.substring(6, 12) + message.substring(12, 6);
        //System.out.println(newMessage);
        /*
        world!!world
        world!world!
        A runtime exception is thrown because you cannot add strings with a plus sign.
        A runtime exception is thrown because the index 12 is out of range. [I THINK CORRECT]        
        */
        System.out.println("*************************************");
        
        System.out.println("Which letters will print when this code is run?");
        try {
            System.out.println("A");
            //badMethod();
            System.out.println("B");
        } catch (Exception ex) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        /*
        A, C, and D
        A, B, and D
        C and D
        A and D  [CORRECT]
        */        
        System.out.println("*************************************");
        
        System.out.println("You have an ArrayList of names that you want to sort alphabetically. Which approach would not work?");
        List<String> names = new ArrayList<String>(Arrays.asList( "Den","Mon","Ran","Ken", "Ala", "Ben" ));
        names = names.stream().sorted((s1,s2) -> s1.compareTo(s2)).collect(Collectors.toList());        
        Collections.sort(names);
        names.sort(Comparator.comparing(String::toString));
        /*
        names = names.stream().sorted((s1,s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        names.sort(List.DESCENDING); [CORRECT]
        Collections.sort(names);
        names.sort(Comparator.comparing(String::toString));        
        */
        System.out.println(names);
        System.out.println("*************************************");
        
        System.out.println("Which code snippet is valid?");
        //ArrayList<String> words = new ArrayList<String>(){"Hello","World"};
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Hello","World")); // [CORRECT]
        //ArrayList<String> words = {"Hello","World"};
        //ArrayList words = Arrays.asList("Hello","World");
        System.out.println("*************************************");
        
        int int0 = 11;
        System.out.println("Fill in the blank to create a piece of code that will tell whether int0 is divisible by 5:");        
        /* boolean isDivisibleBy5 = ____
        Math.isDivisble(int0, 5);
        int0 % 5 != 5
        int0 / 5 ? true : false
        int0 % 5 == 0 [CORRECT]
        */
        System.out.println(int0 % 5 != 5);
        System.out.println(int0 % 5 == 0);
        System.out.println("*************************************");
                
        System.out.println("Which is not a valid lambda expression?");
        /*
        (a) -> false;
        a -> false;
        (String a) -> false;
        String a -> false;
        */
        Predicate<String> h1 = (a) -> false;
        Predicate<String> h2 = a -> false;
        Predicate<String> h3 = (String a) -> false;
        //Predicate<String> h4 = String a -> false;
        System.out.println("*************************************");
        
        System.out.println("What is the output of this code?");
        String[] array = new String[]{"A", "B", "C"};
        List<String> list1 = Arrays.asList(array);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
        /*
        truefalse
        falsetrue
        falsefalse
        truetrue [CORRECT]
        */
        System.out.println("*************************************");
    }
    
    public static void badMethod(){
        throw new Error();
    }
}
