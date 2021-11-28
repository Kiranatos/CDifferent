package net.kiranatos.epam.external21.p1;

public class Part4 {
    public static void main(String[] args) {
        if (2 != args.length) System.out.println("<<Error1 no elem>>");
        int a = 0;
        int b = 0;
        try {
            a = Math.abs(Integer.valueOf(args[0]));
            b = Math.abs(Integer.valueOf(args[1]));
        } catch (NumberFormatException e){ 
            System.out.println("<<Error2 no elem>>");
        }
        
        int temp = 0;
        while (b != 0) {
            temp = a%b;
            a = b;
            b = temp;
        }
        System.out.print(a);    
    }
}