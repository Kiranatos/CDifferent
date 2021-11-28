package net.kiranatos.javarush.q3threads.lvl2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Java Multithreading level 2, lection 9, task 1

Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот
Требования:
    Метод main должен считывать имя файла с клавиатуры.
    В методе main должен быть использован StringBuilder.
    В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять эти методы нельзя.
    В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
    Список result должен быть заполнен корректными парами согласно условию задачи.

Old variant: package com.javarush.test.level22.lesson09.task01; */
public class ThreadsL2L09T1 {
    public static class Solution {
        public static List<Pair> result = new LinkedList<>();
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sFile = reader.readLine();
            reader.close();

            BufferedReader readerFile = new BufferedReader(new FileReader(sFile));
            sFile = readerFile.readLine();
            StringBuilder str = new StringBuilder();
            while (sFile != null) {
                str.append(sFile + " ");
                sFile = readerFile.readLine();
            }
            readerFile.close();

            String[] sMtx = str.toString().split(" ");

            for (int i = 0; i < sMtx.length - 1; i++) {
                for (int j = i + 1; j < sMtx.length; j++) {
                    if (sMtx[j].equals(new StringBuilder(sMtx[i]).reverse().toString())) {
                        Pair r = new Pair();
                        r.first = sMtx[i];
                        r.second = sMtx[j];
                        result.add(r);
                    }
                }
            }        
        }

        public static class Pair {
            String first;
            String second;
            @Override
            public String toString() {
                return first == null && second == null ? ""
                        : first == null && second != null ? second
                                : second == null && first != null ? first
                                        : first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
            }
        }
    }
}
