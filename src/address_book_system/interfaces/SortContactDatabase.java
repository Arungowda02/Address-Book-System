package address_book_system.interfaces;

import address_book_system.entity.Person;

import java.util.LinkedHashMap;
import java.util.Map;

import static address_book_system.main_operations.AllOperations.sc;

public interface SortContactDatabase {

    LinkedHashMap<String, Person> sortContactDatabaseByName(Map<String, Person> contactDatabase);

    LinkedHashMap<String, Person> sortContactDatabaseByCity(Map<String, Person> contactDatabase);

    LinkedHashMap<String, Person> sortContactDatabaseByState(Map<String, Person> contactDatabase);

    LinkedHashMap<String, Person> sortContactDatabaseByZipCode(Map<String, Person> contactDatabase);

    default int printOptionForShowingPersonsDetailsInSortForm() {
        System.out.println(
                "\n1. By Sorting Person First Name\n2. By Sorting City\n3. By Sorting State\n4. By Sorting Zip Code" +
                        "\n\n( enter related number only)");
        return sc.nextInt();
    }
}
