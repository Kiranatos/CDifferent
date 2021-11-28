package net.kiranatos.softserve.jom.s5.t23;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Task2And3 {
    public static void main(String[] args) throws Exception {
        Color color = Color.BLUE;
        System.out.println(color.toString());
        
        Plant plant = new Plant("Belladonna", "White", "Rare");
        System.out.println(plant.getColor());
    }
}

/*
TASK 2) Create a class Plant, which includes private fields String name, 
Color color and Type type, and constructor with three String parameters   
(String type, String color, String name) where these fields are initialized. 
Create getters for all fields.
Color and Type are Enum. 
Color contains White, Red, Blue entries.
Type contains Rare and Ordinary entries.

Override the method toString( ) for Plant class which returns result formatted 
like following: {type: Rare, color: Red, name: MyPlant}

Create classes ColorException and TypeException as derived from Exception. 
Both classes should have a constructor with one String parameter and pass this parameter to the base class.
The constructor of Plant should throw a corresponding exception whenever an inappropriate parameter is passed.

TASK 3) Write a static tryCreatePlant method that takes 3 string parameters - 
type, color and name and returns an instance of Plant, created based on passed params. 

The tryCreatePlant method should catch exceptions that can be thrown by Plant constructor. 
If inappropriate type passed as a parameter, a Plant object should be returned anyway, 
with Ordinary type. If an inappropriate color is passed, set Red color for created instance.
*/

class Plant {        
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException {        
        this.name = name;
        try {
            this.color = Color.valueOf(color.toUpperCase()); 
        } catch (IllegalArgumentException e) {
            throw new ColorException("Invalid value " + color + " for field color");
        }
        
        try {
            this.type = Type.valueOf(type.toUpperCase()); 
        } catch (IllegalArgumentException e) {
            throw new TypeException("Invalid value " + type + " for field type");
        }
    }    

    public String getName() {
        return name;
    }

    public Color getColor() {        
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color + ", name: " + name + '}';
    }
    
    public static Plant tryCreatePlant(String type, String color, String name) {
        try {
            return new Plant(type, color, name);
        } catch (ColorException ex) {
            return tryCreatePlant(type, "RED", name);
        } catch (TypeException ex) {
            return tryCreatePlant("Ordinary", color, name);
        }
    }    
}

enum Color { WHITE, RED, BLUE }
enum Type { RARE, ORDINARY }

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}