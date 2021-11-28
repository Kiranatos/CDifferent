package net.kiranatos.softserve.jom.s7.t3;

// https://mkyong.com/java/java-convert-string-to-binary/

public class Task3 {
    public static void main(String[] args) {
        String input = "Hello!";
        writeFile("delete.txt", input);
    }

    public static void writeFile(String filename, String text) {
        StringBuilder result = new StringBuilder();
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            result.append(String.format("%7s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(new java.io.File(filename));
            fileWriter.write(result.toString());
            fileWriter.close();
        } catch (java.io.IOException ex) {     }
    }
}

/*
Create the method writeFile(String filename, String text) that 
write the text to file as sequence of bytes in binary format.

For example, the text fragment
Hello!

should be represented in the file as a sequence of 7-bit bytes
without spaces between them:
100100011001011101100110110011011110100001

If less than 7 bits are required to represent the character then 
add to binary sequence leading zeros '0'. 
*/
