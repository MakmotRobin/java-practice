package io.github.makmotrobin.practice.streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExercisesTest {

    @Test
    void factorialOfFiveIsOneHundredTwenty() {
        assertEquals(120, Exercises.calculateFactorial(5));
    }

    @Test
    void factorialOfZeroIsOne() {
        assertEquals(1, Exercises.calculateFactorial(0));
    }

    @Test
    void factorialRejectsNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> Exercises.calculateFactorial(-1));
    }

    @Test
    void stringsReverseCharacterByCharacter() {
        assertEquals("olleh", Exercises.reverseString("hello"));
        assertEquals("", Exercises.reverseString(""));
    }

    @Test
    void onlyStrictlyPositiveNumbersArePositive() {
        assertTrue(Exercises.isPositive(5));
        assertTrue(Exercises.isPositive(55));
        assertTrue(Exercises.isPositive(4567));
        assertFalse(Exercises.isPositive(0));
        assertFalse(Exercises.isPositive(-5));
        assertFalse(Exercises.isPositive(-55));
    }
}
