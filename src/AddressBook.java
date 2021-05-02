import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String[] args) {
        String userInput, firstName, lastName, phoneNumber, email, address;;
        Scanner kb = new Scanner(System.in);
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();

        switch (userInput) {
            case "1":
                System.out.print("Please enter the first name of the contact:");
                firstName = kb.next();
                System.out.print("Please enter the last name of the contact:");
                lastName = kb.next();
                System.out.print("Please enter the contact's phone number:");
                phoneNumber = kb.next();
                System.out.print("Please enter the contact's email:");
                email = kb.next();
                System.out.println("Please enter the contact's address:");
                address = kb.nextLine();
                Contact c = new Contact();
                c.setFirstName(firstName);
                c.setLastName(lastName);
                c.setPhoneNumber(phoneNumber);
                c.setEmail(email);
                c.setAddress(address);
                contacts.add(c);
                break;
            case "2":
                System.out.print("Please enter the phone number of the contact you wish to remove:");
                phoneNumber = kb.next();
                contacts.removeIf(temp -> temp.getPhoneNumber().equals(phoneNumber));
                break;
            case "3":
                System.out.println("3");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                System.out.println("6");
                break;
            case "7":
                System.out.println("7");
                break;
            default:
                System.out.println("Invalid input, please enter a valid option.");
                printMenu();
                System.out.print("Select an option (number): ");
        }
    }

    public static void printMenu() {
        System.out.println("Address Book Operations:");
        System.out.println("\t1) Add");
        System.out.println("\t2) Remove");
        System.out.println("\t3) Save");
        System.out.println("\t4) Load");
        System.out.println("\t5) Display All");
        System.out.println("\t6) Search");
        System.out.println("\t7) Exit");
    }
}


