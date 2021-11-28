package net.kiranatos.softserve.jom.s3t;

public class Main {
    public static void main(String[] args) {
        for (Directions direction : Directions.values()) {
            System.out.print(direction.value + " ");
        }           
    }
}

enum Directions {
    NORTH(1), SOUTH(2), WEST(3), EAST(4);
    public int value;
    private Directions(int number) {
        this.value = number;
    }    
}