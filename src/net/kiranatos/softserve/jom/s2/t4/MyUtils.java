package net.kiranatos.softserve.jom.s2.t4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Create classes Employee (fields String name, int experience and BigDecimal basePayment) 
and Manager (field double coefficient) with methods which return the general 
working experience and payment for work done.

A getter methods of class Employee return value of all fields: getName(), getExperience() and getPayment().

Classes Manager is derived from class Employee and override getPayment() method 
to return multiplication of a coefficient and base payment.

Create a largestEmployees() method of the MyUtils class to return a List of 
unique employees with maximal working experience and payment without duplicate objects.

The original list must be unchanged.

For example, for a given list
 [Employee [name=Ivan, experience=10, basePayment=3000.00], 
Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],  
Employee [name=Stepan, experience=8, basePayment=4000.00], 
Employee [name=Andriy, experience=7, basePayment=3500.00], 
Employee [name=Ihor, experience=5, basePayment=4500.00], 
Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
you should get
[Employee [name=Ivan, experience=10, basePayment=3000.00], 
Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], 
Employee [name=Ihor, experience=5, basePayment=4500.00]].
*/

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }
    
    BigDecimal getBasePayment() {
        return basePayment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.experience;
        hash = 83 * hash + Objects.hashCode(this.basePayment);
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
        final Employee other = (Employee) obj;
        if (this.experience != other.experience) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.basePayment, other.basePayment)) {
            return false;
        }
        return true;
    }
}
class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
    
    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(new BigDecimal(coefficient)) ;
    }    
}
public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {        
        List<Employee> emps = new ArrayList<Employee>();
        List<Employee> mans = new ArrayList<Employee>();
     
        for (Employee w : workers) {
            if (Objects.isNull(w)) continue;
            
            if (w instanceof Manager) { mans.add(w); }
            else { emps.add(w); }
        }
        
        return Stream.concat(getMax(emps).stream(), getMax(mans).stream())
                             .collect(Collectors.toList());        
    }
    
    private List<Employee> getMax(List<Employee> workers) {
        List<Employee> result = new ArrayList<Employee>();
        
        int maxExp = Integer.MIN_VALUE;
        BigDecimal maxPayment = new BigDecimal(Integer.MIN_VALUE);
        
        for (Employee w : workers) {
            maxExp = Integer.max(maxExp, w.getExperience());
            maxPayment = maxPayment.max(w.getBasePayment());            
        }
        
        for (Employee w : workers) {
            if (result.contains(w)) continue;
            
            if ((w.getExperience() == maxExp) || (w.getBasePayment().equals(maxPayment))) {
                result.add(w);
            }                 
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        List<Employee> workers = new ArrayList<Employee>();
        workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
        workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
        workers.add(new Employee("Ivan", 10, new BigDecimal(3000)));
        workers.add(new Manager("Petro", 9, new BigDecimal(3000), 1.5));
        workers.add(new Manager("Karl", 9, new BigDecimal(3000), 1.5));
        workers.add(new Manager("Jonh", 5, new BigDecimal(7000), 1.5));
        workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
        workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
        workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
        workers.add(new Employee("Stepan", 8, new BigDecimal(4000)));
        workers.add(new Employee("Andriy", 7, new BigDecimal(3500)));
        workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
        workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
        workers.add(new Employee("Ihor", 5, new BigDecimal(4500)));
        workers.add(new Manager("Vasyl", 8, new BigDecimal(2000), 2.0));
        workers.add(null);
        
        List<Employee> bigWorkers = mu.largestEmployees(workers);
        for (Employee emp : bigWorkers) {
            System.out.printf("- %s %d %d%n", emp.getName(), emp.getExperience(), emp.getPayment().intValue() );
        }
    }
}