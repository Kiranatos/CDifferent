package net.kiranatos.javarush.q3threads.lvl1;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* Java Multithreading level 1, lection 2, task 2

Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier

Old variant: package com.javarush.test.level21.lesson02.task02; */
public class ThreadsL1L02T2 {
    public static void main(String[] args) {
        int modifiersOfThisClass = ThreadsL1L02T2.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return (allModifiers&specificModifier)==specificModifier;
    }

    private static Method getMainMethod() {
        Method[] methods = ThreadsL1L02T2.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}