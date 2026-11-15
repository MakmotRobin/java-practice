package io.github.makmotrobin.practice.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * A SIM card that records every call made with it.
 *
 * <p>The original exercise counted calls by comparing the requested number to
 * the SIM's own number, so the answer never depended on whom you dialled. Each
 * {@link Call} now stores the dialled number and the count is computed from it.</p>
 */
public class SIM {

    private final String phoneNumber;
    private final double credit;
    private final List<Call> callList = new ArrayList<>();

    public SIM(String phoneNumber, double credit) {
        this.phoneNumber = phoneNumber;
        this.credit = credit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getCredit() {
        return credit;
    }

    public List<Call> getCallList() {
        return List.copyOf(callList);
    }

    public void makeCall(String dialedNumber, int duration) {
        callList.add(new Call(dialedNumber, duration));
    }

    public int getTotalMinutesOfConversation() {
        int totalMinutes = 0;
        for (Call call : callList) {
            totalMinutes += call.getDuration();
        }
        return totalMinutes;
    }

    public int getCallsToNumber(String targetNumber) {
        int callsToNumber = 0;
        for (Call call : callList) {
            if (targetNumber.equals(call.getDialedNumber())) {
                callsToNumber++;
            }
        }
        return callsToNumber;
    }

    public void printSIMData() {
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Available Credit: " + credit + " euro");
        System.out.println("List of Phone Calls:");
        for (int i = 0; i < callList.size(); i++) {
            System.out.println("Call " + (i + 1) + ": Duration - " + callList.get(i).getDuration() + " minutes");
        }
    }
}
