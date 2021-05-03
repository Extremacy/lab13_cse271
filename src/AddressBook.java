import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: PJ Duimstra
 * Date: May 2, 2021
 * Lab 13: Advanced IO
 * Creates the AddressBook class that allows a user to create and store Contact objects in a
 * given ArrayList/binary file (AddressBook.bin).
 */
public class AddressBook {
    /**
     * Defining global instance variables
     */
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();
    public static String userInput;
    public static Scanner kb = new Scanner(System.in);

    /**
     * Main driver method for the AddressBook class.
     * @param args
     */
    public static void main(String[] args) {
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();

        //Infinite loop running methods for the program.
        do {
            switch (userInput) {
                case "1":
                    addContact();
                    break;
                case "2":
                    removeContact();
                    break;
                case "3":
                    saveToFile();
                    break;
                case "4":
                    loadFromFile();
                    break;
                case "5":
                    displayContacts();
                    break;
                case "6":
                    contactSearch();
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Invalid input, please enter a valid option.");
                    printMenu();
                    System.out.print("Select an option (number): ");
                    userInput = kb.next();
            }
        } while (!userInput.equals("7"));
        System.out.println("Exiting Program...");
    }

    /**
     * Helper method that prints the user menu.
     */
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

    /**
     * Method that adds a contact object to the contacts ArrayList object.
     * Takes user input for the firstName, lastName, phoneNumber, email, and address
     * of the contact to be entered.
     */
    public static void addContact() {
        kb.nextLine();
        String firstName, lastName, phoneNumber, email, address;
        System.out.print("Please enter the first name of the contact: ");
        firstName = kb.nextLine();
        System.out.print("Please enter the last name of the contact: ");
        lastName = kb.nextLine();
        System.out.print("Please enter the contact's phone number: ");
        phoneNumber = kb.nextLine();
        System.out.print("Please enter the contact's email: ");
        email = kb.nextLine();
        System.out.print("Please enter the contact's address: ");
        address = kb.nextLine();
        Contact c = new Contact();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setPhoneNumber(phoneNumber);
        c.setEmail(email);
        c.setAddress(address);
        contacts.add(c);
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    /**
     * Method that removes a given contact from the contacts ArrayList.
     * Takes user input for the phoneNumber of the contact they wish to remove.
     */
    public static void removeContact() {
        String phoneNumber;
        System.out.print("Please enter the phone number of the contact you wish to remove:");
        phoneNumber = kb.next();
        contacts.removeIf(temp -> temp.getPhoneNumber().equals(phoneNumber));
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    /**
     * Method that saves the contacts ArrayList to a binary file.
     */
    public static void saveToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("AddressBook.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    /**
     * Method that loads a contact ArrayList from a given binary file.
     */
    public static void loadFromFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        contacts = new ArrayList<Contact>();
        try {
            fis = new FileInputStream("AddressBook.bin");
            ois = new ObjectInputStream(fis);
            contacts = (ArrayList<Contact>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    /**
     * Method that displays the contacts that are currently held in the contacts
     * ArrayList object.
     */
    public static void displayContacts() {
        for (Contact contact: contacts
             ) {
            System.out.println(contact.toString());
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    /**
     * Method that takes user input for a search query and displays an ArrayList
     * (searchResults) of the Contact objects containing the search term.
     */
    public static void contactSearch() {
        ArrayList<Contact> searchResults = new ArrayList<Contact>();
        System.out.print("Please enter your search term: ");
        String search = kb.next();
        for (Contact contact: contacts
             ) {
            if (contact.getAddress().contains(search)) {
                searchResults.add(contact);
            } else if (contact.getFirstName().contains(search)) {
                searchResults.add(contact);
            } else if (contact.getLastName().contains(search)) {
                searchResults.add(contact);
            } else if (contact.getPhoneNumber().contains(search)) {
                searchResults.add(contact);
            } else if (contact.getEmail().contains(search)) {
                searchResults.add(contact);
            }
        }
        System.out.println("Search results: ");
        for (Contact contact: searchResults
             ) {
            System.out.println(contact.toString());
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }
}


