package address_book_system.interfaces;

import address_book_system.entity.Person;
import address_book_system.exception.NotFoundException;

import java.util.Map;

public interface ReadByCity extends Read {
    void showPersonByCity(String city, Map<String, Person> contactDatabase) throws NotFoundException;
    boolean checkCityIsPresent(String city, Map<String, Person> contactDatabase);
}
