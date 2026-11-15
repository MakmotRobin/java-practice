package io.github.makmotrobin.practice.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathOperationsTest {

    @Test
    @DisplayName("subtraction handles positive operands")
    void subtractionWithPositiveNumbers() {
        assertEquals(5, MathOperations.subtraction(10, 5),
                "10 - 5 should be 5");
    }

    @Test
    @DisplayName("subtraction handles a negative subtrahend")
    void subtractionWithNegativeNumbers() {
        assertEquals(-8, MathOperations.subtraction(-5, 3),
                "-5 - 3 should be -8");
    }

    @Test
    @DisplayName("multiplication handles positive operands")
    void multiplicationWithPositiveNumbers() {
        assertEquals(12, MathOperations.multiplication(3, 4),
                "3 * 4 should be 12");
    }

    @Test
    @DisplayName("multiplication handles a negative factor")
    void multiplicationWithNegativeNumbers() {
        assertEquals(-10, MathOperations.multiplication(-2, 5),
                "-2 * 5 should be -10");
    }
}
