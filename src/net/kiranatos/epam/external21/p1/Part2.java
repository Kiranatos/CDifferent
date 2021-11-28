package net.kiranatos.epam.external21.p1;

public class Part2 {
    public static void main(String[] args) {
        int sum = 0;
        
        for (String str: args) {
            try {
                sum += Integer.valueOf(str);                
            } catch (NumberFormatException e){ 
                java.util.logging.Logger.getLogger(Part2.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        }
        
        System.out.print(sum);
    }
}
