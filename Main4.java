import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("1. Add New Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search for a Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
    }

    private void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.next();

        System.out.print("Enter Student Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Student Grade: ");
        String grade = scanner.next();

        Student newStudent = new Student(name, rollNumber, grade);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private void removeStudent() {
        System.out.print("Enter Student Roll Number to remove: ");
        int rollNumberToRemove = scanner.nextInt();

        students.removeIf(student -> student.getRollNumber() == rollNumberToRemove);
        System.out.println("Student removed successfully.");
    }

    private void searchStudent() {
        System.out.print("Enter Student Roll Number to search: ");
        int rollNumberToSearch = scanner.nextInt();

        for (Student student : students) {
            if (student.getRollNumber() == rollNumberToSearch) {
                System.out.println("Student found:\n" + student);
                return;
            }
        }

        System.out.println("Student with Roll Number " + rollNumberToSearch + " not found.");
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
}
