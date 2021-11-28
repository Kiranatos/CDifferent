package net.kiranatos.softserve.jom.s3.t1;

/*
Suppose we have the next class:

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;
    private Pizza() {    }
    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }}

Create public static inner class named PizzaBuilder inside Pizza class that correspond the next class diagram:
            PizzaBuilder
    ___________________________
    - pizza: Pizza
    ___________________________
    - PizzaBuilder()
    + addCheese(cheese: String): PizzaBuilder
    + addMeat(meat: String): PizzaBuilder
    + addSeafood(seafood: String): PizzaBuilder
    + addVegetable(vegetable: String): PizzaBuilder
    + addMushroom(mushroom: String): PizzaBuilder
    + build(): Pizza
Inside the cook method create and return an instance of Pizza class with your at least three favorite ingredients.
*/

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {    }

    public String getCheese() {
        return cheese;
    }

    public String getMeat() {
        return meat;
    }

    public String getSeafood() {
        return seafood;
    }

    public String getVegetable() {
        return vegetable;
    }

    public String getMushroom() {
        return mushroom;
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }
    
    public static class PizzaBuilder {
        private Pizza pizza;
        private PizzaBuilder() {   pizza = new Pizza();    }        
        public PizzaBuilder addCheese(String cheese) { 
            pizza.cheese = cheese;
            return this;
        } 
        public PizzaBuilder addMeat(String meat) { pizza.meat = meat; return this; }
        public PizzaBuilder addSeafood(String seafood) { pizza.seafood = seafood; return this; }
        public PizzaBuilder addVegetable(String vegetable) { pizza.vegetable = vegetable; return this; }
        public PizzaBuilder addMushroom(String mushroom) { pizza.mushroom = mushroom; return this; }
        public Pizza build() { return pizza; }        
    }
}

class Oven {
    public static Pizza cook() {
        return Pizza.base()
                .addCheese("Gauda")
                .addMeat("Pork")
                .addSeafood("Tentacles")
                .addVegetable("Pumpkin")
                .addMushroom("Death Cap")
                .build();
    }
    
    public static void main(String[] args) {
        Pizza pizza = Oven.cook();
        System.out.println(pizza.getCheese());
        System.out.println(pizza.getMeat());
        System.out.println(pizza.getSeafood());
        System.out.println(pizza.getVegetable());
        System.out.println(pizza.getMushroom());
    }
}