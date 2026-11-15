package io.github.makmotrobin.practice.vehicles;

import java.util.List;

/**
 * A rentable vehicle.
 *
 * <p>The original homework threw checked {@link Exception}s from
 * {@link #rentVehicle} and {@link #returnVehicle}. Those are programming
 * errors, so the contract now uses unchecked exceptions:</p>
 *
 * <ul>
 *   <li>{@link IllegalStateException} when the vehicle is already rented or when
 *       the customer trying to return it is not the current renter</li>
 *   <li>{@link IllegalArgumentException} for a non-positive number of days</li>
 * </ul>
 */
public interface Vehicle {

    String getLicensePlate();

    String getVehicleType();

    double getRentalPricePerDay();

    void printVehicleDetails();

    void printRentedBy();

    void rentVehicle(Customer customer);

    void returnVehicle(Customer customer);

    boolean isRented();

    double calculateTotalRentalPrice(int days);

    /** The last rentals, oldest first, capped at five entries. */
    List<Customer> getRentalHistory();
}
