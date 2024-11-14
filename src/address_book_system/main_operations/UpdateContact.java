package address_book_system.main_operations;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.interfaces.Update;

import java.util.Map;
import java.util.regex.Pattern;

import static address_book_system.main_operations.AllOperations.*;

public class UpdateContact implements Update {

    public String enterPersonFirstName() {

        String firstName;
        while (true) {
            System.out.println("Enter the Person First Name : ");
            firstName = sc.next();
            if (Pattern.matches("^[A-Z][a-z]{2,20}$", firstName)) {
                return firstName;
            }
            System.out.println("Invalid format! First name must start with a capital letter and contain 2-20 alphabetic characters. ex: Arun");
        }
    }

    @Override
    public Person updatePersonByName(String name, Map<String, Person> contactDatabase) throws InvalidFormatException {

        String lastName = newContact.enterPersonLastName();
        person.setLastName(lastName);

        String mobileNumber = newContact.enterPersonMobileNumber();
        String address = newContact.enterPersonAddress();
        String city = newContact.enterPersonCity();
        String state = newContact.enterPersonState();
        String zipCode = newContact.enterPersonZipCode();
        String email = newContact.enterPersonEmail();
        System.out.println("\nHey " + name + " " + lastName + " Your data has been successfully updated in the address book." +
                "\n-------------------------------------");
        return new Person(name, mobileNumber, lastName, address, city, state, email, zipCode);

    }
}
