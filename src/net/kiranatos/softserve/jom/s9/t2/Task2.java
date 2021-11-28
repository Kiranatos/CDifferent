package net.kiranatos.softserve.jom.s9.t2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task2 {
    public static void main(String[] args) throws ParseException {
        String today = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
        System.out.println(today);
        
        Util.review("net.kiranatos.softserve.jom.s9.t2.A");
        Util.review("net.kiranatos.softserve.jom.s9.t2.B");
        Util.review("net.kiranatos.softserve.jom.s9.t2.C");
        Util.review("Z");
        Util.review("net.kiranatos.softserve.jom.s9.t2.Task2");
    }
}

/*
Create annotation Review with two string elements: reviewer and date.
Element date has default string value today.
This annotation can be applied to class when we execute static method review
(String className) of class Util and the result of this method will be printed 
Class <ClassName> was reviewed <date in format yyyy-mm-dd> by <reviewer> to 
standard output (console).
If the class <className> isn’t annotated we show message: Class <ClassName> 
isn't marked as Reviewed.
If the class was not found we show message: Class <ClassName> was not found. 
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    //static final String today = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
    String reviewer();
    String date() default "today";    
}

class Util {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private final static LocalDate localDate = LocalDate.parse(LocalDate.now().format(dateTimeFormatter));
    
    public static void review(String className){
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Review.class)){
                Review reviewAnnot = clazz.getAnnotation(Review.class);                
                if (reviewAnnot.date().equals(localDate.toString()) || reviewAnnot.date().equals("today")) {
                    System.out.printf("Class %s was reviewed %s by %s.%n", className, localDate, reviewAnnot.reviewer());                    
                } else 
                    System.out.printf("Class %s was reviewed %s by %s.%n", className, reviewAnnot.date(), reviewAnnot.reviewer());                    
            } else {
                System.out.printf("Class %s isn't marked as Reviewed%n", clazz.getSimpleName());
            }
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class %s was not found%n", className);
        }
    }
}

@Review(reviewer="me")
class A { }

@Review(reviewer = "you", date = "2030-08-14")
class B { }

class C { }
