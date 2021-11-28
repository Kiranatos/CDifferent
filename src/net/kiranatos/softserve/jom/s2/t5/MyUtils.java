package net.kiranatos.softserve.jom.s2.t5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class FourAngles {
    double height, width;
    
    public double getPerimeter(){
        return (height + width) * 2;
    }
}

class Rectang extends FourAngles {
    public Rectang(double height, double width) {
        this.height = height;
        this.width = width;
    }
    
    public double getPerimeter(){
        return super.getPerimeter();
    }
}

class Square extends FourAngles {
    public Square(double width) {
        this.width = width;
        this.height = width;
    }   
    
    public double getPerimeter(){
        return super.getPerimeter();
    }
}
public class MyUtils {
    public double sumPerimeter(List<?> figures) {     
        int sum = 0;        
        for (Object fig : figures) {
            if (Objects.nonNull(fig)){
                try {
                    sum += ((FourAngles)fig).getPerimeter();
                } catch(ClassCastException e) { }
            }
        }        
        return sum;
    }
    
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        List<FourAngles> persons = new ArrayList<>();
        persons.add(new Square(4));
        persons.add(new Square(5));
        persons.add(new Rectang(2,3));
        persons.add(null);        
        
        System.out.println(mu.sumPerimeter(persons));
        
        List<Integer> errorrrr = new ArrayList<>();
        errorrrr.add(10);
        errorrrr.add(100);
        System.out.println(mu.sumPerimeter(errorrrr));
    }
}

/*
Create classes Square and Rectang with method (double getPerimeter()) for calculating of perimeter.
Find solution for avoiding of duplicate code.
Create a double sumPerimeter(List<?> figures) method of the MyUtils class to return a sum perimeters of all figures.
For example, for a given list
[[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
you should get 46
*/