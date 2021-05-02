import java.io.Serializable;

public class Contact implements Serializable {
    private String firstName, lastName, phoneNumber, email, address;

    public Contact() {
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.email = "";
        this.address = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s, %s", this.getFirstName(), this.getLastName()
                , this.getAddress(), this.getEmail(), this.getPhoneNumber());
    }

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
