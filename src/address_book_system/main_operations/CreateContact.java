package address_book_system.main_operations;

import address_book_system.entity.Person;
import address_book_system.implimentation.CreateImpl;

import java.util.Map;


public class CreateContact extends CreateImpl {

    public boolean checkNameIsPresent(String name, Map<String, Person> personData) {

        return personData.keySet().stream().anyMatch(key -> key.equalsIgnoreCase(name.trim()));

    }


}
