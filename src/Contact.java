import java.io.Serializable;

/**
 * Author: PJ Duimstra
 * Date: May 2, 2021
 * Lab 13: Advanced IO
 * Creates the Contact object and implements java.io.Serializable so that the objects
 * can be saved to binary files.
 */
public class Contact implements Serializable {
    private String firstName, lastName, phoneNumber, email, address;

    /**
     * Default constructor for the Contact object.
     */
    public Contact() {
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.email = "";
        this.address = "";
    }

    /**
     * Getter for the firstName instance variable.
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the firstName instance variable.
     * @param firstName the first name to be set for the given Contact object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the lastName instance variable.
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the lastName instance variable.
     * @param lastName the last name to be set for the given Contact object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the phoneNumber instance variable.
     * @return phoneNumber.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for the phoneNumber instance variable.
     * @param phoneNumber the last name to be set for the given Contact object.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the email instance variable.
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email instance variable.
     * @param email the last name to be set for the given Contact object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the address instance variable.
     * @return address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for the address instance variable.
     * @param address the last name to be set for the given Contact object.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Override method for toString()
     * @return formatted string that displays the information held in a given
     * Contact object.
     */
    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s", this.getFirstName(), this.getLastName()
                , this.getAddress(), this.getEmail(), this.getPhoneNumber());
    }

    /**
     * Override method for .equals().
     * @param o the object being compared to a given Contact object.
     * @return the boolean expression of the difference between the objects.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact)) {
            return false;
        }

        Contact c = (Contact) o;
        return c.getPhoneNumber().equals(phoneNumber) &&
               c.getEmail().equals(email) &&
               c.getAddress().equals(address) &&
               c.getLastName().equals(lastName) &&
               c.getFirstName().equals(firstName);
    }
}
