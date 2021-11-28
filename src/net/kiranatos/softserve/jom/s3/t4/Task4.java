package net.kiranatos.softserve.jom.s3.t4;

public class Task4 {
// Describe LineType enum here
    enum LineType { SOLID, DOTTED, DASHED, DOUBLE }

    public static String drawLine(LineType lineType) {
        // Write method code here
        return String.format("The line is %s type", lineType.toString().toLowerCase());
    }
    
    public static void main(String[] args) {        
        System.out.println(drawLine(Task4.LineType.SOLID));
        System.out.println(drawLine(Task4.LineType.DOTTED));
        System.out.println(drawLine(Task4.LineType.DASHED));
        System.out.println(drawLine(Task4.LineType.DOUBLE));
    }
}
/*
Create a LineType enum that contains different kind of lines 
as constants SOLID, DOTTED, DASHED and DOUBLE.
Write a method that takes the constant of LineType type as input, 
and returns the message “The line is <LineType> type”.
Where <LineType>  is name of type wrote in lower case.
For example: The line is dotted type.
*/
