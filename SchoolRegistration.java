import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Student
class Student {
    static int idCounter = 1; // Static counter to generate unique IDs
    String studentID; // Student's ID
    String name; // Student's name
    int age; // Student's age
    String studentClass; // Student's class

    // Constructor to initialize a new Student object
    public Student(String name, int age, String studentClass) {
        this.studentID = "STU" + idCounter++; // Generate ID based on counter, e.g., STU1, STU2, etc.
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
    }
}

// Main class to handle the school registration
public class SchoolRegistration {
    // List to store registered students
    private static ArrayList<Student> students = new ArrayList<>();

    // Main method - entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command; // Variable to hold user command

        // Loop to continuously take user commands until they exit
        do {
            // Display menu options to the user
            System.out.println("\nChoose an option:");
            System.out.println("1. Register a student");
            System.out.println("2. View registered students");
            System.out.println("3. Remove a student");
            System.out.println("4. Search student by ID");
            System.out.println("5. Exit");
            command = scanner.nextLine(); // Get user command

            // Process user command
            switch (command) {
                case "1":
                    registerStudent(scanner); // Call method to register a student
                    break;
                case "2":
                    viewStudents(); // Call method to view registered students
                    break;
                case "3":
                    removeStudent(scanner); // Call method to remove a student
                    break;
                case "4":
                    searchStudentByID(scanner); // Call method to search student by ID
                    break;
                case "5":
                    System.out.println("Exiting program..."); // Exit message
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Invalid option message
            }
        } while (!command.equals("5")); // Continue until user chooses to exit

        scanner.close(); // Close scanner to free resources
    }

    // Method to register a new student
    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's age: ");

        int age;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine()); // Handle potential NumberFormatException
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid age. Please enter a valid number: "); // Error message for invalid input
            }
        }

        System.out.print("Enter student's class: ");
        String studentClass = scanner.nextLine();

        // Create a new Student object and add to the list
        Student newStudent = new Student(name, age, studentClass);
        students.add(newStudent);
        System.out.println("Student registered successfully! Assigned ID: " + newStudent.studentID); // Confirmation
                                                                                                     // message
    }

    // Method to view all registered students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No registered students."); // Message if list is empty
        } else {
            System.out.println("Registered Students:");
            for (Student student : students) {
                System.out.println("ID: " + student.studentID + ", Name: " + student.name + ", Age: " + student.age
                        + ", Class: " + student.studentClass);
            }
        }
    }

    // Method to search for a student by ID
    private static void searchStudentByID(Scanner scanner) {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        boolean found = false;

        // Loop through students to find a match
        for (Student student : students) {
            if (student.studentID.equalsIgnoreCase(id)) {
                System.out.println("Student Found:");
                System.out.println("ID: " + student.studentID + ", Name: " + student.name + ", Age: " + student.age
                        + ", Class: " + student.studentClass);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Method to remove a student by name
    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter the name of the student to remove: ");
        String name = scanner.nextLine();
        boolean found = false;

        // Loop through the list to find and remove the student
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).name.equalsIgnoreCase(name)) {
                students.remove(i); // Remove student from the list
                System.out.println("Student removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
