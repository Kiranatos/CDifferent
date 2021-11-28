package net.kiranatos.softserve.jom.s2t.q18;

// 18

class A {    
    public void m1() { 
        System.out.print(" A_m1"); }
    public void m2() { 
        System.out.print(" A_m2");       
    }
}
class B extends A {
    public void m1() { 
        System.out.print(" B_m1");
    }
    public void m2() { 
        System.out.print(" B_m2");
        m1();
    } 
}

public class Appl2 {
    public static void main(String[] args) {
        A a = new B();
        a.m2();
        a.m1();
    }    
}
    
