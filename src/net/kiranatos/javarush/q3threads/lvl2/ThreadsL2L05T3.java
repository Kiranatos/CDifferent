package net.kiranatos.javarush.q3threads.lvl2;

/* Java Multithreading level 2, lection 5, task 3

Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
Требования:
    Класс TooShortStringException должен быть потомком класса Exception.
    Метод getPartOfString должен принимать строку в качестве параметра.
    В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
    Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.

Old variant: package com.javarush.test.level22.lesson05.task02; */
public class ThreadsL2L05T3 {
    public static class Solution {
        
        public static void main(String[] args) throws TooShortStringException {
            System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
            System.out.println(getPartOfString("\t\t"));                    //
            System.out.println(getPartOfString("123\t123"));                //Exception
            System.out.println(getPartOfString(null));                      //Exception
        }
        
        public static String getPartOfString(String string) throws TooShortStringException {
            String ss = null;
            if (string == null) {
                throw new TooShortStringException();
            }
            if (string.equals("")) {
                throw new TooShortStringException();
            }

            int p1 = string.indexOf("\t");
            if (p1 == -1) {
                throw new TooShortStringException();
            }
            int p2 = string.indexOf("\t", p1 + 1);
            if (p2 == -1) {
                throw new TooShortStringException();
            }

            ss = string.substring(p1 + 1, p2);

            return ss;
        }

        public static class TooShortStringException extends Exception { }
    }
}
