package net.kiranatos.softserve.sertf;

public class Task2 {
    private static char[] vowels = new char[]{'a','e','i','o','u','y'};
    public static String spoonerise(String phrase) {
        String wordOne = phrase.split(" ")[0];
        String wordTwo = phrase.split(" ")[1];
        char[] cArrOne = wordOne.toCharArray();
        char[] cArrTwo = wordTwo.toCharArray();
        String s1pre = "", s1syf = "", s2pre = "", s2syf = "";
        for (int i = 0; i < cArrOne.length; i++) {
            if (isVowel(cArrOne[i])) {
                s1syf = wordOne.substring(i, wordOne.length());
                break; 
            }
            s1pre = s1pre + cArrOne[i];
        }
        
        for (int i = 0; i < cArrTwo.length; i++) {
            if (isVowel(cArrTwo[i])) {
                s2syf = wordTwo.substring(i, wordTwo.length());
                break; 
            }
            s2pre = s2pre + cArrTwo[i];
        }
        
        return s2pre + s1syf + " " + s1pre + s2syf;
    }
    public static void main(String[] args) {
        System.out.println(spoonerise("history lecture"));
        System.out.println(spoonerise("loud noises"));
        System.out.println(spoonerise("chow mein"));
        System.out.println(spoonerise("angry birds!"));
    }
    
    private static boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) return true;
        }
        return false;
    }
}
