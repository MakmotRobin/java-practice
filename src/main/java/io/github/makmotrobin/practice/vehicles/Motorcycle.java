package io.github.makmotrobin.practice.vehicles;

/** A two-wheeled vehicle. */
public abstract class Motorcycle extends AbstractVehicle {

    private final int engineCapacity;

    protected Motorcycle(String licensePlate, String vehicleType, double rentalPricePerDay, int engineCapacity) {
        super(licensePlate, vehicleType, rentalPricePerDay);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    protected void printSpecificDetails() {
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
    }
}
