package stream;

import java.util.*;
import java.util.stream.*;

public class Student {
    private String name;
    private int age;
    private double score;

    // Constructor
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    // toString method for printing the object
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", score=" + score + '}';
    }

    // Sample data to play with streams
    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Alice", 20, 85.5),
                new Student("Bob", 22, 90.0),
                new Student("Charlie", 19, 67.8),
                new Student("David", 21, 80.5),
                new Student("Eva", 23, 95.2)
        );
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();

        // Examples of Stream operations

        // 1. Print all students' names
        System.out.println("All students' names:");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        // 2. Filter students with score > 80
        System.out.println("\nStudents with score > 80:");
        students.stream()
                .filter(s -> s.getScore() > 80)
                .forEach(System.out::println);

        // 3. Find the student with the highest score
        System.out.println("\nStudent with the highest score:");
        students.stream()
                .max(Comparator.comparing(Student::getScore))
                .ifPresent(System.out::println);

        // 4. Get the average score of all students
        System.out.println("\nAverage score of all students:");
        double averageScore = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println(averageScore);

        // 5. Group students by age
        System.out.println("\nStudents grouped by age:");
        Map<Integer, List<Student>> studentsByAge = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
        studentsByAge.forEach((age, studentList) -> {
            System.out.println("Age " + age + ": " + studentList);
        });
    }
}
