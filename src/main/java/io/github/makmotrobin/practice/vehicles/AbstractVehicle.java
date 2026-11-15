package io.github.makmotrobin.practice.vehicles;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * Everything a rentable vehicle does, independent of whether it has two wheels
 * or four. Subclasses only describe their extra attributes.
 */
public abstract class AbstractVehicle implements Vehicle {

    private static final int MAX_HISTORY = 5;

    private final String licensePlate;
    private final String vehicleType;
    private final double rentalPricePerDay;
    private final Deque<Customer> rentalHistory = new ArrayDeque<>();
    private Customer currentRenter;

    protected AbstractVehicle(String licensePlate, String vehicleType, double rentalPricePerDay) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    @Override
    public boolean isRented() {
        return currentRenter != null;
    }

    @Override
    public double calculateTotalRentalPrice(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive, got " + days);
        }
        return rentalPricePerDay * days;
    }

    @Override
    public void rentVehicle(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        if (currentRenter != null) {
            throw new IllegalStateException("This vehicle is already rented by " + currentRenter.getName() + ".");
        }
        currentRenter = customer;
        recordRental(customer);
        System.out.println("Vehicle rented successfully to " + customer.getName());
    }

    @Override
    public void returnVehicle(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        if (!customer.equals(currentRenter)) {
            throw new IllegalStateException("This customer has not rented this vehicle.");
        }
        currentRenter = null;
        System.out.println("Vehicle returned successfully by " + customer.getName());
    }

    @Override
    public List<Customer> getRentalHistory() {
        return List.copyOf(rentalHistory);
    }

    @Override
    public void printVehicleDetails() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price Per Day: $" + rentalPricePerDay);
        printSpecificDetails();
    }

    @Override
    public void printRentedBy() {
        if (currentRenter == null) {
            System.out.println("This vehicle is currently not rented.");
        } else {
            System.out.println("Rented by:");
            System.out.println("- " + currentRenter.getName());
        }
    }

    /** Prints the attributes that only this kind of vehicle has. */
    protected abstract void printSpecificDetails();

    private void recordRental(Customer customer) {
        if (rentalHistory.size() == MAX_HISTORY) {
            rentalHistory.removeFirst();
        }
        rentalHistory.addLast(customer);
    }
}
