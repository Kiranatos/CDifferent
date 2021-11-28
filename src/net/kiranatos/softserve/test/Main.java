package net.kiranatos.softserve.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        int a = 10;
        int b = 5;
try {
            int n = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Divide by 0");
        } finally {
            System.out.println("The end");
        }
    }

}
