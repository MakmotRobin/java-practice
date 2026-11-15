package io.github.makmotrobin.practice.math;

/** Small arithmetic helpers used by the JUnit exercise. */
public final class MathOperations {

    private MathOperations() {
    }

    public static int subtraction(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public static int multiplication(int multiplier, int multiplicand) {
        return multiplier * multiplicand;
    }
}
