package io.github.makmotrobin.practice.oop.polymorphism;

/** Base type whose {@link #animalSound()} is overridden by every subtype. */
public class Animal {

    private final String animalName;

    public Animal(String name) {
        this.animalName = name;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void animalSound() {
        System.out.println("Default animal sound");
    }
}
