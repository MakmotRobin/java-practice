package io.github.makmotrobin.practice.oop.interfaces;

/** A college person who only studies. */
public class CollegeStudent extends CollegePerson implements LearningPerson {

    private final int academicYear;

    public CollegeStudent(String name, String surname, int collegeId, int academicYear) {
        super(name, surname, collegeId);
        this.academicYear = academicYear;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    @Override
    public void studyAtHome() {
        System.out.println("Student " + getName() + " is studying at home.");
    }
}
