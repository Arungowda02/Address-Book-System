package address_book_system.interfaces;

import address_book_system.exception.InvalidFormatException;

import java.util.InputMismatchException;

import static address_book_system.main_operations.AllOperations.sc;

public interface Read {
    default int printOptionForShowingPersonsDetails() {
        int i;
        while (true) {
            System.out.println(
                    "\n1. By Person First Name\n2. By City\n3. By State" +"\n4. By Starting with Some Character"
                            +"\n5. By Ending With Some Character "+
                            "\n6. All Persons Details\n0. Press Zero for main menu " +
                            "\n\n( enter related number only)");
            try {
                i = sc.nextInt();
                if (i >= 0 && i <= 6) {
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
