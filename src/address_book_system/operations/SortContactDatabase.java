package address_book_system.operations;

import address_book_system.entity.Person;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortContactDatabase implements address_book_system.interfaces.SortContactDatabase {
    @Override
    public LinkedHashMap<String, Person> sortContactDatabaseByName(Map<String, Person> contactDatabase) {
        return contactDatabase.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

    }

    @Override
    public LinkedHashMap<String, Person> sortContactDatabaseByCity(Map<String, Person> contactDatabase) {

        return contactDatabase.entrySet().stream()
                .sorted(Comparator.comparing(v -> v.getValue().getCity()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }

    @Override
    public LinkedHashMap<String, Person> sortContactDatabaseByState(Map<String, Person> contactDatabase) {

        return contactDatabase.entrySet().stream()
                .sorted(Comparator.comparing(v -> v.getValue().getState()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }

    @Override
    public LinkedHashMap<String, Person> sortContactDatabaseByZipCode(Map<String, Person> contactDatabase) {

        return contactDatabase.entrySet().stream()
                .sorted(Comparator.comparing(v -> v.getValue().getZipcode()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
}
