package io.github.makmotrobin.practice.phone;

/** The behaviour every phone exposes. */
public interface Phone {
    void call(String contact);

    void text(String contact, String message);

    void showCallHistory();

    void showTextHistory();
}
