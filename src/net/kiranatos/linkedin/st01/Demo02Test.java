package net.kiranatos.linkedin.st01;

import java.util.LinkedList;


public class Demo02Test {
    public static void main(String[] args) {
        System.out.println("What will this program print out to the console when executed?");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(10);
        System.out.println(list);
        /*
        [1, 5, 10]
        [10, 5, 1]
        [5, 1, 10] [CORRECT]
        [10, 1, 5]
        */
        System.out.println("*************************************");
    }
}
