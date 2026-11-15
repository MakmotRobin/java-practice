package io.github.makmotrobin.practice.oop.interfaces;

/**
 * A teaching assistant who both studies and teaches, which is only possible
 * because the two capabilities live in separate interfaces.
 */
public class TeachingAssistant extends CollegePerson implements LearningPerson, TeachingPerson {

    private final boolean goingToBeAPhD;

    public TeachingAssistant(String name, String surname, int collegeId, boolean willBeAPhD) {
        super(name, surname, collegeId);
        this.goingToBeAPhD = willBeAPhD;
    }

    public boolean isGoingToBeAPhD() {
        return goingToBeAPhD;
    }

    @Override
    public void studyAtHome() {
        System.out.println("Assistant " + getName() + " is studying at home.");
    }

    @Override
    public void teachToOtherPeople() {
        System.out.println("Assistant " + getName() + " is teaching.");
    }
}
