package io.github.makmotrobin.practice.phone;

/** A concrete phone that runs through a full call/text/history cycle. */
public class RobinPhone extends OnePhone {

    public void usePhone(String contact, String message) {
        System.out.println("Using RobinPhone:");
        call(contact);
        text(contact, message);
        showCallHistory();
        showTextHistory();
    }
}
