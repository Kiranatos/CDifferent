package net.kiranatos;

//public class Test2 {
//    public static void main(String[] args) {
//        System.out.println("tt");
//    }
//}
import java.util.*;

public class Test2 {

    public static int nthSmallest(int[] arr, int n) {
        if (n > arr.length) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int k = arr[j];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == n) {
                return arr[i];
            }
        }
return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthSmallest(new int[]{1, 3, 5, 7}, 1));
        System.out.println(nthSmallest(new int[]{1, 3, 5, 7}, 3));
        System.out.println(nthSmallest(new int[]{1, 3, 5, 7}, 5));
        System.out.println(nthSmallest(new int[]{7, 3, 5, 1}, 2));
    }
}
