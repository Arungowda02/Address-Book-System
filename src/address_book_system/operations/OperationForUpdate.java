package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.exception.NotFoundException;
import address_book_system.main_operations.AllOperations;

import static address_book_system.main_operations.AllOperations.*;

public class OperationForUpdate {
    public static void callOperationForUpdate() throws NotFoundException, InvalidFormatException {
        if (!contactDatabase.isEmpty()) {
            String firstName = updateContact.enterPersonFirstName();

            if (newContact.checkNameIsPresent(firstName, contactDatabase)) {
                System.out.println(firstName + " your old data is : ");
                readByName.showPersonByName(firstName, contactDatabase);
                System.out.println("Update your details ");
                Person updatePerson = AllOperations.updateContact.updatePersonByName(firstName, contactDatabase);

                contactDatabase.put(firstName, updatePerson);

            } else {
                throw new NotFoundException("Oops! The Person First Name " + firstName + " is not present in the Address Book.\\n\\n");
            }
        } else {
            System.out.println("No Contact Found !!!".toUpperCase());
        }
    }
}
