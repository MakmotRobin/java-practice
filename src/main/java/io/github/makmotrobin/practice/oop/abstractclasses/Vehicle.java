package io.github.makmotrobin.practice.oop.abstractclasses;

/**
 * Base type for every vehicle in the abstract-class exercise.
 *
 * <p>The class carries the shared state and behaviour, while
 * {@link #doVehicleSound()} stays abstract so each subtype has to supply its own
 * noise.</p>
 */
public abstract class Vehicle {

    private final String type;
    private final int numberOfWheels;

    protected Vehicle(String type, int numberOfWheels) {
        this.type = type;
        this.numberOfWheels = numberOfWheels;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void showVehicleDetails() {
        System.out.println("Vehicle Type: " + type);
        System.out.println("Number of Wheels: " + numberOfWheels);
    }

    /** Makes the subtype-specific sound. */
    public abstract void doVehicleSound();
}
