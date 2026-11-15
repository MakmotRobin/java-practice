package io.github.makmotrobin.practice.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

/**
 * Reads {@code file.txt} from the classpath and prints it line by line.
 *
 * <p>The original read a path relative to the working directory, which only
 * worked from inside the IDE. Loading the resource from the classpath makes the
 * demo runnable from anywhere, including the packaged jar.</p>
 */
public final class FileReaderDemo {

    private static final String RESOURCE = "/file.txt";

    private FileReaderDemo() {
    }

    public static void main(String[] args) {
        try (InputStream in = FileReaderDemo.class.getResourceAsStream(RESOURCE)) {
            if (in == null) {
                System.err.println("Error reading file: " + RESOURCE + " is missing from the classpath");
                return;
            }
            new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
