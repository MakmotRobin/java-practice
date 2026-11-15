package io.github.makmotrobin.practice.vehicles;

import io.github.makmotrobin.practice.support.StdOut;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RentalTest {

    private final Vehicle sedan = new Sedan("AB-123-CD", 49.90);
    private final Vehicle bike = new SportBike("EF-456-GH", 29.50);
    private final Customer alice = new Customer("Alice", "555-0100");
    private final Customer bob = new Customer("Bob", "555-0200");

    @Test
    void sedanDescribesItself() {
        assertEquals("AB-123-CD", sedan.getLicensePlate());
        assertEquals("Sedan", sedan.getVehicleType());
        assertEquals(4, ((Car) sedan).getNumberOfDoors());
        assertEquals("Automatic", ((Car) sedan).getTransmissionType());
    }

    @Test
    void sportBikeDescribesItself() {
        assertEquals("Sport Bike", bike.getVehicleType());
        assertEquals(600, ((Motorcycle) bike).getEngineCapacity());
    }

    @Test
    void rentingFlipsTheStateAndRecordsHistory() {
        assertFalse(sedan.isRented());

        sedan.rentVehicle(alice);

        assertTrue(sedan.isRented());
        assertEquals(List.of(alice), sedan.getRentalHistory());
    }

    @Test
    void aRentedVehicleCannotBeRentedTwice() {
        sedan.rentVehicle(alice);

        assertThrows(IllegalStateException.class, () -> sedan.rentVehicle(bob));
    }

    @Test
    void onlyTheRenterCanReturnTheVehicle() {
        sedan.rentVehicle(alice);

        assertThrows(IllegalStateException.class, () -> sedan.returnVehicle(bob));

        sedan.returnVehicle(alice);
        assertFalse(sedan.isRented());
    }

    @Test
    void priceIsTheDailyRateTimesTheDays() {
        assertEquals(149.70, sedan.calculateTotalRentalPrice(3), 1e-9);
        assertEquals(59.00, bike.calculateTotalRentalPrice(2), 1e-9);
    }

    @Test
    void nonPositiveRentalPeriodsAreRejected() {
        assertThrows(IllegalArgumentException.class, () -> sedan.calculateTotalRentalPrice(0));
        assertThrows(IllegalArgumentException.class, () -> sedan.calculateTotalRentalPrice(-1));
    }

    @Test
    void historyKeepsOnlyTheFiveMostRecentRentals() {
        for (int i = 0; i < 6; i++) {
            Customer customer = new Customer("Customer " + i, "555-01" + i);
            sedan.rentVehicle(customer);
            sedan.returnVehicle(customer);
        }

        List<Customer> history = sedan.getRentalHistory();
        assertEquals(5, history.size());
        assertEquals("Customer 1", history.get(0).getName(),
                "the oldest rental should have been evicted");
        assertEquals("Customer 5", history.get(4).getName());
    }

    @Test
    void cantPrintRentedByWhenIdle() {
        String output = StdOut.capture(sedan::printRentedBy);

        assertTrue(output.contains("not rented"));
    }

    @Test
    void cantPrintTheRenterName() {
        sedan.rentVehicle(alice);

        String output = StdOut.capture(sedan::printRentedBy);

        assertTrue(output.contains("Alice"));
    }
}
