package io.github.makmotrobin.practice.study;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** A student with a date of birth and a mutable list of grades. */
public class Student {

    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final List<Integer> grades;

    public Student(int studentId, String firstName, String lastName, Date dateOfBirth, List<Integer> grades) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.grades = new ArrayList<>(grades);
    }

    public Student(int studentId, String firstName, String lastName, Date dateOfBirth) {
        this(studentId, firstName, lastName, dateOfBirth, List.of());
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * @return the arithmetic mean of the recorded grades, or {@code 0.0} when the
     *         student has no grades yet
     */
    public double calculateGradeAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    /** An average of 28 or more (out of 30) counts as excellent. */
    public boolean isExcellent() {
        return !grades.isEmpty() && calculateGradeAverage() >= 28;
    }

    @Override
    public String toString() {
        return "Student{" + studentId + ", " + getFullName() + ", average=" + calculateGradeAverage() + '}';
    }
}
