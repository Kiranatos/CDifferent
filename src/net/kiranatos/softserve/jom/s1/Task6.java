package net.kiranatos.softserve.jom.s1;

public class Task6 {
}

class Product {
    private String name;
    private double price;
    private static int instances = 0;

    public static int count(){
        return instances;
    }
    
    public Product() {
        instances++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        instances++;
    }
    
    public Product(double price, String name) {
        this.name = name;
        this.price = price;
        instances++;
    }

    public Product(String name) {
        this.name = name;
        instances++;
    }

    public Product(double price) {
        this.price = price;
        instances++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
