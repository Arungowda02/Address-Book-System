package address_book_system.operations;

import address_book_system.entity.Person;
import address_book_system.interfaces.ReadByState;

import java.util.List;
import java.util.Map;


public class ReadContactByState implements ReadByState {

    @Override
    public boolean checkStateIsPresent(String state, Map<String, Person> contactDatabase) {

        return contactDatabase.entrySet().stream().anyMatch(value -> value.getValue().getState().equalsIgnoreCase(state.trim()));

    }

    @Override
    public void showPersonByState(String state, Map<String, Person> contactDatabase) {

        if (checkStateIsPresent(state, contactDatabase)) {
            List<Map.Entry<String, Person>> list = contactDatabase.entrySet().stream().filter(n -> n.getValue().getState().equalsIgnoreCase(state.trim())).toList();
            list.forEach(System.out::println);
            System.out.println("-------------------------------------");

        } else {
            System.out.println("Oops! The State " + state + " is not present in the Address Book.\n\n");

        }


    }
}
