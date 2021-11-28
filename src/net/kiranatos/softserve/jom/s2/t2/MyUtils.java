package net.kiranatos.softserve.jom.s2.t2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* Task 2
Create interface DrinkReceipt with methods String getName() and 
DrinkReceipt addComponent(String componentName, int componentCount). 
Create interface DrinkPreparation with method Map<String, Integer> makeDrink() 
to return a drink components. Create interface Rating with method int getRating().

Class Caffee contains fields String name, int rating, Map of ingredients and 
implements interfaces DrinkReceipt, DrinkPreparation and Rating. 
Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}. 
Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink(). 
Espresso caffee has 50 g. of Water. Cappuccino caffee has an additional of 50 g. of Milk.

Create a averageRating() method of the MyUtils class to return a Map with coffee 
name as key and coffee average rating as value.
For example, for a given list
[Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10], 
Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6], 
Caffee [name=Caffee, rating=6]]
you should get
{Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
 */
interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.rating;
        hash = 23 * hash + Objects.hashCode(this.ingredients);
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
        final Caffee other = (Caffee) obj;
        if (this.rating != other.rating) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        return true;
    }
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public Caffee(int rating, String name) {
        init(rating, name);
    }

    public Caffee(String name, int rating) {
        init(rating, name);
    }

    public Caffee(int rating) {
        init(rating, this.getClass().getSimpleName());
    }

    private void init(int rating, String name) {
        this.rating = rating;
        ingredients = new HashMap<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100);
        this.addComponent("Arabica", 20);
        return ingredients;
    }

    @Override
    public int getRating() {
        return rating;
    }
}

class Espresso extends Caffee {
    public Espresso(int rating) {
        super(rating);
    }

    public Espresso(int rating, String name) {
        super(rating, name);
    }

    public Espresso(String name, int rating) {
        super(rating, name);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 50);
        this.addComponent("Arabica", 20);
        return this.getIngredients();
    }
}

class Cappuccino extends Caffee {

    public Cappuccino(int rating) {
        super(rating);
    }

    public Cappuccino(int rating, String name) {
        super(rating, name);
    }

    public Cappuccino(String name, int rating) {
        super(rating, name);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100);
        this.addComponent("Arabica", 20);
        this.addComponent("Milk", 50);
        return this.getIngredients();
    }
}

public class MyUtils {

    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> result = new HashMap<>();
        Map<String, int[]> average = new HashMap<>();
        for (Caffee coffee : coffees) {
            String key = coffee.getName();
            if (average.containsKey(key)) {
                int[] temp = average.get(key);
                temp[0] += coffee.getRating();
                temp[1]++;
            } else {
                average.put(key, new int[]{coffee.getRating(), 1});
            }
        }

        for (String strKey : average.keySet()) {
            int[] temp = average.get(strKey);
            double ave = temp[0] / temp[1];
            result.put(strKey, (temp[0] / (double) temp[1]));
        }
        return result;
    }

    public static void main(String[] args) {
        Caffee coffee1 = new Caffee(8);
        System.out.println(coffee1.getName());
        System.out.println(coffee1.getRating());
        Caffee coffee2 = new Caffee(10, "Caffee");
        System.out.println(coffee2.getName());
        System.out.println(coffee2.getRating());
        Caffee coffee3 = new Cappuccino(8);
        System.out.println(coffee3.getName());
        System.out.println(coffee3.getRating());
        Caffee coffee4 = new Cappuccino(9, "Cappuccino");
        System.out.println(coffee4.getName());
        System.out.println(coffee4.getRating());

        MyUtils mu = new MyUtils();
        List<Caffee> coffees = new ArrayList<>();
        coffees.add(coffee1);
        coffees.add(coffee2);
        coffees.add(coffee3);
        coffees.add(coffee4);
        Map<String, Double> mapA = mu.averageRating(coffees);
        System.out.println(mapA);
    }
}
