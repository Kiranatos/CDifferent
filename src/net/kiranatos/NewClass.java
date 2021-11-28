package net.kiranatos;

public class NewClass {
    static String name;
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("ffff");
        System.out.println(p.getName());
    }
}

class Person{
    private String name;

//    public Person(String name) {
//        this.name = name;
//    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null)
        name = name;
    }
    
}
