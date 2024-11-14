package address_book_system.main_class;

import static address_book_system.interfaces.Operations.printWelcomeMessage;
import static address_book_system.main_operations.AllOperations.crudOperation;

public class AddressBookMain {



    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        crudOperation(printWelcomeMessage());
    }
}
