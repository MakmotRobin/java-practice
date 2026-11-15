package io.github.makmotrobin.practice.oop.interfaces;

/** Runs the interfaces exercise. */
public final class CollegeDemo {

    private CollegeDemo() {
    }

    public static void main(String[] args) {
        CollegeStudent student = new CollegeStudent("Alice", "Smith", 12345, 3);
        CollegeProfessor professor = new CollegeProfessor("John", "Doe", 67890, "Computer Science");
        TeachingAssistant assistant = new TeachingAssistant("Emily", "Brown", 54321, true);

        student.goToCollege();
        student.studyAtHome();

        professor.goToCollege();
        professor.teachToOtherPeople();

        assistant.goToCollege();
        assistant.studyAtHome();
        assistant.teachToOtherPeople();
    }
}
