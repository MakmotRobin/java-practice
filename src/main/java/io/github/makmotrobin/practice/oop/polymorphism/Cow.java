package io.github.makmotrobin.practice.oop.polymorphism;

/** A cow moos. */
public class Cow extends Animal {

    public Cow(String name) {
        super(name);
    }

    @Override
    public void animalSound() {
        System.out.println("Mooing!");
    }
}
