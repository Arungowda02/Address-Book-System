package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.exception.NotFoundException;
import address_book_system.interfaces.ReadByCity;

import java.util.List;
import java.util.Map;

public class ReadContactByCity implements ReadByCity {

    @Override
    public boolean checkCityIsPresent(String city, Map<String, Person> contactDatabase) {

        return contactDatabase.entrySet().stream().anyMatch(value -> value.getValue().getCity().equalsIgnoreCase(city.trim()));

    }

    @Override
    public void showPersonByCity(String city, Map<String, Person> contactDatabase) throws NotFoundException {
        if (checkCityIsPresent(city, contactDatabase)) {
            List<Map.Entry<String, Person>> list = contactDatabase.entrySet().stream().filter(n -> n.getValue().getCity().equalsIgnoreCase(city.trim())).toList();
            list.forEach(System.out::println);
            System.out.println("-------------------------------------");

        } else {
            throw new NotFoundException("Oops! The State " + city + " is not present in the Address Book.\n\n");
        }
    }

}
