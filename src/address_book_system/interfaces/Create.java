package address_book_system.interfaces;

import address_book_system.entity.Person;
import address_book_system.exception.InvalidFormatException;
import address_book_system.exception.NameAlreadyExitsException;

public interface Create {
    String enterPersonState() throws InvalidFormatException;
    String enterPersonCity() throws InvalidFormatException;
    String enterPersonAddress() throws InvalidFormatException;
    String enterPersonEmail() throws InvalidFormatException;
    String enterPersonZipCode() throws InvalidFormatException;
    String enterPersonMobileNumber() throws InvalidFormatException;
    String enterPersonLastName() throws InvalidFormatException;
    String enterPersonFirstName() throws NameAlreadyExitsException, InvalidFormatException;
    Person savePerson() throws NameAlreadyExitsException, InvalidFormatException;

}
