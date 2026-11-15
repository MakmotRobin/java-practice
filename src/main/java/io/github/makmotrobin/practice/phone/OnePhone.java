package io.github.makmotrobin.practice.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Shared phone implementation: keeps both histories in memory.
 *
 * <p>The original exercise read from {@code System.in}; the methods now take
 * their arguments directly so the class is usable from tests and demos.</p>
 */
public abstract class OnePhone implements Phone {

    protected final List<String> callHistory = new ArrayList<>();
    protected final List<String> textHistory = new ArrayList<>();

    @Override
    public void call(String contact) {
        callHistory.add(contact);
        System.out.println("Calling " + contact + "...");
    }

    @Override
    public void text(String contact, String message) {
        textHistory.add("Text to " + contact + ": " + message);
        System.out.println("Text sent to " + contact + ".");
    }

    @Override
    public void showCallHistory() {
        System.out.println("Call History:");
        callHistory.forEach(System.out::println);
    }

    @Override
    public void showTextHistory() {
        System.out.println("Text History:");
        textHistory.forEach(System.out::println);
    }

    public List<String> getCallHistory() {
        return List.copyOf(callHistory);
    }

    public List<String> getTextHistory() {
        return List.copyOf(textHistory);
    }
}
