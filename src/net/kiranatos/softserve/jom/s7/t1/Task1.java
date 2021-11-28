package net.kiranatos.softserve.jom.s7.t1;

import java.time.LocalDate;

public class Task1 {
    public static void main(String[] args) {
        for (int i = 1999; i < 2030; i++) {
            System.out.println(i + " leap: " + isLeapYear(i));
        }
    }

    public static boolean isLeapYear(int year) {
        LocalDate localDate = LocalDate.now().withYear(year);
        return localDate.isLeapYear();
    }
}

/*
Write a method to check if a year is a leap year or not, using for this the 
LocalDate class.
If a year is leap then method should return true, otherwise - false.
*/
