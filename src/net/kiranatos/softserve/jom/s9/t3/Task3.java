package net.kiranatos.softserve.jom.s9.t3;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Task3 {
    public static void main(String[] args) {
        TestSuitHandler.run(Class1.class);
        TestSuitHandler.run(Class2.class);
        TestSuitHandler.run(Class3.class);
    }
}
/*
Create single-value annotation TestSuite with default element that returns array of strings.
Create class TestSuitHandler with static method run(Class<?> clazz).
This method invokes all public non-static zero args methods.
This method print to console information about all executed methods in form:
   -- Method <class>.<methodname> started --
<result of  methodname invocation>
  -- Method <class><methodname> finished --
(before -- should printed tab character)
If clazz doesn't contain the <methodName> defined in annotation information 
Method with name <methodName> doesn't exists or not public in class clazz should be displayed.
If clazz is not marked with TestSuite annotation message Class clazz isn't annotated should be displayed.

For example:
We have:
@TestSuite({"m1", "m2"})
class Class1{
  public void m2(){
    System.out.println("Hello");
  }
}

We run 
TestSuiteHandler.run(Class1.class);

As a result we have

Method with name m1 doesn't exists or not public in class Class1
	 -- Method Class1.m2 started --
Hello
	 -- Method Class1.m2 finished -- */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value();
}

class TestSuitHandler { 
    public static void run(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            TestSuite testSuite = clazz.getDeclaredAnnotation(TestSuite.class);
            for (String string : testSuite.value()) {
                if (checkSameMethods(string, clazz.getDeclaredMethods())) {
                    try {
                        System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " started --");
                        clazz.getDeclaredMethod(string).invoke(clazz.getDeclaredConstructor().newInstance());
                        System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " finished --");
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else System.out.printf("Method with name %s doesn't exists or not public in class %s%n", string, clazz.getName());
            }
        } else {
            System.out.println("Class " + clazz.getName() + " isn't annotated");
        }
    }

    public static boolean checkSameMethods(String value, Method[] methods) {
        for (Method m : methods) {
            if (value.equals(m.getName()) && (m.getModifiers() & Modifier.PUBLIC) != 0) {
                return true;
            }
        }
        return false;
    }
}

@TestSuite({"m1", "m2"})
class Class1{
  public void m2(){
    System.out.println("Hello");
  }
}

class Class2 {
    public void m2(){
        System.out.println("Hello");
    }
}

@TestSuite({"m1", "m2", "m5"})
class Class3 {
    public void m2(){
        System.out.println("Sith");
    }
    void m5(){
        System.out.println("Jedi");
    }
}