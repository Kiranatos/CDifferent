package net.kiranatos.javarush.q3threads.lvl2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Java Multithreading level 2, lection 9, task 3

Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
В файле не обязательно будет много слов.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.

Требования:
    Метод main должен считывать имя файла с клавиатуры.
    В классе Solution не должно быть статических полей.
    В методе getLine должен быть использован StringBuilder.
    Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
    Метод getLine не должен изменять переданные ему параметры (слова).
    Все слова переданные в метод getLine должны быть включены в результирующую строку.
    Вывод на экран должен соответствовать условию задачи.

Old variant: package com.javarush.test.level22.lesson09.task03; */
public class ThreadsL2L09T3 {
    public static class Solution {
        public static void main(String[] args) {
            StringBuilder str = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String sFile = reader.readLine();
                reader.close();

                BufferedReader readerFile = new BufferedReader(new FileReader(sFile));
                sFile = readerFile.readLine();
                while (sFile != null) {
                    str.append(sFile + " ");
                    sFile = readerFile.readLine();
                }
                readerFile.close();
            } catch (IOException e) {  }

            String[] sMtx = str.toString().trim().split(" ");
            
            StringBuilder result = getLine(sMtx);
            System.out.println(result.toString());
        }

        public static StringBuilder getLine(String... words) {
            if ((words.length == 0) || (words == null) || (words[0] == "")) { 
                return new StringBuilder(); 
            }

            List<String> list = new ArrayList<String>(Arrays.asList(words));

            Collections.sort(list);
            StringBuilder all = new StringBuilder(list.get(0));
            list.remove(0);

            while (!list.isEmpty()) {
                boolean identifier = false;

                for (int i = list.size() - 1; i >= 0; i--) {
                    char all_A = all.toString().toLowerCase().charAt(0);
                    char all_Z = all.toString().toLowerCase().charAt(all.length() - 1);

                    String newWord = list.get(i);
                    char letter1A = newWord.toLowerCase().charAt(0);
                    char letter1Z = newWord.toLowerCase().charAt(newWord.length() - 1);

                    if (all_Z == letter1A) {
                        all.append(" " + newWord);
                        list.remove(i);
                        identifier = true;
                    } else if (all_A == letter1Z) {
                        all = new StringBuilder(newWord + " ").append(all);
                        list.remove(i);
                        identifier = true;
                    }
                }

                if (!identifier) {
                    list = new ArrayList<String>(Arrays.asList(words));
                    Collections.shuffle(list);
                    all = new StringBuilder(list.get(0));
                    list.remove(0);
                }
            }
            return all;
        }
    }
}