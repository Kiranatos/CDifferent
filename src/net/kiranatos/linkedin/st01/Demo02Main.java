package net.kiranatos.linkedin.st01;

public class Demo02Main {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("What is the output of this code?");
        if(count < 3) {
            count++;
            main(null);
        } else {
            return;
        }
        System.out.println("Hello World!");
        /*
        It will not compile.
        It will print "Hello World!" three times. [CORRECT]
        It will throw a runtime exception.
        It will run forever.
        */
    }
}
