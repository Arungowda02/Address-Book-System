package address_book_system.main_operations;

import address_book_system.database.ContactDatabase;
import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.exception.NameAlreadyExitsException;
import address_book_system.exception.NotFoundException;
import address_book_system.interfaces.*;
import address_book_system.operations.CountContact;
import address_book_system.operations.ReadContactByCity;
import address_book_system.operations.ReadContactByName;
import address_book_system.operations.ReadContactByState;

import java.util.HashMap;
import java.util.Scanner;

import static address_book_system.operations.OperationForDelete.callOperationForDelete;
import static address_book_system.operations.OperationForRead.callOperationForRead;
import static address_book_system.operations.OperationForUpdate.callOperationForUpdate;

public class AllOperations implements Operations {
    public static SortContactDatabase sortContactDatabase = new address_book_system.operations.SortContactDatabase();
    public static CountContact countContact = new CountContact();
    public static ReadByCity readByCity = new ReadContactByCity();
    public static ReadByState readByState = new ReadContactByState();
    public static Person person = new Person();
    public static Update updateContact = new UpdateContact();
    public static Delete deleteContact = new DeleteContact();
    public static CreateContact newContact = new CreateContact();
    public static ReadContactByName readByName = new ReadContactByName();
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, Person> contactDatabase = new ContactDatabase().contactDatabase();

    public static void crudOperation(int i) {

        if (i == 1) {
            Person person;
            try {
                person = newContact.savePerson();
                contactDatabase.put(person.getFirstName(), person);
            } catch (NameAlreadyExitsException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            }

            crudOperation(Operations.printWelcomeMessage());
        } else if (i == 2) {
            try {
                callOperationForRead();
            } catch (NotFoundException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            }
            crudOperation(Operations.printWelcomeMessage());

        } else if (i == 3) {
            try {
                callOperationForUpdate();
            } catch (NotFoundException | InvalidFormatException e) {
                System.out.println(e.getMessage());
            }
            crudOperation(Operations.printWelcomeMessage());
        } else if (i == 4) {
            callOperationForDelete();
            crudOperation(Operations.printWelcomeMessage());
        } else if (i == 0) {
            sc.close();
        }

    }

}
