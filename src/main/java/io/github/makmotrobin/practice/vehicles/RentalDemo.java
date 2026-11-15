package io.github.makmotrobin.practice.vehicles;

/** Runs the vehicle rental exercise. */
public final class RentalDemo {

    private RentalDemo() {
    }

    public static void main(String[] args) {
        Vehicle sedan = new Sedan("AB-123-CD", 49.90);
        Vehicle bike = new SportBike("EF-456-GH", 29.50);

        Customer alice = new Customer("Alice", "555-0100");
        Customer bob = new Customer("Bob", "555-0200");

        sedan.printVehicleDetails();
        sedan.rentVehicle(alice);
        sedan.printRentedBy();
        System.out.println("3 days: $" + sedan.calculateTotalRentalPrice(3));

        bike.printVehicleDetails();
        bike.rentVehicle(bob);
        bike.printRentedBy();

        sedan.returnVehicle(alice);
        bike.returnVehicle(bob);

        System.out.println("Sedan history: " + sedan.getRentalHistory());
        System.out.println("Bike history: " + bike.getRentalHistory());
    }
}
