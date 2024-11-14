package address_book_system.interfaces;

import address_book_system.entity.Person;

import java.util.Map;

public interface ReadByState extends Read {
    void showPersonByState(String state, Map<String, Person> contactDatabase);
    boolean checkStateIsPresent(String city, Map<String, Person> contactDatabase);
}
