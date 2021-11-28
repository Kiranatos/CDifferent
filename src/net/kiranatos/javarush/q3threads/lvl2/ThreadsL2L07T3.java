package net.kiranatos.javarush.q3threads.lvl2;

import java.util.Date;

/* Java Multithreading level 2, lection 7, task 3

Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
31:10:13 15:59:59
Требования:
    Метод getFormattedString должен быть публичным.
    Метод getFormattedString должен быть статическим.
    Вывод на экран должен соответствовать условию задачи.
    Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.

Old variant: package com.javarush.test.level22.lesson07.task03; */
public class ThreadsL2L07T3 {
    public static class Solution {
        public static void main(String[] args) {
            Date date = new Date();
            System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
            //должен быть вывод аналогичный следующему
            //31:10:13 15:59:59 - dd:MM:yy hh:mm:ss
        }

        public static String getFormattedString() {
            return "%td:%tm:%ty %tH:%tM:%tS";
        }
    }
}
