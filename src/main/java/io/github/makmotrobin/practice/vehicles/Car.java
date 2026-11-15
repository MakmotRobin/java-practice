package io.github.makmotrobin.practice.vehicles;

/** A four-wheeled vehicle. */
public abstract class Car extends AbstractVehicle {

    private final int numberOfDoors;
    private final String transmissionType;

    protected Car(String licensePlate, String vehicleType, double rentalPricePerDay,
                  int numberOfDoors, String transmissionType) {
        super(licensePlate, vehicleType, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    protected void printSpecificDetails() {
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Transmission Type: " + transmissionType);
    }
}
