package address_book_system.main_operations;

import address_book_system.entity.Person;
import address_book_system.exception.NotFoundException;
import address_book_system.interfaces.Delete;

import java.util.Map;

import static address_book_system.main_operations.AllOperations.newContact;

public class DeleteContact implements Delete {
    @Override
    public void deletePersonByName(String name, Map<String, Person> userDatabase) {
        try {
            if (newContact.checkNameIsPresent(name, userDatabase)) {
                userDatabase.remove(name);
                System.out.println("Hey Person " + name + ". Your all data is deleted successfully.");
            } else {
                throw new NotFoundException("Oops! The Person First Name " + name + " is not present in the Address Book.\n\n");
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
