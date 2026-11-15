package io.github.makmotrobin.practice.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonthTest {

    @Test
    void declaresTwelveMonthsInCalendarOrder() {
        assertEquals(12, Month.values().length);
        assertEquals("JANUARY", Month.values()[0].name());
        assertEquals("DECEMBER", Month.values()[11].name());
    }

    @Test
    void detectsNamesEndingWithY() {
        List<Month> endingWithY = Arrays.stream(Month.values())
                .filter(Month::endsWithY)
                .toList();

        assertEquals(List.of(Month.JANUARY, Month.FEBRUARY, Month.MAY, Month.JULY), endingWithY);
    }

    @Test
    void reportsTheOtherMonthsAsNotEndingWithY() {
        assertFalse(Month.MARCH.endsWithY());
        assertFalse(Month.DECEMBER.endsWithY());
        assertTrue(Month.JULY.endsWithY());
    }
}
