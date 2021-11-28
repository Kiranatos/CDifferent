package net.kiranatos;

public class Main {
//    public long operation(int... nums){
//        return nums[0] + nums[1];
//    }
//    public long operation(long num1, long num2){
//        return num1-num2;
//    }
//    public static void main(String[] args) {
//        Main app = new Main();
//        long reault = app.operation(5,3);
//        System.out.println(reault);
//    }
    public static void main(String[] args) {
        AA aaa = new AA();
        AA aab = new BB();
        BB abb = new BB();
        System.out.println(aaa instanceof AA);
        System.out.println(aab instanceof AA);
        System.out.println(abb instanceof AA);
    }
}


class AA {}
class BB extends AA{}