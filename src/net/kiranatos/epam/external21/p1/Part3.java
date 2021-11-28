package net.kiranatos.epam.external21.p1;

public class Part3 {
    public static void main(String[] args) {
        if (0 < args.length)
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (args.length-1 != i) System.out.print(" ");
            }
    }    
}