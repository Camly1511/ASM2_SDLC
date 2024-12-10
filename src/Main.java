import java.util.Stack;
import java.util.Scanner;
import java.util.Collections;

class Student {
    int id;
    String name;
    double mark;

    public Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Mark: " + mark;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Student> studentStack = new Stack<>();
        String choice = "";
        Scanner s = new Scanner(System.in);

        while (!choice.equals("7")) {
            System.out.println("Student management:");
            System.out.println("1. Add");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. Sort ascending");
            System.out.println("5. Sort descending");
            System.out.println("6. Search");
            System.out.println("7. Exit");
            System.out.println("Enter your choice here: ");
            choice = s.nextLine();

            switch (choice) {
                case "1": { // Add student
                    try {
                        System.out.println("Enter student ID:");
                        int studentId = Integer.parseInt(s.nextLine());

                        System.out.println("Enter student name:");
                        String studentName = s.nextLine();

                        System.out.println("Enter student mark:");
                        double studentMark = Double.parseDouble(s.nextLine());

                        Student student = new Student(studentId, studentName, studentMark);
                        studentStack.push(student); // Push the student to the stack
                        System.out.println("Student added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                }
                case "2": { // Edit student
                    try {
                        System.out.println("Enter student ID to edit:");
                        int studentId = Integer.parseInt(s.nextLine());

                        boolean found = false;
                        Stack<Student> tempStack = new Stack<>();
                        while (!studentStack.isEmpty()) {
                            Student student = studentStack.pop();
                            if (student.getId() == studentId) {
                                System.out.println("Enter new student name:");
                                String newName = s.nextLine();

                                System.out.println("Enter new student mark:");
                                double newMark = Double.parseDouble(s.nextLine());

                                tempStack.push(new Student(studentId, newName, newMark));
                                System.out.println("Student updated successfully.");
                                found = true;
                                break;
                            } else {
                                tempStack.push(student);
                            }
                        }
                        while (!tempStack.isEmpty()) {
                            studentStack.push(tempStack.pop()); // Push back the students
                        }

                        if (!found) {
                            System.out.println("Student with ID " + studentId + " not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                }
                case "3": { // Delete student
                    try {
                        System.out.println("Enter student ID to delete:");
                        int studentId = Integer.parseInt(s.nextLine());

                        boolean found = false;
                        Stack<Student> tempStack = new Stack<>();
                        while (!studentStack.isEmpty()) {
                            Student student = studentStack.pop();
                            if (student.getId() == studentId) {
                                System.out.println("Student deleted successfully.");
                                found = true;
                                break;
                            } else {
                                tempStack.push(student);
                            }
                        }
                        while (!tempStack.isEmpty()) {
                            studentStack.push(tempStack.pop()); // Push back the students
                        }

                        if (!found) {
                            System.out.println("Student with ID " + studentId + " not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                }
                case "4": { // Sort ascending
                    Stack<Student> tempStack = new Stack<>();
                    while (!studentStack.isEmpty()) {
                        tempStack.push(studentStack.pop()); // Transfer all students to a temporary stack
                    }

                    Collections.sort(tempStack, (s1, s2) -> Double.compare(s1.getMark(), s2.getMark()));

                    System.out.println("Students sorted in ascending order:");
                    while (!tempStack.isEmpty()) {
                        Student student = tempStack.pop(); // Print sorted students
                        System.out.println(student);
                    }
                    break;
                }
                case "5": { // Sort descending
                    Stack<Student> tempStack = new Stack<>();
                    while (!studentStack.isEmpty()) {
                        tempStack.push(studentStack.pop()); // Transfer all students to a temporary stack
                    }

                    Collections.sort(tempStack, (s1, s2) -> Double.compare(s2.getMark(), s1.getMark()));

                    System.out.println("Students sorted in descending order:");
                    while (!tempStack.isEmpty()) {
                        Student student = tempStack.pop(); // Print sorted students
                        System.out.println(student);
                    }
                    break;
                }
                case "6": { // Search student
                    try {
                        System.out.println("Enter student ID to search:");
                        int studentId = Integer.parseInt(s.nextLine());

                        boolean found = false;
                        Stack<Student> tempStack = new Stack<>();
                        while (!studentStack.isEmpty()) {
                            Student student = studentStack.pop();
                            if (student.getId() == studentId) {
                                System.out.println("Student found: " + student);
                                found = true;
                                break;
                            } else {
                                tempStack.push(student);
                            }
                        }
                        while (!tempStack.isEmpty()) {
                            studentStack.push(tempStack.pop()); // Push back the students
                        }

                        if (!found) {
                            System.out.println("Student with ID " + studentId + " not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                }
                case "7": { // Exit
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Wrong choice. Please try again.");
                    break;
                }
            }
        }
        s.close();
    }
}
