package io.github.makmotrobin.practice.vehicles;

/** A four-door automatic car. */
public class Sedan extends Car {

    public Sedan(String licensePlate, double rentalPricePerDay) {
        super(licensePlate, "Sedan", rentalPricePerDay, 4, "Automatic");
    }
}
