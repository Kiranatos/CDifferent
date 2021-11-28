package net.kiranatos.softserve.jom.s2.t6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class Shape {
    private String name;

    public String getName() {
        return name;
    }

    public Shape(String name) {
        this.name = name;
    }    
    
    public abstract double getArea();
}
class Circle extends Shape {
    private double radius;
    public Circle(double radius, String name) {
        super(name);
        this.radius = radius;
    }
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {        
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        return true;
    }
    
    
}

class Rectangle extends Shape {
    private double height, width;

    public Rectangle(double height, double width, String name) {
        super(name);
        this.height = height;
        this.width = width;
    }
    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
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
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        return true;
    }
    
    
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> rs = new ArrayList<>();
        List<Shape> cs = new ArrayList<>();
     
        for (Shape w : shapes) {
            if (Objects.isNull(w)) continue;
            
            if (w instanceof Rectangle) { rs.add(w); }
            else { cs.add(w); }
        }
        
        return Stream.concat(getMax(rs).stream(), getMax(cs).stream())
                             .collect(Collectors.toList());  
    }
    
    private List<Shape> getMax(List<Shape> shapes) {
        List<Shape> result = new ArrayList<>();
        
        double maxArea = Double.MIN_VALUE;        
        
        for (Shape w : shapes) {
            maxArea = Double.max(maxArea, w.getArea());            
        }
        
        for (Shape w : shapes) {
            if (result.contains(w)) continue;
            
            if (w.getArea() == maxArea) {
                result.add(w);
            }                 
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(2, "Circle_2"));
        shapes.add(new Rectangle(2, 3, "Rectangle_2_3"));
        shapes.add(new Circle(1, "Circle_1"));
        shapes.add(new Rectangle(3, 2, "Rectangle_3_2"));
        shapes.add(new Rectangle(3, 2, "Rectangle_3_2"));
        shapes.add(new Rectangle(3, 2, "Rectangle_3_2"));
        shapes.add(new Circle(0.5, "Circle_0.5"));
        shapes.add(new Rectangle(1, 2, "Rectangle_1_2"));
        shapes.add(null);
        
        List<Shape> bigWorkers = mu.maxAreas(shapes);
        for (Shape emp : bigWorkers) {
            System.out.printf("- %s \t%f %n", emp.getName(), emp.getArea());
        }
    }
}
/*
Let the code given.

Please create class Shape with abstract method to calculate area of figure and 
field name. Replace code in method getArea() according to principles of polymorphism i.e. 
Circle and Rectangle classes extends Shape class and override double getArea() method. 
Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.

The original list must be unchanged.

For example, for a given list
[Circle [radius=2.00], 
Rectangle [height=2.00, width=3.00], 
Circle [radius=1.00], 
Rectangle [height=3.00, width=2.00],  
Circle [radius=0.50], 
Rectangle [height=1.00, width=2.00]]
you should get
[Circle [radius=2.00], 
Rectangle [height=2.00, width=3.00], 
Rectangle [height=3.00, width=2.00]]
*/