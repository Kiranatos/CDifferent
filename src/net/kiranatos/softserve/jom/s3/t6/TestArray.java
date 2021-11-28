package net.kiranatos.softserve.jom.s3.t6;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] source = {99, 1, 2, 3, 4, 5, 6, 7};
        int[] dest = new int[source.length];
        
        System.arraycopy(source, 0, dest, 1, 3);
        
        System.out.println(Arrays.toString(dest));
    }
}
