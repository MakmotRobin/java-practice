package io.github.makmotrobin.practice.streams;

/**
 * The debugger exercises, extracted into plain static methods so they can be
 * asserted with JUnit in {@code ExercisesTest} instead of calling test
 * assertions from production code.
 */
public final class Exercises {

    private Exercises() {
    }

    /** @return {@code number!} */
    public static int calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must not be negative");
        }
        int result = 1;
        for (int i = number; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    /** @return the characters of {@code input} in reverse order */
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    /** @return {@code true} when {@code num} is strictly greater than zero */
    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + calculateFactorial(5));
        System.out.println("Reverse of \"hello\": " + reverseString("hello"));
        System.out.println("isPositive(-5): " + isPositive(-5));
        System.out.println("isPositive(0): " + isPositive(0));
        System.out.println("isPositive(5): " + isPositive(5));
    }
}
