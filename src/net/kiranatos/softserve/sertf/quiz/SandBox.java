package net.kiranatos.softserve.sertf.quiz;

import java.util.*;

public class SandBox {

    public static void main(String[] args) {
        Optional<String> opt1 = Optional.empty(); // 1
        //Optional<String> opt2 = Optional.of(null); // 2
        Optional<String> opt3 = Optional.ofNullable(null); // 3 
        
        System.out.println(opt1.isPresent());
        //System.out.println(opt2.isPresent());
        System.out.println(opt3.isPresent());
        
        System.out.println("totot".contains("tott"));
    }

}

/*
class A {
    protected int i;
    A(int i) { this.i = i; }
}

class Z { }
class C extends A {

    public C() {
        super(10);
    }
 }
class B extends A {
    B(int i) { 
        //super(i);
        System.out.println("i = " + i); } 
}
class D { D() { } }
 */
