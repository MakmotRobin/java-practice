package io.github.makmotrobin.practice.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Contrasts {@link HashSet} (no ordering guarantee) with
 * {@link LinkedHashSet} (insertion order), and shows that the two sets are
 * still equal as sets.
 */
public final class SetDemo {

    private SetDemo() {
    }

    public static void main(String[] args) {
        Set<String> daysOfWeek = new HashSet<>();
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        System.out.println("HashSet of days of the week:");
        daysOfWeek.forEach(System.out::println);

        Set<String> orderedDays = new LinkedHashSet<>(daysOfWeek);

        System.out.println("\nLinkedHashSet of days of the week (preserving insertion order):");
        orderedDays.forEach(System.out::println);

        System.out.println("\nIs the first Set equal to the second one? " + daysOfWeek.equals(orderedDays));
    }

    /**
     * @return the seven days in insertion order
     */
    public static Set<String> weekInOrder() {
        return new LinkedHashSet<>(List.of(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    }
}
