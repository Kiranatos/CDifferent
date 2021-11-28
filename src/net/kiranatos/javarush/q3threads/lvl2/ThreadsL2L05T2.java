package net.kiranatos.javarush.q3threads.lvl2;

/* Java Multithreading level 2, lection 5, task 2

Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
    Пример: "JavaRush - лучший сервис обучения Java."
    Результат: "- лучший сервис обучения"
    Пример: "Амиго и Диего лучшие друзья!"
    Результат: "и Диего лучшие друзья!"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
Требования:
    Класс TooShortStringException должен быть потомком класса RuntimeException.
    Метод getPartOfString должен принимать строку в качестве параметра.
    В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
    Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.

Old variant: package com.javarush.test.level22.lesson05.task01; */
public class ThreadsL2L05T2 {
    public static class Solution {
        public static void main(String[] args) throws TooShortStringException {
            String str = "JavaRush - лучший сервис обучения Java.";
            System.out.println(getPartOfString(str));

            str = "     ";
            System.out.println(getPartOfString(str));
        }
        
        public static String getPartOfString(String string) throws TooShortStringException {
            String str = null;
            if (string == null) { throw new TooShortStringException(); }
            int p1 = string.indexOf(" ");
            if (p1 == -1)       { throw new TooShortStringException(); }

            int p2 = p1;
            int i = 1;
            while (i != 4) {
                p2 = string.indexOf(" ", p2 + 1);
                i++;
                if (p2 == -1)   { throw new TooShortStringException(); }
            }

            if (p2 == string.length() - 1) { throw new TooShortStringException(); }

            int p3 = string.indexOf(" ", p2 + 1);

            if (p3 != -1) {
                str = string.substring(p1 + 1, p3);
            } else {
                str = string.substring(p1 + 1, string.length() - 1);
            }

            return str;
        }

        public static class TooShortStringException extends Exception {  }        
    }
}
