package net.kiranatos.epam.external21.p1;

public class Part5 {
    public static void main(String[] args) {        
        int number = 0;
        int sum = 0;        
        
        if ((args != null) && (0 < args.length) && (java.util.regex.Pattern.matches("[0-9]+", args[0]))) {
            try {
                number = Integer.valueOf(args[0]);                
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
                java.util.logging.Logger.getLogger(Part5.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
        
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        
        System.out.print(sum);    
    }
}
