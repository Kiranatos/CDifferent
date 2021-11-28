package net.kiranatos.softserve.jom.s3.t5;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(ClientType.NEW.discount());
        System.out.println(ClientType.SILVER.discount());
        System.out.println(ClientType.GOLD.discount());
        System.out.println(ClientType.PLATINUM.discount());
    }
}

enum ClientType { 
    NEW(1), 
    SILVER(12){
        @Override
        public double discount(){            
            return (100.0 - 0.25 * super.discount()) / 100.0;
        }}, 
    GOLD(30){
        @Override
        public double discount(){            
            return (100.0 - 0.3 * super.discount()) / 100.0;
        }},
    PLATINUM(60){
        @Override
        public double discount(){            
            return (100.0 - 0.35 * super.discount()) / 100.0;
        }};
    private int months;

    ClientType(int months) {
        this.months = months;
    }
    
    public double discount(){
        return months;
    }
}
/*
Create ClientType enum that contains NEW, SILVER, GOLD and PLATINUM 
constants that represent client status.
For storing count of months for each client create private "months" field of 
type int and initialize it using constructor with int parameter.
Set for each item of enum a value according to next table:

Client status               Count of months
NEW                         1
SILVER                      12
GOLD                        30
PLATINUM                    60

Create public method named “discount()” that return discount value as 
coefficient from 1.0 to 0.0 according to client status.
By default discount() method should return value 1.0 of double type.
Override discount() method for each constant and return discount value 
that calculated by next formula:

Client status               Formula
NEW                         Default value
SILVER                      (100 - <count of months> * 0,25) / 100
GOLD                        (100 - <count of months> * 0,3) / 100
PLATINUM                    (100 - <count of months> * 0,35) / 100 
*/