package io.github.makmotrobin.practice.oop.polymorphism;

/** Runs the polymorphism exercise through a single {@code Animal[]}. */
public final class AnimalDemo {

    private AnimalDemo() {
    }

    public static void main(String[] args) {
        Animal[] animals = {
                new Animal("Generic Animal"),
                new Lion("Leo"),
                new Cow("Daisy")
        };

        for (Animal animal : animals) {
            System.out.print(animal.getAnimalName() + ": ");
            animal.animalSound();
        }
    }
}
