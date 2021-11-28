package net.kiranatos.javarush.q3threads.lvl1;

/* Java Multithreading level 1, lection 8, task 2

Клонирование растений
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.

Old variant: package com.javarush.test.level21.lesson08.task02; */

public class ThreadsL1L08T2 {
    public static class Solution {
        public static void main(String[] args) {
            Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
            Tree clone = null;
            try {
                clone = tree.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            System.out.println(tree);
            System.out.println(clone);

            System.out.println(tree.branches);
            System.out.println(clone.branches);
        }

        public static class Plant {
            private String name;
            public Plant(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        public static class Tree extends Plant implements Cloneable {
            private String[] branches;
            public Tree(String name, String[] branches) {
                super(name);
                this.branches = branches;
            }

            public String[] getBranches() {
                return branches;
            }

            @Override
            protected Tree clone() throws CloneNotSupportedException {
                if (branches == null) {
                    return new Tree(super.getName(), null);
                }

                String[] inB = new String[branches.length];
                for (int i = 0; i < branches.length; i++) {
                    inB[i] = branches[i];
                }
                
                Tree inside = new Tree(super.getName(), inB);

                return inside;
            }
        }
    }
}
