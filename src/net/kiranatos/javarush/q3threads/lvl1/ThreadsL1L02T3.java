package net.kiranatos.javarush.q3threads.lvl1;

/* Java Multithreading level 1, lection 2, task 3

Все гениальное - просто!
Упростить. Переменные не переименовывать, комментарии не оставлять.

Old variant: package com.javarush.test.level21.lesson02.task03;
*/

public class ThreadsL1L02T3 {
    //primordial:
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);        
    }
    
    //simplified
    public static boolean calculate2(boolean a, boolean b, boolean c, boolean d) {        
        return c;
    }
    
    public static void main(String[] args) {        
        System.out.print(calculate(true, true, true, true) + " ");
        System.out.print(calculate(true, true, true, false) + " ");
        System.out.print(calculate(true, true, false, true) + " ");
        System.out.print(calculate(true, true, false, false) + " ");
        System.out.print(calculate(true, false, true, true) + " ");
        System.out.print(calculate(true, false, true, false) + " ");
        System.out.print(calculate(true, false, false, true) + " ");
        System.out.print(calculate(true, false, false, false) + " ");
        System.out.print(calculate(false, true, true, true) + " ");
        System.out.println();
        System.out.print(calculate2(true, true, true, true) + " ");
        System.out.print(calculate2(true, true, true, false) + " ");
        System.out.print(calculate2(true, true, false, true) + " ");
        System.out.print(calculate2(true, true, false, false) + " ");
        System.out.print(calculate2(true, false, true, true) + " ");
        System.out.print(calculate2(true, false, true, false) + " ");
        System.out.print(calculate2(true, false, false, true) + " ");
        System.out.print(calculate2(true, false, false, false) + " ");
        System.out.print(calculate2(false, true, true, true) + " ");        
    }
}
