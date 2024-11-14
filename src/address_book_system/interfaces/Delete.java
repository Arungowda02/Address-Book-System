package address_book_system.interfaces;

import address_book_system.entity.Person;

import java.util.Map;

@FunctionalInterface
public interface Delete {
    void deletePersonByName(String name, Map<String, Person> userDatabase);
}
