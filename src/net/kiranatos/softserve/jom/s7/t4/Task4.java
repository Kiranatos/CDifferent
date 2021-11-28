package net.kiranatos.softserve.jom.s7.t4;

/*
https://mkyong.com/java/java-convert-string-to-binary/
https://annimon.com/article/2778
*/

public class Task4 {
    public static void main(String[] args) {
        System.out.println(readFile("delete.txt"));
        System.out.println(Integer.parseInt("1001000", 2));
        System.out.println(Character.toString(72));
        System.out.println("************");
        String st = "100100011001011101100110110011011110100001";
        StringBuffer sb = new StringBuffer(st);
        for (int i = st.length(); i > 0; i = i-7) {
            sb.insert(i-7, " ");
        }
        //System.out.println(sb.insert(sb.length()-7, " "));
        System.out.println(sb.toString());
        
    }

    public static String readFile(String filename) {
        String string = "ERORR";
        try (java.io.BufferedReader readerFile = new java.io.BufferedReader(new java.io.FileReader(filename))){
            string = readerFile.readLine();            
        } catch (java.io.IOException ex) {}  
        
        StringBuffer sb = new StringBuffer(string);
        for (int i = string.length(); i > 0; i = i-7) {
            sb.insert(i-7, " ");
        }
        String raw = java.util.Arrays.stream(sb.toString().trim().split(" "))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(java.util.stream.Collectors.joining());
        
        return raw;
    }
}

/*
Create the method readFile(String filename) that read from file a sequence of 
bytes in binary format from previous task and return ridable string.

For example, the sequence of 7-bit bytes
100100011001011101100110110011011110100001

should be represented as text fragment:
Hello!
 */
