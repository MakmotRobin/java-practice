package io.github.makmotrobin.practice.study;

import java.util.Date;
import java.util.List;

/** Runs the student/professor exercise. */
public final class StudentDemo {

    private StudentDemo() {
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", "Smith", new Date());
        Student student2 = new Student(2, "Bob", "Johnson", new Date());
        Student student3 = new Student(3, "Charlie", "Brown", new Date());
        Student student4 = new Student(4, "David", "Lee", new Date());

        Professor professor1 = new Professor(101, "John", "Doe", "Math");
        Professor professor2 = new Professor(102, "Jane", "Smith", "Science");

        professor1.assignGrade(student1, 25);
        professor1.assignGrade(student2, 30);
        professor2.assignGrade(student3, 20);
        professor2.assignGrade(student4, 15);

        List<Student> students = List.of(student1, student2, student3, student4);

        System.out.println("Excellent students:");
        students.stream()
                .filter(Student::isExcellent)
                .forEach(student -> System.out.println(student.getFullName()));

        Student highestGradeStudent = students.stream()
                .max((a, b) -> Double.compare(a.calculateGradeAverage(), b.calculateGradeAverage()))
                .orElseThrow();

        System.out.println("Student with highest grade average:");
        System.out.println(highestGradeStudent.getFullName());
    }
}
