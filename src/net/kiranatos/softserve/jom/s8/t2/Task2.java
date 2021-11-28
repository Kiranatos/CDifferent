package net.kiranatos.softserve.jom.s8.t2;

import java.util.function.BinaryOperator;

public class Task2 {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        Runnable r = new ParallelCalculator(multiply, 6, 6);
        Thread t = new Thread(r);
        t.start();

        System.out.println(Accountant.sum(5, 7));
    }
}

class Accountant {
    public static int sum(int x, int y) {                
        ParallelCalculator calculator = new ParallelCalculator(Integer::sum, x, y);
        Thread t = new Thread(calculator);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calculator.result;        
    }
}

/*
Suppose, you have class ParallelCalculator that is able to execute an operation 
in separate thread. It uses an implementation of Runnable interface for this.

You need to create Accountant class with a static sum(...) method that takes 
two parameters of type int and returns their sum. Use ParallelCalculator for this. 
The sum(...) method doesn't throw any checked exceptions.

The sum must be evaluated in a separate thread (please, do not call run() method 
of ParallelCalculator. Use start() method on object of type Thread).
Using Thread.sleep() method is unwelcomed in this task.
*/

class ParallelCalculator implements Runnable {
    private BinaryOperator<Integer> operation;
    private int operand1;
    private int operand2;
    public int result = 0;

    public ParallelCalculator(BinaryOperator<Integer> operation, int operand1, int operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    
    @Override
    public void run() {
        result = operation.apply(operand1, operand2);
    }
}