import java.util.Scanner;

// Bank Account class to store the account balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

// ATM class to interact with the user's bank account
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performAction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Please take your cash.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}


public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.performAction(choice, scanner);
        }
    }
}
