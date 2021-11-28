package net.kiranatos.softserve.jom.s2.t1;

public class Person {
    int age;
    String healthInfo;
    String name;
    String getHealthStatus(){ return name +" " + healthInfo; }

    public Person(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }    
}

class Child extends Person {
    String childIDNumber;

    public Child(int age, String healthInfo, String name, String childIDNumber) {
        super(age, healthInfo, name);
        this.childIDNumber = childIDNumber;
    }
    
}

class Adult extends Person {    
    String passportNumber;   

    public Adult(int age, String healthInfo, String name, String passportNumber) {
        super(age, healthInfo, name);
        this.passportNumber = passportNumber;
    }    
}

/*
We know that adult  doesn't have childIDNumber.
Child doesn't have passportNumber.
Create a public constructor in each class to initialize all their fields (make the first parameter of type int).
*/