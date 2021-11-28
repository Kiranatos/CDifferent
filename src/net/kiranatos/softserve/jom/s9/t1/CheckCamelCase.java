package net.kiranatos.softserve.jom.s9.t1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "[a-z][A-Za-z\\d]*";
    
    public static void main(String[] args) {
        System.out.println("\n\t\tClass1:");
        System.out.println(CheckCamelCase.checkAndPrint(Class1.class));
        System.out.println("\n\t\tClass2:");
        System.out.println(CheckCamelCase.checkAndPrint(Class2.class));
        System.out.println("\n\t\tClassForAnnot:");
        System.out.println(CheckCamelCase.checkAndPrint(ClassForAnnot.class));
    }
    
    public static boolean checkAndPrint(Class<?> clazz) {
        Method[] methodArray = clazz.getDeclaredMethods();
        boolean allMethodsAccordingCodeConventions = true;
        for (Method method : methodArray) {    
            System.out.println(method.getName() + " : " + method.isAnnotationPresent((CamelCase.class)));
            if ((method.isAnnotationPresent((CamelCase.class))) &&
                    (!method.getName().matches(CAMELCASE_PATTERN))) {                
                System.out.printf("method %s.%s doesn't satisfy camelCase naming convention%n", 
                        clazz.getSimpleName(), method.getName());
                allMethodsAccordingCodeConventions = false;
            }
            String s = method.getName();
            boolean b = s.matches(s);
        }
        return allMethodsAccordingCodeConventions;
    }
}
/*
Create marker-annotation CamelCase which will check whether method named 
according to code conventions. Create class CheckCamelCase for checking if all 
the annotated methods of some class satisfy naming pattern. This class contains 
constant 'CAMELCASE_PATTERN' that introduces regex for checking method name. 
Also this class contains method checkAndPrint(Class clazz) which returns true 
if all annotated methods of class satisfy 'CAMELCASE_PATTERN' and prints to 
standard output information about all incorrect method names by template: 
method <className>.<methodName> doesn't satisfy camelCase naming convention. 
For example

For class 
public class Class1 {
    @CamelCase
    public void correct(){} 
    @CamelCase
    public void InCorrect(){} 
    public void JustMethod(){}
}
call CheckCamelCase.checkAndPrint(Class1.class) 
prints to console 
method Class1.InCorrect doesn't satisfy camelCase naming convention
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase{}


class ClassForAnnot {
    @CamelCase
    public static void example() {   }

    @CamelCase
    public void Example() {    }

    public static void _main(String args[]) {    }
}





