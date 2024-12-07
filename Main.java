import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private ArrayList<Integer> grades;

    // Constructor
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    // Add a grade to the student's list of grades
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Calculate the average grade of the student
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    // Display individual grades
    public void displayGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }

    // Check if the student has passed
    public boolean hasPassed(double passingGrade) {
        return calculateAverage() >= passingGrade;
    }

    public String getName() {
        return name;
    }
}

class Classroom {
    private ArrayList<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    // Add a student to the classroom
    public void addStudent(Student student) {
        students.add(student);
    }

    // Calculate the class average
    public double calculateClassAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Student student : students) {
            total += student.calculateAverage();
        }
        return total / students.size();
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayGrades();
            System.out.println("Average: " + student.calculateAverage());
            System.out.println("Has Passed: " + (student.hasPassed(60) ? "Yes" : "No"));
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Classroom classroom = new Classroom();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID for " + name + ": ");
            String studentId = scanner.nextLine();

            Student student = new Student(name, studentId);

            System.out.print("Enter the number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }
            scanner.nextLine(); // Consume the newline
            classroom.addStudent(student);
        }

        System.out.println("\nClassroom Report:");
        classroom.displayAllStudents();
        System.out.println("Class Average: " + classroom.calculateClassAverage());
    }
}
