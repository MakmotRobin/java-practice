package io.github.makmotrobin.practice.interview;

/** A single phone call: who was dialled, and for how many minutes. */
public class Call {

    private final String dialedNumber;
    private final int duration;

    public Call(String dialedNumber, int duration) {
        this.dialedNumber = dialedNumber;
        this.duration = duration;
    }

    public String getDialedNumber() {
        return dialedNumber;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Call to " + dialedNumber + " (" + duration + " minutes)";
    }
}
