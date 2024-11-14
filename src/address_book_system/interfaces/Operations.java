package address_book_system.interfaces;

import address_book_system.exception.InvalidFormatException;

import java.util.InputMismatchException;

import static address_book_system.main_operations.AllOperations.sc;

public interface Operations {
    static int printWelcomeMessage() {
        int i;
        while (true) {
            System.out.println("\nWhich one would you like to do?" +
                    "\n1. Add Contact\n2. Show Contact details\n3. Update Contact details" +
                    "\n4. Delete Contact\n\nEnter 0(zero) to exit the console\n( Enter related number only)");
            try {
                i = sc.nextInt();
                if (i >= 0 && i <= 4) {
                    return i;
                } else {
                    throw new InvalidFormatException("Enter related number only".toUpperCase());
                }
            } catch (InvalidFormatException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer value.".toUpperCase());
                sc.next();
            }
        }
    }
}
