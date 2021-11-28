package net.kiranatos.softserve.jom.s3.t6;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook(5);
        System.out.println("Adding elements...");        
        System.out.println(addressBook.create("John", "Smith", "Bobryisk"));
        System.out.println(addressBook.create("Will", "Smith", "Palyanichencki village"));   
        System.out.println(addressBook.create("Avogadro", "Smith", "Leng plato"));   
        System.out.println(addressBook.create("Avogadro", "Mass", "Tokyo"));
        System.out.println(addressBook.create("Bill", "Smith", "Europe"));
        System.out.println(addressBook.create("Bill", "Smith", "Europe"));
        System.out.println(addressBook.create("Bill", "Smith", "Asia"));
        System.out.println(addressBook.create("Bill", "Polok", "Asia"));
        System.out.println(addressBook.create("Marina", "Knot", "Vegas"));
        System.out.println(addressBook.create("Ira", "Knot", "Vegas"));
        
        System.out.println("\nSize: " + addressBook.size());

        System.out.println("\nChecking Iterator:");
        for (String s : addressBook) {
            System.out.println(s);
        }

        System.out.println("\nLooking for address:");
        System.out.println("\tplace: " + addressBook.read("Bill", "Smith"));
        System.out.println("\tplace: " + addressBook.read("Bill", "AntiSmith"));        
        
        System.out.println("\nDeleting..." + addressBook.delete("Avogadro", "Mass"));        
        for (String s : addressBook) {
            System.out.println(s);
        }
        System.out.println("\nSize: " + addressBook.size());
        
        System.out.println("\nDeleting..." + addressBook.delete("John", "Smith"));        
        for (String s : addressBook) {
            System.out.println(s);
        }
        System.out.println("\nSize: " + addressBook.size());
        
        System.out.println("\nDeleting..." + addressBook.delete("Ira", "Knot"));        
        for (String s : addressBook) {
            System.out.println(s);
        }
        System.out.println("\nSize: " + addressBook.size());
        
        System.out.println("\nDeleting..." + addressBook.delete("Ira", "Knot"));        
        for (String s : addressBook) {
            System.out.println(s);
        }
        System.out.println("\nSize: " + addressBook.size());
        
        System.out.println("\nUpdating..." + addressBook.update("Danko", "Smith", "Klehovka hutor"));      
        System.out.println("\nUpdating..." + addressBook.update("Will", "Smith", "Klehovka hutor"));              
        System.out.println(addressBook.read("Will", "Smith"));

        System.out.println("\n Ascendance:");
        addressBook.sortedBy(SortOrder.ASC);        
        for (String s : addressBook) {
            System.out.println(s);
        }
        
        System.out.println("\n Descendant:");
        addressBook.sortedBy(SortOrder.DESC);        
        for (String s : addressBook) {
            System.out.println(s);
        }
        
        System.out.println("\n\n=============================\n");        
        /* Iterate across records inside the address book using "for-each" loop */
        String[] expected = {
            "First name: Karen, Last name: Davis, Address: Address #2",
            "First name: Steven, Last name: Taylor, Address: Address #3",
            "First name: Susan, Last name: Brown, Address: Address #4"};
        String[] expected2 = {
            "First name: Karen, Last name: Davis, Address: Address #2",
            "First name: Steven, Last name: Taylor, Address: Address #3",
            "First name: Susan, Last name: Brown, Address: Address #4"};
        
        String[] actual = new String[3];        
        AddressBook addressBook2 = new AddressBook(4);
        addressBook2.create("John", "Brown", "Address #1");
        addressBook2.create("Karen", "Davis", "Address #2");
        addressBook2.create("Steven", "Taylor", "Address #1");
        addressBook2.create("Susan", "Brown", "Address #4");
        
        addressBook2.update("Steven", "Taylor", "Address #3");
        addressBook2.delete("John", "Brown");
//        addressBook2.delete("Steven", "Taylor");
//        int counter = 0;
//        System.out.println("\n RESULT:");
//        for (Object record : addressBook2) {
//            actual[counter++] = record.toString();
//            System.out.println(record.toString());
//        }
//        System.out.println(Arrays.equals(expected, actual));
//        System.out.println(Arrays.equals(expected, expected2));
//        
//        for (int i = 0; i < 3; i++) {
//            System.out.println(" * " + expected[i].equals(actual[i]));            
//            System.out.println(expected[i]);
//            System.out.println(actual[i]);
//        }
        
    }
}

/*
        System.out.println("Delete: " + firstName + " : " + lastName);
        System.out.println("counter: " + counter);
        System.out.println("size =  " + this.size());
        System.out.println("lenght =  " + this.addressBook.length);
        for (String s : this) {
            System.out.println(s);
        }
System.out.println("FOUND " + addressBook[i].person.firstName + i);
System.out.println("MARTRIS: " +  tempArray[0]);

/* Iterate across records inside the address book using "for-each" loop */
// String[] expected = {"First name: Karen, Last name: Davis, Address: Address #2",
//         "First name: Steven, Last name: Taylor, Address: Address #3",
//         "First name: Susan, Last name: Brown, Address: Address #4"};
// String[] actual = new String[3];
// AddressBook addressBook = new AddressBook(4);
// addressBook.create("John", "Brown", "Address #1");
// addressBook.create("Karen", "Davis", "Address #2");
// addressBook.create("Steven", "Taylor", "Address #1");
// addressBook.create("Susan", "Brown", "Address #4");
// addressBook.update("Steven", "Taylor", "Address #3");
// addressBook.delete("John", "Brown");
// int counter = 0;
// for (Object record : addressBook)
//     actual[counter++] = record.toString();
// return Arrays.equals(expected, actual);
//iteratorTest()
