package io.github.makmotrobin.practice.oop.polymorphism;

/** A lion roars. */
public class Lion extends Animal {

    public Lion(String name) {
        super(name);
    }

    @Override
    public void animalSound() {
        System.out.println("Roaring!");
    }
}
