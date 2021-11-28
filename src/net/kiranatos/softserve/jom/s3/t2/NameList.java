package net.kiranatos.softserve.jom.s3.t2;

public class NameList implements Iterable<String> {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};
    
    public Iterator getIterator() {
        return new Iterator();
    }

    @Override
    public java.util.Iterator<String> iterator() {
        return new Iterator();
    }

    public class Iterator implements java.util.Iterator<String> {
        private int counter = 0;

        private Iterator() {        }
        public boolean hasNext() { return counter < names.length; }
        public String next() {            
            if (this.hasNext()) return names[counter++];
            else throw new java.util.NoSuchElementException();            
        }        
    }
    
    public static void main(String[] args) {
        NameList nl = new NameList();
        for (String s : nl) {
            System.out.println(s);
        }
    }
}

/*
Suppose we have the next class:
class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};
    public Iterator getIterator() {     return new Iterator();    }
}

Create public inner class named Iterator inside 
NameList class that correspond the next class diagram: 
            Iterator
        - counter: int = 0
        ___________________
        - Iterator()
        + hasNext(): boolean - Returns true if next element exist in the list, otherwise returns false
        + next(): String - Returns current element and add 1 to counter
*/