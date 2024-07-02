import java.util.Scanner;

class BankAccount {
    // Attributes
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an array of BankAccount objects
        BankAccount[] accounts = new BankAccount[3];

        // Initializing bank accounts
        accounts[0] = new BankAccount(101, "Alice", 1000.0);
        accounts[1] = new BankAccount(102, "Bob", 1500.0);
        accounts[2] = new BankAccount(103, "Charlie", 2000.0);

        // Displaying details of all accounts
        System.out.println("Initial Account Details:");
        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println(); // Print an empty line between accounts
        }

        // Example operations
        System.out.println("Performing operations on account 1 (Alice):");
        accounts[0].deposit(500.0);
        accounts[0].withdraw(200.0);
        System.out.println("Current Balance: " + accounts[0].checkBalance());
        System.out.println();

        System.out.println("Performing operations on account 2 (Bob):");
        accounts[1].deposit(300.0);
        accounts[1].withdraw(100.0);
        System.out.println("Current Balance: " + accounts[1].checkBalance());
        System.out.println();

        // Displaying updated details of all accounts
        System.out.println("Updated Account Details:");
        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println(); // Print an empty line between accounts
        }

        scanner.close();
    }
}
