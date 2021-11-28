package net.kiranatos.softserve.jom.s7.t2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class MyUtils {
    public static void main(String[] args) {
        System.out.println(getDateAfterToday(5, 2, 10));        
    }
    
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate localDate = LocalDate.now();
        Period period = Period.of(years, months, days);
        return localDate.plus(period).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

/*
Write a method to get the date n-years m-months and k-days after today 
using new DateTime API.

Return the obtained date in the format ISO_LOCAL_DATE.
*/