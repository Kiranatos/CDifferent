package net.kiranatos.softserve.jom.s1;

/*
Suppose we have the next class:
class Employee {
    public String fullName;
    public float salary;
}
1. Create an instances of Employee class named 'emp1' and 'emp2'.
2. Set not null values for 'fullName' and 'salary' properties.
3. Create array of Employee type with name 'employees' and add two objects created before.
4. Create variable with name 'employeesInfo' of String type.
5. Using a loop, iterrate across array and write to variable named 'employeesInfo' 
info about each employee in next fommat:
[{fullName: "George", salary: 10,2}, {fullName: "Sabrina", salary: 20,1}]
*/

public class Task2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName = "George";
        emp2.fullName = "Sabrina";
        emp1.salary = 10.20f;
        emp2.salary = 20.10f;
        Employee[] employees = {emp1, emp2};        
        String employeesInfo;
        String strFormat = "{fullName: \"%s\", salary: %.1f}";
        StringBuilder sb = new StringBuilder("[");
        for (Employee e : employees) {
            if (sb.length() < 2){
                sb.append(String.format(strFormat, e.fullName, e.salary));
            } else {
                sb.append(", ").append(String.format(strFormat, e.fullName, e.salary));
            }
        }
        sb.append(']');
        employeesInfo = sb.toString();
        
        System.out.println(employeesInfo);
    }
}

class Employee {
    public String fullName;
    public float salary;
}