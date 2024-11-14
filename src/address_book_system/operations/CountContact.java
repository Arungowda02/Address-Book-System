package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.exception.NotFoundException;

import java.util.Map;

import static address_book_system.main_operations.AllOperations.readByCity;
import static address_book_system.main_operations.AllOperations.readByState;

public class CountContact {

    public void countContactByCity(String city, Map<String, Person> contactDatabase) throws NotFoundException {
        if (readByCity.checkCityIsPresent(city, contactDatabase)) {
            int size = contactDatabase.entrySet().stream().filter(n -> n.getValue().getCity().equalsIgnoreCase(city.trim())).toList().size();
            System.out.println("The total " + size + " persons are from the City : " + city);
        } else {
            throw new NotFoundException("Oops! The City " + city + " is not present in the Address Book.");
        }

    }

    public void countContactByState(String state, Map<String, Person> contactDatabase) throws NotFoundException {

        if (readByState.checkStateIsPresent(state, contactDatabase)) {
            int size = contactDatabase.entrySet().stream().filter(n -> n.getValue().getState().equalsIgnoreCase(state.trim())).toList().size();
            System.out.println("The total " + size + " persons are from the State : " + state);
        } else {
            throw new NotFoundException("Oops! The City " + state + " is not present in the Address Book.");
        }

    }

}
