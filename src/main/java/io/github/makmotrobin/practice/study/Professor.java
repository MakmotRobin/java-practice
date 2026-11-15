package io.github.makmotrobin.practice.study;

/** A professor who assigns grades to students. */
public class Professor {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String courseTaught;

    public Professor(int id, String firstName, String lastName, String courseTaught) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseTaught = courseTaught;
    }

    public Professor(int id, String firstName, String lastName) {
        this(id, firstName, lastName, "");
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourseTaught() {
        return courseTaught;
    }

    /**
     * Records a passing grade, or reports that the student failed.
     *
     * @param student the student being graded
     * @param grade   the grade, on a 0-30 scale
     * @return {@code true} when the grade was recorded
     */
    public boolean assignGrade(Student student, int grade) {
        if (grade >= 18) {
            student.getGrades().add(grade);
            return true;
        }
        System.out.println("Student " + student.getFullName() + " has failed the course.");
        return false;
    }
}
