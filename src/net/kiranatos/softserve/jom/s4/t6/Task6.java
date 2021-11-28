package net.kiranatos.softserve.jom.s4.t6;

import java.util.Arrays;
import java.util.Comparator;

public class Task6 {
    public static void main(String[] args) {
        Person[] pArray = new Person[]{
        new Person("Alena", 13),
        new Person("Bob", 13),
        new Person("Celesta", 14),
        new Person("Diana", 99),
        new Person("Erico", 50),
        new Person("Erico", 550),
        new Person("Erico", 50),
        new Person("Alena", 14),
        new Person("Alena", 15),                
        };
        
        Utility.sortPeople(pArray, new PersonComparator());
        
        for (Person p : pArray) {
            System.out.println(p);
        }
        
        System.out.println("***********************");
        
        Employee[] eArray = new Employee[]{        
        new Employee("Bob", 13, 1000.0),
        new Employee("Celesta", 14, 1000.0),
        new Employee("Diana", 99, 1000.0),
        new Employee("Erico", 50, 9000.0),
        new Employee("Erico", 550, 1000.0),        
        new Employee("Erico", 50, 1000.0),
        new Employee("Alena", 14, 1000.0),
        new Employee("Alena", 15, 3000.0),
        new Employee("Alena", 15, 9000.0),
        new Employee("Alena", 15, 2000.0),
        new Employee("Alena", 15, 4000.0),
        new Employee("Alena", 13, 1000.0),
        };
        
        Utility.sortPeople(eArray, new EmployeeComparator());
        
        for (Person p : eArray) {
            System.out.println(p);
        }
        
        System.out.println("***********************");
        
        Developer[] dArray = new Developer[]{        
        new Developer("Bob", 13, 1000.0, Level.JUNIOR),
        new Developer("Celesta", 14, 1000.0, Level.JUNIOR),
        new Developer("Diana", 99, 1000.0, Level.JUNIOR),
        new Developer("Erico", 50, 9000.0, Level.JUNIOR),
        new Developer("Erico", 550, 1000.0, Level.JUNIOR),
        new Developer("Erico", 50, 1000.0, Level.JUNIOR),
        new Developer("Alena", 14, 1000.0, Level.JUNIOR),
        new Developer("Alena", 15, 3000.0, Level.JUNIOR),
        new Developer("Alena", 15, 9000.0, Level.SENIOR),
        new Developer("Alena", 15, 9000.0, Level.JUNIOR),
        new Developer("Alena", 15, 9000.0, Level.MIDDLE),
        new Developer("Alena", 15, 9000.0, Level.SENIOR),
        new Developer("Alena", 15, 9000.0, Level.JUNIOR),
        new Developer("Alena", 15, 2000.0, Level.JUNIOR),
        new Developer("Alena", 15, 4000.0, Level.JUNIOR),
        new Developer("Alena", 13, 1000.0, Level.JUNIOR),
        };
        
        Utility.sortPeople(dArray, new DeveloperComparator());
        
        for (Person p : dArray) {
            System.out.println(p);
        }

    }
}

class ObjectComparator implements Comparator<Object> {
     @Override
     public int compare(Object o1, Object o2) { return 0; }
 }

class StringComparator implements Comparator<String> {
     @Override
     public int compare(String s1, String s2) { 
         return s1.compareTo(s2); }
 }

// Suppose we have the next class hierarchy:
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }    
}

class Employee extends Person {
    private double salary;
    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }    
}

class Developer extends Employee {
    private Level level;

    public Developer(String name, int age, double salary, Level level) {        
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level;
    }
}

enum Level { JUNIOR, MIDDLE, SENIOR }

/*
Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator 
that implenent the Comparator<Type> generic interface.

In the Utility class create public static method named sortPeople(...) 
that takes an array of Person type and derivative from it types, 
and comparator as input, and returns the value of void type.

Also, as second argument the method sortPeople(...) 
can takes generic comparator for elements of Object type.

The sortPeople(...) method should sorted records by ascending. At first by name, 
then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)

As implementation of sortPeople(...) method use the next code:
/return type/ sortPeople(/people/, /comparator/) {
    Arrays.sort(/people/, /comparator/);
}
*/
//works:
// public static <T> void sortPeople(T[] people, Comparator<? super T> comparator) { 
// public static <T extends Person> void sortPeople(T[] people, Comparator<? super T> comparator) { 

class Utility {    
    public static <T extends Person> void sortPeople(T[] people, Comparator<? super T> comparator) { 
        Arrays.sort(people, comparator);
    }
}

class PersonComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Person po1 = (Person)o1;
        Person po2 = (Person)o2;
        int inequality = po1.getName().compareTo(po2.getName());
        if (inequality == 0) {
            return po1.getAge() - po2.getAge();
        } else return inequality;
    }
}

class EmployeeComparator extends PersonComparator  { 
    @Override
    public int compare(Object o1, Object o2) {
        int inequality = super.compare(o1, o2);
        if (inequality == 0) {
            return (int)(((Employee)o1).getSalary() - ((Employee)o2).getSalary());
        } else return inequality;
    }
} 

class DeveloperComparator extends EmployeeComparator {
    @Override
    public int compare(Object o1, Object o2) {
        int inequality = super.compare(o1, o2);
        if (inequality == 0) {
            return ((Developer)o1).getLevel().ordinal() - ((Developer)o2).getLevel().ordinal();
        } else return inequality;
    }
}

//class EmployeeComparator implements Comparator<Employee> { 
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        int inequality = new PersonComparator().compare(o1, o2);
//        if (inequality == 0) {
//            return (int)(((Employee)o1).getSalary() - ((Employee)o2).getSalary());
//        } else return inequality;
//    }
//}
//
//class DeveloperComparator implements Comparator<Developer> {
//    @Override
//    public int compare(Developer o1, Developer o2) {
//        int inequality = new EmployeeComparator().compare(o1, o2);
//        if (inequality == 0) {
//            return ((Developer)o1).getLevel().ordinal() - ((Developer)o2).getLevel().ordinal();
//        } else return inequality;
//    }
//}


