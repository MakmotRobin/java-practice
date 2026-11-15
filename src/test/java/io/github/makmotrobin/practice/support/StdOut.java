package io.github.makmotrobin.practice.support;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Captures {@code System.out} so tests can assert on printed output. */
public final class StdOut {

    private StdOut() {
    }

    /**
     * Runs {@code action} with {@code System.out} redirected.
     *
     * @return everything the action printed
     */
    public static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }
}
