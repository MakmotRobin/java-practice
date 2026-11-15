package io.github.makmotrobin.practice.oop.interfaces;

/** Shared identity of everybody attached to the college. */
public class CollegePerson {

    private final String name;
    private final String surname;
    private final int collegeId;

    public CollegePerson(String name, String surname, int collegeId) {
        this.name = name;
        this.surname = surname;
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public void goToCollege() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("College ID: " + collegeId);
    }
}
