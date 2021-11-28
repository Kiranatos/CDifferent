package net.kiranatos.javarush.q3threads.lvl2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Java Multithreading level 2, lection 9, task 2

Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
Требования:
    Метод getQuery должен принимать один параметр типа Map.
    Метод getQuery должен иметь тип возвращаемого значения String.
    Метод getQuery должен быть статическим.
    Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.

Old variant: package com.javarush.test.level22.lesson09.task02; */
public class ThreadsL2L09T2 {
    public static class Solution {
        public static void main(String[] args) { } // <- это в новой версии
        public static String getQuery(Map<String, String> params) { return null; } // <- это в новой версии
        
        public static StringBuilder getCondition(Map<String, String> params) {
            StringBuilder sb = null;
            Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = it.next();
                String k = pair.getKey();
                String v = pair.getValue();
                if ((k != null) && (v != null)) {
                    if (sb != null) {
                        sb.append(" and " + k + " = '" + v + "'");
                    } else {
                        sb = new StringBuilder(k + " = '" + v + "'");
                    }
                }
            }
            if (sb == null) { sb = new StringBuilder(); }
            return sb;
        }        
    }
}