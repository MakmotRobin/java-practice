package io.github.makmotrobin.practice.interview;

/** Runs the SIM/RAM interview question. */
public final class InterviewDemo {

    private InterviewDemo() {
    }

    public static void main(String[] args) {
        SIM simCard = new SIM("123456789", 10.0);

        simCard.makeCall("555000111", 5);
        simCard.makeCall("555000111", 8);
        simCard.makeCall("555000222", 10);

        System.out.println("Total Minutes of Conversation: " + simCard.getTotalMinutesOfConversation());
        System.out.println("Calls Made to 555000111: " + simCard.getCallsToNumber("555000111"));

        simCard.printSIMData();
    }
}
