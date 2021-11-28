package net.kiranatos.softserve.jom.s8.t1;

import java.util.function.BinaryOperator;

public class Task1 {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        Runnable r = new ParallelCalculator(multiply, 6, 6);
        Thread t = new Thread(r);
        t.start();
    }
}

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

/* Create ParallelCalculator class that will be able to execute an operation in parallel thread.

Use the implementation of Runnable interface for this.

Constructor of ParallelCalculator should take 3 parameters: 
    The BinaryOperator<Integer> to define an operation that will be executed, 
    The operand1 of type int and operand2 of type int.

The ParallelCalculator class should have not private result field of type int 
where the result of the operation will be written when it's executed. */