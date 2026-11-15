package io.github.makmotrobin.practice.phone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneTest {

    @Test
    void robinPhoneRecordsCallsAndTexts() {
        RobinPhone phone = new RobinPhone();

        phone.call("Alice");
        phone.text("Bob", "Hello");

        assertEquals(1, phone.getCallHistory().size());
        assertEquals("Alice", phone.getCallHistory().get(0));
        assertEquals("Text to Bob: Hello", phone.getTextHistory().get(0));
    }

    @Test
    void historyIsAnUnmodifiableSnapshot() {
        RobinPhone phone = new RobinPhone();
        phone.call("Alice");

        assertThrows(UnsupportedOperationException.class, () -> phone.getCallHistory().add("Bob"));
    }

    @Test
    void fullCycleKeepsBothHistories() {
        RobinPhone phone = new RobinPhone();

        phone.usePhone("Alice", "See you at 8");

        assertEquals(1, phone.getCallHistory().size());
        assertEquals(1, phone.getTextHistory().size());
    }

    @Test
    void defangingWrapsEveryDot() {
        assertEquals("192[.]168[.]1[.]1", DefangIpAddress.defang("192.168.1.1"));
        assertEquals("1[.]1[.]1[.]1", DefangIpAddress.defang("1.1.1.1"));
    }

    @Test
    void addressesWithoutDotsAreUnchanged() {
        assertEquals("localhost", DefangIpAddress.defang("localhost"));
    }
}
