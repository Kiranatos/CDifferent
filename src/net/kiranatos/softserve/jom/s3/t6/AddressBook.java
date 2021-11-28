package net.kiranatos.softserve.jom.s3.t6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class AddressBook  implements Iterable<String> {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }
    
    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);        
        if (Objects.nonNull( this.read(firstName, lastName)) ) { return false; }
        
        if (counter < addressBook.length) {
            addressBook[counter] = new NameAddressPair( person , address);
            counter++;
        }
        else {
            NameAddressPair[] tempArray = new NameAddressPair[addressBook.length * 2];
            System.arraycopy(addressBook, 0, tempArray, 0, counter);
            addressBook = tempArray;
            addressBook[counter] = new NameAddressPair( person , address);
            counter++;            
        }                
        return true;
    }
    
    public String read(String firstName, String lastName) { 
        NameAddressPair.Person pTemp = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (pTemp.equals(addressBook[i].person)) { return addressBook[i].address; }
        }
        return null;
    }    
    
    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person pTemp = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (pTemp.equals(addressBook[i].person)) { 
                addressBook[i].address = address;
                return true; 
            }            
        }
        return false;
    }
    
    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person pTemp = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (pTemp.equals(addressBook[i].person)) {    
                NameAddressPair[] tempArray = new NameAddressPair[counter-1];
                System.arraycopy(addressBook, 0, tempArray, 0, i);                
                System.arraycopy(addressBook, i+1, tempArray, i, counter-i-1);
                counter--;
                addressBook = tempArray;
                
                return true; 
            }            
        }
        return false;
    }
    
    public int size() { return counter; }
    
    public void sortedBy(SortOrder order) {
        int coeficient;
        if (SortOrder.ASC.equals(order)) { 
            coeficient = 1;
        } else { coeficient = -1; }
        
        NameAddressPair[] tempArray = new NameAddressPair[counter];
        System.arraycopy(addressBook, 0, tempArray, 0, counter);
        addressBook = tempArray;
        
        Arrays.sort(addressBook,  new Comparator<NameAddressPair>(){
            @Override
            public int compare(NameAddressPair one, NameAddressPair two) {                 
                int compare = one.person.firstName.compareTo(two.person.firstName);
                if (compare != 0) { return coeficient * compare; }
                else { return coeficient * one.person.lastName.compareTo(two.person.lastName); }
            }});        
    }
    
    @Override
    public Iterator<String> iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements java.util.Iterator<String> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < AddressBook.this.counter;
        }

        @Override
        public String next() {            
            if (this.hasNext()) {
                String result = String.format("First name: %s, Last name: %s, Address: %s",
                        addressBook[this.counter].person.firstName, 
                        addressBook[this.counter].person.lastName, 
                        addressBook[this.counter].address).intern();
                this.counter++;                
                return result; 
            } else throw new java.util.NoSuchElementException();
        }
    }
    
    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 13 * hash + Objects.hashCode(this.person.firstName);
            hash = 13 * hash + Objects.hashCode(this.person.lastName);            
            hash = 71 * hash + Objects.hashCode(this.address);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            
            final Person other = ((NameAddressPair) obj).person;
            if (!Objects.equals(this.person.firstName, other.firstName) && 
                    !Objects.equals(this.person.lastName, other.lastName) ) {
                return false;
            }
            
            return true;
        }
        
        private static final class Person {
            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public int hashCode() {
                int hash = 7;
                hash = 41 * hash + Objects.hashCode(this.firstName);
                hash = 41 * hash + Objects.hashCode(this.lastName);
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Person other = (Person) obj;
                if (!Objects.equals(this.firstName, other.firstName)) {
                    return false;
                }
                if (!Objects.equals(this.lastName, other.lastName)) {
                    return false;
                }
                return true;
            }
        }
    }     
}

enum SortOrder {
    ASC, DESC; 
}
