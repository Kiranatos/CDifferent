package net.kiranatos.softserve.jom.s6.t2;

import java.util.Arrays;
import java.util.function.Consumer;

//@SuppressWarnings("unchecked")
public class App {
    
    public static Consumer<double[]> cons = x -> {
        for (int i = 0; i < x.length; i++) {
            if (x[i] > 2) x[i] *= 0.8;
            else x[i] *= 0.9;
        }
    };


    public static double[] getChanged(double[] initialArray, Consumer cons) {
        double[] result = new double[initialArray.length];
        System.arraycopy(initialArray, 0, result, 0, initialArray.length);
        cons.accept(result);
        return result;
        
    }
    
    public static void main(String[] args) {
        double[] arr1 = new double[]{1,2,-3,3,5,6,7,8,-10};
        double[] arr2 = App.getChanged(arr1, cons);
        
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        
        System.out.println("***********************************");
        
        double[] arr3 = new double[] {1, 2, 3, -1, -5, 0};
        double[] arr4 = App.getChanged(arr3, cons);
        
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        
    }
}
//return (double[]) Stream.of(initialArray).peek(cons).findFirst().get();        
/*
Create the static field cons of type Consumer and assign it the lambda expression 
that takes an array of doubles as a parameter and changes it using the next rule: 
all values that are greater than 2 should be multiplied by 0.8, and other values 
should be multiplied by 0.9.

Also implement a static method getChanged(...) that takes an array of doubles as 
a first parameter and Consumer implementation as a second. The method should 
return an array changed by the second parameter.

The getChanged(...) method should not change initial array. 
*/