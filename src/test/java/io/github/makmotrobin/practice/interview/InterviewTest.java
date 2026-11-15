package io.github.makmotrobin.practice.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InterviewTest {

    @Test
    void totalMinutesSumsEveryCall() {
        SIM sim = new SIM("123456789", 10.0);
        sim.makeCall("555000111", 5);
        sim.makeCall("555000111", 8);
        sim.makeCall("555000222", 10);

        assertEquals(23, sim.getTotalMinutesOfConversation());
    }

    @Test
    void callCountUsesTheDialledNumberNotTheOwnNumber() {
        SIM sim = new SIM("123456789", 10.0);
        sim.makeCall("555000111", 5);
        sim.makeCall("555000111", 8);
        sim.makeCall("555000222", 10);

        assertEquals(2, sim.getCallsToNumber("555000111"));
        assertEquals(1, sim.getCallsToNumber("555000222"));
        assertEquals(0, sim.getCallsToNumber("123456789"),
                "the SIM's own number was never dialled");
    }

    @Test
    void callListIsExposedAsAnUnmodifiableCopy() {
        SIM sim = new SIM("123456789", 10.0);
        sim.makeCall("555000111", 5);

        assertEquals(1, sim.getCallList().size());
        assertThrows(UnsupportedOperationException.class, () -> sim.getCallList().clear());
    }

    @Test
    void callKeepsItsNumberAndDuration() {
        Call call = new Call("555000111", 7);

        assertEquals("555000111", call.getDialedNumber());
        assertEquals(7, call.getDuration());
        assertTrue(call.toString().contains("7 minutes"));
    }

    @Test
    void discountLowersTheUnitPriceByFivePercent() {
        Product product = new Product(12345, "Smartphone", 599.99);

        double discounted = product.applyDiscount();

        assertEquals(569.9905, discounted, 1e-9);
        assertEquals(discounted, product.getUnitPrice(), 1e-9);
    }
}
