package address_book_system.exception;

public class NameAlreadyExitsException extends Exception{
    public NameAlreadyExitsException(String message)
    {
        super(message);
    }
}
