package net.kiranatos.softserve.jom.s2.t3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
Create next types: Person (field String name), Student (fields String studyPlace, 
int studyYears) and Worker (fields String workPosition, int experienceYears). 
Classes Student and Worker are derived from class Person. All classes have getters to return fields.

Create a maxDuration() method of the MyUtils class to return a list of Students 
with maximum duration of study and Workers with maximum experience.

    For example, for a given list
[Person [name=Ivan], 
Student [name=Petro, studyPlace=University, studyYears=3], 
Worker [name=Andriy, workPosition=Developer, experienceYears=12], 
Student [name=Stepan, studyPlace=College, studyYears=4], 
Worker [name=Ira, workPosition=Manager, experienceYears=8], 
Student [name=Ihor, studyPlace=University, studyYears=4]]
    you should get
[Worker [name=Andriy, workPosition=Developer, experienceYears=12], 
Student [name=Stepan, studyPlace=College, studyYears=4], 
Student [name=Ihor, studyPlace=University, studyYears=4]]
*/

class Person {
    private String name;
    private String place;
    private int exp;

    public Person(String name) {
        this.name = name;
    }
    
    Person(String place, String name, int exp) {
        this.name = name;
        this.place = place;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }    

    String getPlace() {
        return place;
    }

    void setPlace(String place) {
        this.place = place;
    }

    int getExp() {
        return exp;
    }

    void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.place);
        hash = 37 * hash + this.exp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.exp != other.exp) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        return true;
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(studyPlace, name, studyYears);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }    
}

class Worker extends Person {    
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(workPosition, name, experienceYears);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }
    
    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
public class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        List<Person> result = new ArrayList<>();
        int maxExpY = Integer.MIN_VALUE;
        int maxStY = Integer.MIN_VALUE;
        for (Person per : persons) {
            if (per instanceof Student) {
                int temp = ((Student) per).getStudyYears();
                if ( temp > maxStY) { 
                    maxStY = temp;
                }
            } else if (per instanceof Worker) {
                int temp = ((Worker) per).getExperienceYears();
                if ( temp > maxExpY) { 
                    maxExpY = temp;
                }
            }
        }
        
        for (Person per : persons) {
            if (result.contains(per)) continue;
            
            if (per instanceof Student) {                
                if ( ((Student) per).getStudyYears() == maxStY) { 
                    result.add(per);
                }
            } else if (per instanceof Worker) {                
                if ( ((Worker) per).getExperienceYears() == maxExpY) { 
                    result.add(per);
                }
            }
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan"));
        persons.add(new Student("Petro", "University", 3));
        persons.add(new Worker("Andriy", "Developer", 12));
        persons.add(new Worker("Andriy", "Developer", 12));
        persons.add(new Worker("Andriy", "Developer", 12));
        persons.add(new Worker("Andriy", "Developer", 12));
        persons.add(new Student("Stepan", "College", 4));
        persons.add(new Worker("Ira", "Manager", 8));
        persons.add(new Student("Ihor", "University", 4));        
        persons.add(new Student("Ihor", "University", 4));
        persons.add(new Student("Ihor", "University", 4));
        
        persons = mu.maxDuration(persons);
        for (Person p : persons) {
            System.out.println(p.getName());
        }        
    }
}
