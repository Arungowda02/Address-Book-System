package address_book_system.operations;

import static address_book_system.main_operations.AllOperations.*;

public class OperationForDelete {
    public static void callOperationForDelete() {
        if (!contactDatabase.isEmpty()) {
            String firstName = updateContact.enterPersonFirstName();
            deleteContact.deletePersonByName(firstName, contactDatabase);
        } else {
            System.out.println("No Contact Found !!!".toUpperCase());
        }

    }
}
