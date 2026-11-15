package io.github.makmotrobin.practice.oop.abstractclasses;

/** A wheel-less vehicle described by its top speed and weight. */
public class Boat extends Vehicle {

    private final double maxKnotsSpeed;
    private final int boatKilosWeight;

    public Boat(double maxSpeed, int weight) {
        // Boats typically have no wheels.
        super("Boat", 0);
        this.maxKnotsSpeed = maxSpeed;
        this.boatKilosWeight = weight;
    }

    public double getMaxKnotsSpeed() {
        return maxKnotsSpeed;
    }

    public int getBoatKilosWeight() {
        return boatKilosWeight;
    }

    public String getBoatWeightAndSpeed() {
        return "Boat Weight: " + boatKilosWeight + " kilos\nBoat Max Speed: " + maxKnotsSpeed + " knots";
    }

    @Override
    public void doVehicleSound() {
        System.out.println("Whoosh!");
    }
}
