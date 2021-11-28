package net.kiranatos.softserve.jom.s4.t4;

public class Task4 {
    public static void main(String[] args) {
        // Print to display: 52
        Integer[] numbers = new Integer[3];
        int numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(numberFromSecondPosition);
        
        // Print to display: Hello
        String[] words = new String[3];
        String wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words, "Hello", 1);
        System.out.println(wordFromSecondPosition);
        
        wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words, "Hello", 0);
        System.out.println(wordFromSecondPosition);        
    }
}

class ArrayUtil {
    
//    public static <T> T setAndReturn(T... array){    
//        try {
//        int index = (Integer)array[array.length-1];        
//        return (T)array[index];}
//        catch(ArrayIndexOutOfBoundsException | ClassCastException e){ return null; }
//    }
        
    public static <T> T setAndReturn(T[] matrixT, T t, int index){
        matrixT[index] = t;
        return matrixT[index];        
    }    
}

/*
In the class ArrayUtil write a public static generic method named 
"setAndReturn(...)" to modify and return the element in an array from the given position.

Examples of usage:
*/

/*
@SuppressWarnings("unchecked") over AddressBook and AddressBookIterator classes.
*/