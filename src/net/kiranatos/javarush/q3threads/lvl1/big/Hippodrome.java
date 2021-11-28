package net.kiranatos.javarush.q3threads.lvl1.big;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    public ArrayList<Horse> horses = new ArrayList<Horse>();
    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horseOne = new Horse("Pinkie Pie", 3, 0);
        Horse horseTwo = new Horse("Twilight Sparkle", 3, 0);
        Horse horseThree = new Horse("Applejack", 3, 0);

        ArrayList<Horse> horsesList = game.getHorses();
        horsesList.add(horseOne);
        horsesList.add(horseTwo);
        horsesList.add(horseThree);

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : getHorses()) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : getHorses()) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse h : getHorses()) {
            double t = h.getDistance();
            if (t > max) {
                max = t;
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
