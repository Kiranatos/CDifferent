package net.kiranatos.softserve.jom.s3.t3;

public class Task3 { 
    public static void execute(int a, int b, Strategy strategy){
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        Strategy strategyLabmda = (x,y)-> x+y;
        execute(3, 2, (x,y)-> x+y);        
        addAtoB(3, 2);
    }
    
    public static void addAtoB(int a, int b) {
        execute(a, b, (x,y)-> x+y);       
//        execute(a, b, Integer::sum);
    }
    
    public static void subtractBfromA(int a, int b) {    
        execute(a, b, (x,y)-> x-y);
    }
    
    public static void multiplyAbyB(int a, int b) {    
        execute(a, b, (x,y)-> x*y);
//        execute(a, b, Math::multiplyFull);
    }
    
    public static void divideAbyB(int a, int b) {    
        execute(a, b, (x,y)-> x/y);
    }
}

interface Strategy {
    double doOperation(int a, int b);
}
/*
Suppose we have execute method with next signature:
    public static void execute(int a, int b, Strategy strategy){
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }
where the Strategy is the next interface :
interface Strategy {
    double doOperation(int a, int b);
}
Using anonymous classes concept, call the execute method 
4 times with different strategy 
(override method doOperation from Strategy interface):
    1. Add a to b   \\   (a + b)
    2. Subtract b from a   \\   (a - b)
    3. Multiply a by b   \\   (a * b)
    4. Divide a by b   \\   (a / b)
*/


