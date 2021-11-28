package net.kiranatos.javarush.q3threads.lvl1;

import java.util.LinkedHashMap;
import java.util.Map;

/* Java Multithreading level 1, lection 8, task 1

Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.

Old variant: package com.javarush.test.level21.lesson08.task01; */

public class ThreadsL1L08T1 {
    public static class Solution implements Cloneable {
        protected Map<String, User> users = new LinkedHashMap();
        
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.users.put("Hubert", new User(172, "Hubert"));
            solution.users.put("Zapp", new User(41, "Zapp"));
            Solution clone = null;
            try {
                clone = solution.clone();
                System.out.println(solution);
                System.out.println(clone);

                System.out.println(solution.users);
                System.out.println(clone.users);

            } catch (CloneNotSupportedException e) {
                e.printStackTrace(System.err);
            }
        }

        @Override
        public Solution clone() throws CloneNotSupportedException {
            Map<String, User> users = new LinkedHashMap();
            for (Map.Entry<String, User> old : this.users.entrySet()) {
                User oldUser = (User) old.getValue().clone();
                users.put(old.getKey(), oldUser);
            }
            Solution sol1 = new Solution();
            sol1.users.putAll(users);
            return sol1;
        }        

        public static class User implements Cloneable {
            int age;
            String name;

            public User(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            protected User clone() throws CloneNotSupportedException {
                return (User) new User(this.age, this.name);
            }
        }
    }
}
