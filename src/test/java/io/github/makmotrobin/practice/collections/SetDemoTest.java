package io.github.makmotrobin.practice.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SetDemoTest {

    @Test
    void linkedHashSetPreservesInsertionOrder() {
        assertEquals(
                List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"),
                new ArrayList<>(SetDemo.weekInOrder()));
    }

    @Test
    void hashSetAndLinkedHashSetAreEqualAsSets() {
        Set<String> hash = new HashSet<>(SetDemo.weekInOrder());
        Set<String> linked = SetDemo.weekInOrder();

        assertEquals(hash, linked);
        assertEquals(hash.hashCode(), linked.hashCode());
    }

    @Test
    void setSemanticsRejectDuplicates() {
        Set<String> days = SetDemo.weekInOrder();
        days.add("Monday");

        assertEquals(7, days.size());
    }

    @Test
    void hashSetDoesNotDefineAnOrderToCompareAgainst() {
        Set<String> reversed = new java.util.LinkedHashSet<>();
        reversed.add("Sunday");
        reversed.add("Monday");

        assertNotEquals(new ArrayList<>(SetDemo.weekInOrder()).subList(0, 2), new ArrayList<>(reversed));
    }
}
