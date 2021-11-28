package net.kiranatos.epam.external21.p1;

public class Part6 {
    public static void main(String[] args) {        
        
        if ((args != null) && (args.length!=0)) {
            int value = 0;
            try {
                value = Math.abs(Integer.valueOf(args[0]));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){ 
                java.util.logging.Logger.getLogger(Part6.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }            
            
            System.out.print(arrayToString(createArray(value)));
        }
        
    }
    
    private static String arrayToString(int[] simple) {
        StringBuilder sb = new StringBuilder();
        for (int e : simple) {
            sb.append(e).append(" ");
        }
        return sb.toString().trim();
    }
    
    private static int[] createArray(int value) {
        int[] simple = new int[value];
        int index = 2;
        for (int i = 0; i < simple.length; i++) {
            while (true) {
                if (checkSimple(index)) { 
                    simple[i] = index++;
                    break;
                }
                index++;
            }
        }
        return simple;
    }

private static boolean checkSimple(int i) {
        if (i<=1) return false;
        else if (i <=3) return true;
        else if (i%2==0 || i %3 ==0) return false;
        int n = 5;
        while (n*n <= i){
            if (i % n ==0 || i % (n+2) == 0)
                return false;
            n=n+6;
        }
        return true;
    }    
}
