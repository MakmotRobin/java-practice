package io.github.makmotrobin.practice.oop.polymorphism;

import io.github.makmotrobin.practice.support.StdOut;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalTest {

    @Test
    void baseClassUsesTheDefaultSound() {
        String output = StdOut.capture(() -> new Animal("Generic").animalSound());
        assertEquals("Default animal sound", output.trim());
    }

    @Test
    void subtypesDispatchToTheirOwnSound() {
        assertEquals("Roaring!", StdOut.capture(() -> new Lion("Leo").animalSound()).trim());
        assertEquals("Mooing!", StdOut.capture(() -> new Cow("Daisy").animalSound()).trim());
    }

    @Test
    void dispatchIsResolvedAtRuntimeThroughTheBaseType() {
        List<Animal> animals = List.of(new Animal("Generic"), new Lion("Leo"), new Cow("Daisy"));

        String output = StdOut.capture(() -> animals.forEach(Animal::animalSound));

        String[] lines = output.strip().split("\\R");
        assertEquals(List.of("Default animal sound", "Roaring!", "Mooing!"), List.of(lines));
    }

    @Test
    void keepsTheAnimalName() {
        assertEquals("Leo", new Lion("Leo").getAnimalName());
        assertTrue(new Cow("Daisy").getAnimalName().startsWith("Dai"));
    }
}
