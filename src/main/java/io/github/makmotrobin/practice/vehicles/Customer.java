package io.github.makmotrobin.practice.vehicles;

/** A person who can rent a vehicle. */
public class Customer {

    private final String name;
    private final String contactNumber;

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return name + " (" + contactNumber + ")";
    }
}
