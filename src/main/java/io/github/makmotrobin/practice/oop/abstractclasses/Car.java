package io.github.makmotrobin.practice.oop.abstractclasses;

/** A four-wheeled vehicle with a door count and a price tag. */
public class Car extends Vehicle {

    private final int numberOfDoors;
    private final double carPrice;

    public Car(int wheels, int doors, double price) {
        super("Car", wheels);
        this.numberOfDoors = doors;
        this.carPrice = price;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public double getCarPrice() {
        return carPrice;
    }

    @Override
    public void showVehicleDetails() {
        super.showVehicleDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Price: " + carPrice);
    }

    @Override
    public void doVehicleSound() {
        System.out.println("Beep beep!");
    }
}
