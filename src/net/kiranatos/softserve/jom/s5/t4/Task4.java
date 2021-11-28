package net.kiranatos.softserve.jom.s5.t4;

import java.util.Objects;

public class Task4 {
    public static void main(String[] args) {
        Person per1 = Person.buildPerson("Suzukaze", "Aoba", "0123456789");
        System.out.println(per1);
        Person per2 = Person.buildPerson("Yagami", "Kou", "0123456789");
        System.out.println(per2);
        Person per3 = Person.buildPerson("Ahagon", "Umiko", "0123456789");
        System.out.println(per3);
        Person per4 = Person.buildPerson("Hazuki", "Shizuku", "0125688202");
        System.out.println(per4);
    }
}
/*
Create class Person with private fields firstName,  lastName, idCode. 
Create two classes inherited from RuntimeException: NameException and CodeException. 
NameException will be thrown if the first name or last name is invalid 
(doesn't start from uppercase or contains not only letters and symbols "-" and " "). 
CodeException will be thrown if idCode is invalid (valid idCode contains exactly 10 digits). 
In class Person create setters methods that throw NameException or CodeException 
if appropriate arguments are not valid. 
Create static method buildPerson(String firstName, String lastName, String idCode) 
that returns Person if all arguments are valid otherwise 
it thrown IllegalArgumentException with message about all invalid arguments.  
Override method toString() for Person class that returns representation of Person in form: 
firstName lastName: idCode. Override equals and hashCode methods for Person class.

For example
Person p = new Person(); 
p.setFirstName("joe") throw NameException with message 
“Incorrect value joe for firstName (should start from upper case and contains only alphabetic characters and -, _)” 
p.setIdCode("2") throw CodeException with message 
"Incorrect value 2 for code (should contains exactly 10 digits)"
Person.buildPerson("Joe", "KlarK2", "AS-2") throw IllegalArgumentException with message 
"Incorrect value KlarK2 for lastName (should start from upper case and contains only alphabetic characters and -, _); Incorrect value AS-2 for code (should contains exactly 10 digits)"
*/
class Person {
    private String firstName;
    private String lastName;
    private String idCode;
    private final String NAME_EXCEPTION_MESSAGE = "Incorrect value %s (should start from upper case and contains only alphabetic characters and symbols -, _)";
    private final String CODE_EXCEPTION_MESSAGE = "Incorrect value %s for code (should contains exactly 10 digits)";
    private final String NAME_REGEX = "[A-Z][A-Za-z-\\s]*";
    private final String CODE_REGEX = "\\d{10}";
    
    
    public static Person buildPerson(String firstName, String lastName, String idCode) {        
        Person person = new Person();
        StringBuilder sbErrors = new StringBuilder();
        
        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            sbErrors.append(e.getMessage());
        }
        
        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            sbErrors.append("; ").append(e.getMessage());
        }
        
        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            sbErrors.append("; ").append(e.getMessage());
        }
        
        if (sbErrors.length() > 0) throw new IllegalArgumentException(sbErrors.toString());
        
        return person;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches(NAME_REGEX))
            this.firstName = firstName;
        else throw new NameException(String.format(NAME_EXCEPTION_MESSAGE, firstName + " for firstName" ));
    }

    public void setLastName(String lastName) {
        if (lastName.matches(NAME_REGEX))
            this.lastName = lastName;
        else throw new NameException(String.format(NAME_EXCEPTION_MESSAGE, lastName + " for lastName" ));
    }

    public void setIdCode(String idCode) {
        if (idCode.matches(CODE_REGEX))
            this.idCode = idCode;
        else throw new CodeException(String.format(CODE_EXCEPTION_MESSAGE, idCode));
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", firstName, lastName, idCode);
    }    
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.firstName);
        hash = 61 * hash + Objects.hashCode(this.lastName);
        hash = 61 * hash + Objects.hashCode(this.idCode);
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
        if ((!Objects.equals(this.firstName, other.firstName)) ||
                (!Objects.equals(this.lastName, other.lastName)) ||
                (!Objects.equals(this.idCode, other.idCode))) {
            return false;
        }
        return true;
    }
}
class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}