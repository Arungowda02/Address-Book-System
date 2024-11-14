package address_book_system.interfaces;

import address_book_system.entity.Person;

import java.util.Map;

public interface ReadByName extends Read {
    void showPersonByName(String name, Map<String, Person> contactDatabase);
    void showPersonByFirstCharacterOfName(Map<String, Person> contactDatabase);
    void showPersonByLastCharacterOfName( Map<String, Person> contactDatabase);
    void showAll(Map<String, Person> contactDatabase);



}
