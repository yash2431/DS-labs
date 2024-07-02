import java.util.Scanner;
class Employee_Detail {
    // Attributes
    int Employee_ID;
    String Name;
    String Designation;
    double Salary;
    // Constructor
    public Employee_Detail(int Employee_ID, String Name, String Designation, double Salary) {
        this.Employee_ID = Employee_ID;
        this.Name = Name;
        this.Designation = Designation;
        this.Salary = Salary;
    }
    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + Employee_ID);
        System.out.println("Name: " + Name);
        System.out.println("Designation: " + Designation);
        System.out.println("Salary: " + Salary);
    }
}
public class EmployeeDetailDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading details from user
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        // Creating Employee_Detail object
        Employee_Detail employee = new Employee_Detail(id, name, designation, salary);

        // Displaying employee details
        System.out.println("\nEmployee Details:");
        employee.displayDetails();

        sc.close();
    }
}
