package address_book_system.implimentation;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.exception.NameAlreadyExitsException;
import address_book_system.interfaces.Create;

import java.util.regex.Pattern;

import static address_book_system.main_operations.AllOperations.*;

public class CreateImpl implements Create {

    @Override
    public String enterPersonState() {
        String state;
        while (true) {
            System.out.println("Enter the Person State");
            state = sc.next();
            if (Pattern.matches("^[A-Z][A-Za-z]{1,20}$", state)) {
                return state;
            }
            System.out.println("Invalid state format! Enter state name starting with Capital letter. ex: Karnataka ");

        }
    }


    @Override
    public String enterPersonCity() {
        String city;
        while (true) {
            System.out.println("Enter the Person City");
            city = sc.next();
            if (Pattern.matches("^[A-Z][A-Za-z]{1,20}$", city)) {
                return city;
            }
            System.out.println("Invalid city format! Enter city name starting with Capital letter. ex: Bangalore");
        }
    }

    @Override
    public String enterPersonAddress() {
        String address;
        while (true) {
            System.out.println("Enter the Person Address");
            address = sc.next();
            if (Pattern.matches("^[A-Za-z0-9\\s,.'#-]{1,100}$", address)) {
                return address;
            }
            System.out.println("Invalid Address! " +
                    "Enter the address starting with capital letter. ex: 4th main road, HSR layout");
        }
    }

    @Override
    public String enterPersonEmail() {
        String email;
        while (true) {
            System.out.println("Enter the Person Email Address : ");
            email = sc.next();
            if (Pattern.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$", email)) {
                return email;
            }
            System.out.println("Invalid email! Please enter valid format email address. ex: arun02@gmail.com");

        }
    }

    @Override
    public String enterPersonZipCode() {
        String zipCode;
        while (true) {
            System.out.println("Enter the 6 number of Person Zip Code : ");
            zipCode = sc.next();
            if (Pattern.matches("[0-9]{6}", zipCode)) {
                return zipCode;
            }
            System.out.println("Invalid Zip Code! it must contain total 6 digit. ex: 654321");
        }
    }

    @Override
    public String enterPersonMobileNumber() {
        String mobileNumber;
        while (true) {
            System.out.println("Enter the Person mobile Number : ");
            mobileNumber = sc.next();
            if (Pattern.matches("^[9876][0-9]{9}", mobileNumber)) {
                return "+91 " + mobileNumber;
            }
            System.out.println("Invalid MobileNumber! it must start with a 9,8,7,6 any one of this number" +
                    "and contain total 10 digit. ex: 9876543210");
        }
    }

    @Override
    public String enterPersonLastName() {

        String lastName;
        while (true) {
            System.out.println("Enter the Person Last Name : ");
            lastName = sc.next();
            if (Pattern.matches("^[A-Z][a-z]{2,20}$", lastName)) {
                return lastName;
            }
            System.out.println("Invalid format! Last name must start with a capital letter and contain 2-20 alphabetic characters. ex: Gowda");
        }
    }

    @Override
    public String enterPersonFirstName() throws NameAlreadyExitsException {
        String firstName;
        while (true) {
            System.out.println("Enter the Person First Name : ");
            firstName = sc.next();
            if (!Pattern.matches("^[A-Z][a-z]{2,20}$", firstName)) {
                System.out.println("Invalid format! First name must start with a capital letter and contain 2-20 alphabetic characters. Example: Arun");
                continue;

            }
            if (newContact.checkNameIsPresent(firstName, contactDatabase)) {
                throw new NameAlreadyExitsException("First Name " + firstName + " is already present in the address book. ");
            } else {
                return firstName;
            }
        }
    }


    @Override
    public Person savePerson() throws NameAlreadyExitsException, InvalidFormatException {
        String firstName = enterPersonFirstName();
        String lastName = enterPersonLastName();
        String mobileNumber = enterPersonMobileNumber();
        String address = enterPersonAddress();
        String city = enterPersonCity();
        String state = enterPersonState();
        String zipCode = enterPersonZipCode();
        String email = enterPersonEmail();

        System.out.println("\nHey " + firstName + " " + lastName + " Your data has been successfully added to the address book.\n");
        return new Person(firstName, mobileNumber, lastName, address, city, state, email, zipCode);
    }
}
