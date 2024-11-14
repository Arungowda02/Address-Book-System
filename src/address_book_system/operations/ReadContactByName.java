package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.interfaces.ReadByName;

import java.util.Map;
import java.util.stream.Collectors;

import static address_book_system.main_operations.AllOperations.newContact;
import static address_book_system.main_operations.AllOperations.sc;

public class ReadContactByName implements ReadByName {


    @Override
    public void showPersonByName(String name, Map<String, Person> contactDatabase) {
        if (newContact.checkNameIsPresent(name, contactDatabase)) {
            contactDatabase.entrySet().stream().filter(n -> n.getValue().getFirstName().equalsIgnoreCase(name.trim())).forEach(System.out::println);
            System.out.println("-------------------------------------");

        } else {
            System.out.println("Oops! The Person First Name " + name + " is not present in the Address Book.\n");

        }
    }

    @Override
    public void showPersonByFirstCharacterOfName(Map<String, Person> contactDatabase) {
        System.out.println("Enter Some Starting Character of First Name : ");
        String startWith = sc.next();
        Map<String, Person> contact = contactDatabase.entrySet().stream().filter(e -> e.getKey().startsWith(startWith)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (!contact.isEmpty()) {
            contact.entrySet().forEach(System.out::println);
        } else {
            System.out.println("No contacts found! There are no contacts starting with that letter " + "'"+startWith+"'");
        }
    }

    @Override
    public void showPersonByLastCharacterOfName(Map<String, Person> contactDatabase) {

        System.out.println("Enter Some Ending Character of First Name : ");
        String endWith = sc.next();
        Map<String, Person> contact = contactDatabase.entrySet().stream().filter(e -> e.getKey().endsWith(endWith)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (!contact.isEmpty()) {
            contact.entrySet().forEach(System.out::println);
        } else {
            System.out.println("No contacts found! There are no contacts ending with that letter " + "'"+endWith+"'");
        }


    }

    @Override
    public void showAll(Map<String, Person> contactDatabase) {
        contactDatabase.entrySet().forEach(System.out::println);
    }
}
