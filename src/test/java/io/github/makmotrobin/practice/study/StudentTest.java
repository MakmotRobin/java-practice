package io.github.makmotrobin.practice.study;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    @Test
    void averageIsTheMeanOfTheGrades() {
        Student student = new Student(1, "Alice", "Smith", new Date(), List.of(30, 20, 25));

        assertEquals(25.0, student.calculateGradeAverage(), 1e-9);
    }

    @Test
    void averageOfNoGradesIsZeroInsteadOfADivisionByZero() {
        Student student = new Student(2, "Bob", "Johnson", new Date());

        assertEquals(0.0, student.calculateGradeAverage(), 1e-9);
        assertFalse(student.isExcellent());
    }

    @Test
    void excellentRequiresAnAverageOfAtLeastTwentyEight() {
        Student excellent = new Student(3, "Cleo", "Brown", new Date(), List.of(30, 28));
        Student good = new Student(4, "Dan", "Lee", new Date(), List.of(27, 28));

        assertTrue(excellent.isExcellent());
        assertFalse(good.isExcellent(), "27.5 is below the 28 threshold");
    }

    @Test
    void professorRecordsPassingGradesOnly() {
        Student student = new Student(5, "Eve", "Stone", new Date());
        Professor professor = new Professor(101, "John", "Doe", "Math");

        assertTrue(professor.assignGrade(student, 25));
        assertFalse(professor.assignGrade(student, 15));

        assertEquals(List.of(25), student.getGrades());
    }

    @Test
    void professorKeepsTheirCourse() {
        Professor professor = new Professor(102, "Jane", "Smith");

        assertEquals("", professor.getCourseTaught());
        assertEquals("Jane Smith", professor.getFirstName() + " " + professor.getLastName());
    }
}
