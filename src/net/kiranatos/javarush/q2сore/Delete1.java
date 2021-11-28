package net.kiranatos.javarush.q2сore;

public class Delete1 {
    public static void main(String[] args) {
        boolean a = true, b = false;
        if (test1() || test2()) System.out.println("if 1");        
        System.out.println("***********************");
        int c = 1, d = 2; 
        System.out.println(c | d);
        System.out.println(~c);
        System.out.println(105 & 26);
        System.out.println(105 ^ 26);
        System.out.println(~105);
        System.out.println("***********************");
        System.out.println(a | b);
        System.out.println(!b);
        System.out.println(a & b);
        System.out.println(a ^ b);
        
        
    }
    
    private static boolean test1() {
        System.out.println("test 1");
        return true;
    }
    
    private static boolean test2() {
        System.out.println("test 2");
        return false;
    }
}
