package io.github.makmotrobin.practice.oop.abstractclasses;

/** Runs the abstract-class exercise. */
public final class VehicleDemo {

    private VehicleDemo() {
    }

    public static void main(String[] args) {
        Car myCar = new Car(4, 4, 25000.0);
        Boat myBoat = new Boat(30.0, 1500);

        myCar.showVehicleDetails();
        myCar.doVehicleSound();

        myBoat.showVehicleDetails();
        myBoat.doVehicleSound();

        System.out.println(myBoat.getBoatWeightAndSpeed());
    }
}
