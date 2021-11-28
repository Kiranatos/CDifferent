package net.kiranatos.softserve.jom.s4.t2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// T 2
public class MyUtils {
    public static class Student {
        private int id;
        private String name;        
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() { return id; }
        public String getName() { return name; }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + this.id;
            hash = 59 * hash + Objects.hashCode(this.name);
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
            final Student other = (Student) obj;
            if (this.id != other.id) {
                return false;
            }
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            return true;
        }        
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> result = new HashSet<>();
        
        for (Student stud : list1) {
            if (list2.contains(stud)){
                result.add(stud);
            }
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1,"Ivan"));
        list1.add(new Student(2,"Petro"));        
        list1.add(new Student(3,"Stepan"));
        list1.add(new Student(33,"Marta"));
        list1.add(new Student(33,"Marta"));
        list1.add(new Student(33,"Marta"));
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1,"Ivan"));        
        list2.add(new Student(3,"Stepan"));
        list2.add(new Student(4,"Andriy"));
        list2.add(new Student(33,"Marta"));
        list2.add(new Student(33,"Marta"));
        list2.add(new Student(33,"Marta"));
        list2.add(new Student(33,"Marta"));
        
        Set<Student> common = new MyUtils().commonStudents(list1, list2);
        for (Student stu : common) {
            System.out.println(stu.getId() + " : " + stu.getName());
        }
    }
}

/*
Create the commonStudents() method of the MyUtils class to return a HashSet of 
common elements of two student lists.

For example, for a given
list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
and
list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students [id=4, name=Andriy]]
you should get
[Students [id=3, name=Stepan], Students [id=1, name=Ivan]] 
*/
