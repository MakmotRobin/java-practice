package io.github.makmotrobin.practice.oop.interfaces;

/** A college person who only teaches. */
public class CollegeProfessor extends CollegePerson implements TeachingPerson {

    private final String teachingSubject;

    public CollegeProfessor(String name, String surname, int collegeId, String teachingSubject) {
        super(name, surname, collegeId);
        this.teachingSubject = teachingSubject;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    @Override
    public void teachToOtherPeople() {
        System.out.println("Professor " + getName() + " is teaching " + teachingSubject);
    }
}
