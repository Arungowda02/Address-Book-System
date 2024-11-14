package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.exception.NotFoundException;

import java.util.LinkedHashMap;

import static address_book_system.interfaces.Operations.printWelcomeMessage;
import static address_book_system.main_operations.AllOperations.*;

public class OperationForRead {

    public static void sorting() {
        int optionForSort = sortContactDatabase.printOptionForShowingPersonsDetailsInSortForm();
        if (optionForSort == 1) {
            System.out.println("Showing Persons details sorting by Name : ");
            LinkedHashMap<String, Person> sortedByName =
                    sortContactDatabase.sortContactDatabaseByName(contactDatabase);
            sortedByName.entrySet().forEach(System.out::println);
        } else if (optionForSort == 2) {
            System.out.println("Showing Persons details sorting by City : ");
            LinkedHashMap<String, Person> sortedByCity =
                    sortContactDatabase.sortContactDatabaseByCity(contactDatabase);
            sortedByCity.entrySet().forEach(System.out::println);
        } else if (optionForSort == 3) {
            System.out.println("Showing Persons details sorting by State : ");
            LinkedHashMap<String, Person> sortedByState = sortContactDatabase.sortContactDatabaseByState(contactDatabase);
            sortedByState.entrySet().forEach(System.out::println);

        } else if (optionForSort == 4) {
            System.out.println("Showing Persons details sorting by Zip Code : ");
            LinkedHashMap<String, Person> sortedByZipCode = sortContactDatabase.sortContactDatabaseByZipCode(contactDatabase);
            sortedByZipCode.entrySet().forEach(System.out::println);
        }

    }

    public static void showPerson() throws NotFoundException, InvalidFormatException {
        System.out.println("\nSelect any below option to show Person details : ");
        int option = readByName.printOptionForShowingPersonsDetails();
        if (option == 1) {
            String firstName = updateContact.enterPersonFirstName();
            readByName.showPersonByName(firstName, contactDatabase);
        } else if (option == 2) {
            String city = newContact.enterPersonCity();
            readByCity.showPersonByCity(city, contactDatabase);
            countContact.countContactByCity(city, contactDatabase);
        } else if (option == 3) {
            String state = newContact.enterPersonState();
            readByState.showPersonByState(state, contactDatabase);
            countContact.countContactByState(state, contactDatabase);
        } else if (option == 4) {
            readByName.showPersonByFirstCharacterOfName(contactDatabase);

        } else if (option == 5) {
            readByName.showPersonByLastCharacterOfName(contactDatabase);
        } else if (option == 6) {
            sorting();
        } else if (option == 0) {
            crudOperation(printWelcomeMessage());
        }
    }

    public static void callOperationForRead() throws NotFoundException, InvalidFormatException {

        if (!contactDatabase.isEmpty()) {
            showPerson();
        } else {
            System.out.println("No Contact Found !!!".toUpperCase());
        }
    }

}
