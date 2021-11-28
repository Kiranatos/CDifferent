package net.kiranatos.epam.external21.p1;

public class Part7 {
    public static void main(String[] args) {
        System.out.println("A ==> 1 ==> A");
        System.out.println("B ==> 2 ==> B");
        System.out.println("Z ==> 26 ==> Z");
        System.out.println("AA ==> 27 ==> AA");
        System.out.println("AZ ==> 52 ==> AZ");
        System.out.println("BA ==> 53 ==> BA");
        System.out.println("ZZ ==> 702 ==> ZZ");
        System.out.println("AAA ==> 703 ==> AAA");
        //************************************************************************
        String arrow = " ==> ";
        System.out.println("A"+arrow+str2int("A")+arrow+int2str(1));
        System.out.println("B"+arrow+str2int("B")+arrow+int2str(2));
        System.out.println("Z"+arrow+str2int("Z")+arrow+int2str(26));
        System.out.println("AA"+arrow+str2int("AA")+arrow+int2str(27));
        System.out.println("AZ"+arrow+str2int("AZ")+arrow+int2str(52));
        System.out.println("BA"+arrow+str2int("BA")+arrow+int2str(53));
        System.out.println("ZZ"+arrow+str2int("ZZ")+arrow+int2str(702));
        System.out.println("AAA"+arrow+str2int("AAA")+arrow+int2str(703));
        //************************************************************************
        String formatStr = "%s ==> %d ==> %s";
        
        System.out.println(String.format(formatStr, "A", str2int("A"), int2str(1)));
        System.out.println(String.format(formatStr, "B", str2int("B"), int2str(2)));
        System.out.println(String.format(formatStr, "Z", str2int("Z"), int2str(26)));
        System.out.println(String.format(formatStr, "AA", str2int("AA"), int2str(27)));
        System.out.println(String.format(formatStr, "AZ", str2int("AZ"), int2str(52)));
        System.out.println(String.format(formatStr, "BA", str2int("BA"), int2str(53)));
        System.out.println(String.format(formatStr, "ZZ", str2int("ZZ"), int2str(702)));
        System.out.println(String.format(formatStr, "AAA", str2int("AAA"), int2str(703)));
    }
    
    public static int str2int(String number) {
        int result = 0; 
        for (int i = 0; i < number.length(); i++) { 
            result *= 26; 
            result += number.toUpperCase().charAt(i) - 'A' + 1;
        }
        return result; 
    }
    
    public static String int2str(int number) {
         int a = (number - 1) %26;
         String str = String.valueOf((char)(65 + a));
         int b = (number-1)/26;
         if (b > 0) return (int2str(b)) + str;
         else return str;
    }
    
    public static String rightColumn(String number) {        
        return int2str(str2int(number.toUpperCase())+1);
    }
}
