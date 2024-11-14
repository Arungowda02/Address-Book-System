package address_book_system.interfaces;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;

import java.util.Map;

public interface Update {
    String enterPersonFirstName();
    Person updatePersonByName(String name, Map<String, Person> contactDatabase) throws InvalidFormatException;
}
