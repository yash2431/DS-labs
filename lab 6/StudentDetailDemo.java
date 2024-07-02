import java.util.Scanner;

class Student_Detail {
    // Attributes
    String Name;
    int Semester;
    double CPI;
    int Enrollment_No;

    // Constructor
    public Student_Detail(int Enrollment_No, String Name, int Semester, double CPI) {
        this.Enrollment_No = Enrollment_No;
        this.Name = Name;
        this.Semester = Semester;
        this.CPI = CPI;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Enrollment No: " + Enrollment_No);
        System.out.println("Name: " + Name);
        System.out.println("Semester: " + Semester);
        System.out.println("CPI: " + CPI);
    }
}

public class StudentDetailDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to hold 5 Student_Detail objects
        Student_Detail[] students = new Student_Detail[5];

        // Reading details for 5 students
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");

            System.out.print("Enter Enrollment No: ");
            int enrollmentNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Semester: ");
            int semester = scanner.nextInt();

            System.out.print("Enter CPI: ");
            double cpi = scanner.nextDouble();

            // Creating Student_Detail object and storing it in the array
            students[i] = new Student_Detail(enrollmentNo, name, semester, cpi);
        }

        // Displaying details of all students
        System.out.println("\nStudent Details:");
        for (Student_Detail student : students) {
            student.displayDetails();
            System.out.println(); // Print an empty line between students
        }

        scanner.close();
    }
}
