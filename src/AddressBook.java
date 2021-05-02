import java.io.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();
    public static String userInput;
    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
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
                    try {
                        loadFromFile();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    displayContacts();
                    break;
                case "6":
                    contactSearch();
                    break;
                case "7":
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid input, please enter a valid option.");
                    printMenu();
                    System.out.print("Select an option (number): ");
            }
        } while (!userInput.equals("7"));

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

    public static void addContact() {
        String firstName, lastName, phoneNumber, email, address;
        System.out.print("Please enter the first name of the contact:");
        firstName = kb.next();
        System.out.print("Please enter the last name of the contact:");
        lastName = kb.next();
        System.out.print("Please enter the contact's phone number:");
        phoneNumber = kb.next();
        System.out.print("Please enter the contact's email:");
        email = kb.next();
        System.out.print("Please enter the contact's address:");
        address = kb.next();
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

    public static void saveToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("AddressBook.bin");
            oos = new ObjectOutputStream(fos);
            for (Contact contact: contacts
            ) {
                oos.writeObject(contact);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    public static void loadFromFile() throws IOException{
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        contacts = new ArrayList<Contact>();
        try {
            fis = new FileInputStream("AddressBook.bin");
            ois = new ObjectInputStream(fis);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!");
        printMenu();
        System.out.print("Select an option (number): ");
        userInput = kb.next();
    }

    public static void displayContacts() {
        for (Contact contact: contacts
             ) {
            System.out.println(contact.toString());
        }
    }

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
    }
}


