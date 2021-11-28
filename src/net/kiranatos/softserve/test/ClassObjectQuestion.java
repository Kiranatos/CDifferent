package net.kiranatos.softserve.test;

public class ClassObjectQuestion {

    public int x = 1;
    public int y = 2;

    public ClassObjectQuestion func(ClassObjectQuestion obj) {
        ClassObjectQuestion coq3 = new ClassObjectQuestion();
        coq3 = obj;
        coq3.x = obj.x++ + ++obj.y;
        obj.y = obj.y;
        return coq3;
    }

    public static void main(String[] args) {
        ClassObjectQuestion coq1 = new ClassObjectQuestion();
        ClassObjectQuestion coq2 = coq1.func(coq1);
        System.out.println("coql.x = " + coq1.x + ", coql.y " + coq1.y);
        System.out.println("coq2.x = " + coq2.x + ", coq2.y " + coq2.y);
    }
}
