package net.kiranatos.javarush.q3threads.lvl2;

/* Java Multithreading level 2, lection 7, task 2

МНЕ нравится курс JavaRush
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.
Должен быть вывод:
МНЕ нравится курс JavaRush
Требования:
    Метод getFormattedString должен быть публичным.
    Метод getFormattedString должен быть статическим.
    Вывод на экран должен соответствовать условию задачи.
    Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.

Old variant: package com.javarush.test.level22.lesson07.task02; */
public class ThreadsL2L07T2 {
    public static class Solution {
        public static void main(String[] args) {
            System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
            //должен быть вывод
            //"МНЕ нравится курс JavaRush"
        }

        public static String getFormattedString() {
            return "%3$S %4$s %2$s %1$s";
        }
    }
}
