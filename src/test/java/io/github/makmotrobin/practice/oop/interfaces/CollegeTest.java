package io.github.makmotrobin.practice.oop.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollegeTest {

    @Test
    void studentOnlyLearns() {
        CollegeStudent student = new CollegeStudent("Alice", "Smith", 12345, 3);

        assertTrue(student instanceof LearningPerson);
        assertFalse(student instanceof TeachingPerson);
        assertEquals("Alice Smith", student.getFullName());
        assertEquals(3, student.getAcademicYear());
    }

    @Test
    void professorOnlyTeaches() {
        CollegeProfessor professor = new CollegeProfessor("John", "Doe", 67890, "Computer Science");

        assertTrue(professor instanceof TeachingPerson);
        assertFalse(professor instanceof LearningPerson);
        assertEquals("Computer Science", professor.getTeachingSubject());
    }

    @Test
    void assistantDoesBothBecauseTheCapabilitiesAreSeparateInterfaces() {
        TeachingAssistant assistant = new TeachingAssistant("Emily", "Brown", 54321, true);

        assertTrue(assistant instanceof LearningPerson);
        assertTrue(assistant instanceof TeachingPerson);
        assertTrue(assistant.isGoingToBeAPhD());
    }

    @Test
    void everyCollegePersonSharesTheBaseDetails() {
        CollegePerson person = new CollegePerson("Ada", "Lovelace", 7);

        assertEquals("Ada", person.getName());
        assertEquals("Lovelace", person.getSurname());
        assertEquals(7, person.getCollegeId());
    }
}
