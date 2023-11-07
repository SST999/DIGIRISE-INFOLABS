import java.util.*;

class Course {
    String name;
    String instructor;
    List<Student> students;
    Map<String, String> assignments;

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
        this.students = new ArrayList<>();
        this.assignments = new HashMap<>();
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public void submitAssignment(String courseName, String assignment) {
        System.out.println(name + " submitted assignment for course: " + courseName);
        System.out.println("Assignment: " + assignment);
    }
}

class Instructor {
    String name;

    public Instructor(String name) {
        this.name = name;
    }

    public void provideFeedback(String courseName, String studentName, String assignment, String feedback) {
        System.out.println("Instructor " + name + " provided feedback for " + studentName);
        System.out.println("Course: " + courseName);
        System.out.println("Assignment: " + assignment);
        System.out.println("Feedback: " + feedback);
    }
}

class CourseManagementSystem {
    List<Course> courses;
    List<Student> students;
    List<Instructor> instructors;

    public CourseManagementSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        instructors = new ArrayList<>();
    }

    public void createCourse(String courseName, String instructorName) {
        Course course = new Course(courseName, instructorName);
        courses.add(course);
        System.out.println("Course '" + courseName + "' created with instructor " + instructorName);
    }

    public void enrollStudent(String studentName, String courseName) {
        Student student = new Student(studentName);
        Optional<Course> courseOptional = courses.stream()
                .filter(course -> course.name.equals(courseName))
                .findFirst();

        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.students.add(student);
            students.add(student);
            System.out.println(studentName + " enrolled in course: " + courseName);
        } else {
            System.out.println("Course not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Create courses and enroll students
        cms.createCourse("Math101", "InstructorA");
        cms.createCourse("History101", "InstructorB");
        cms.enrollStudent("Student1", "Math101");
        cms.enrollStudent("Student2", "Math101");
        cms.enrollStudent("Student3", "History101");

        // Students submit assignments
        Student student1 = cms.students.get(0);
        student1.submitAssignment("Math101", "Assignment 1");

        // Instructors provide feedback
        Instructor instructorA = new Instructor("InstructorA");
        instructorA.provideFeedback("Math101", "Student1", "Assignment 1", "Good work!");
    }
}
