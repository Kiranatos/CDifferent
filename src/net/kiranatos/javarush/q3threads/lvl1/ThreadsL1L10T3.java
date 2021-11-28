package net.kiranatos.javarush.q3threads.lvl1;

/* Java Multithreading level 1, lection 10, task 3 
(ЭТА ЗАДАЧА НА САЙТЕ https://javarush.ru, вместо ThreadsL1L10T3Deleted. Считается решённой, но кода к ней у себя я не нашёл)

AutoCloseable и try-with-resources
В классе FakeConnection реализуй интерфейс AutoCloseable, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Closing database connection..."
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().
Вывод на экран должен быть следующим:
Establishing database connection...
Entering body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...
Обрати внимание на то, что ресурсы были освобождены автоматически несмотря на исключение брошенное методом unsupportedOperation.
Требования:
    Класс FakeConnection должен поддерживать интерфейс AutoCloseable.    
    Метод close класса FakeConnection должен выводить на экран фразу "Closing database connection...".
    В методе main класса Solution должны быть вызваны методы usefulOperation и unsupportedOperation у объекта класса FakeConnection.
    Вывод на экран должен соответствовать условию задачи.
    Метод close класса FakeConnection не должен быть вызван явно.

Old variant: package com.javarush.test.level21.lesson10.task03; */
public class ThreadsL1L10T3 {
    /*
    public class Solution {
        public static void main(String[] args) {
            DBConnectionManager dbConnectionManager = new DBConnectionManager();
            try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
                System.out.println("Entering body of try block.");
            } catch (Exception e) {
            }
        }
    }

    public class DBConnectionManager {
        public FakeConnection getFakeConnection() {
            return new FakeConnection();
        }
    }

    public class FakeConnection {
        public FakeConnection() {
            System.out.println("Establishing database connection...");
        }

        public void unsupportedOperation() {
            System.out.println("Operation is not supported yet!");
            throw new RuntimeException("UnsupportedOperation!");
        }

        public void usefulOperation() {
            System.out.println("Executing useful operation.");
        }
    }
    */
}
