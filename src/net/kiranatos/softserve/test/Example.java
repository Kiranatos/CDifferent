package net.kiranatos.softserve.test;

public class Example {

    private static final int RED = 0;
    private static final int GREEN = 1;

    private static final int YELLOW = 2;

    public static void main(String[] args) {
        int color = 2;
        switch (color) {
            case RED:
                System.out.println("Red");
                break;
            default:
                System.out.println("Yellow");
            case GREEN:
                System.out.println("Green");
        }
    }
}
