import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        bank.addUser(new User(1, 1234, 1000.0));
        bank.addUser(new User(2, 5678, 500.0));

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        User currentUser = bank.authenticateUser(userId, pin);
        if (currentUser == null) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    currentUser.printTransactions();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentUser.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    currentUser.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    int recipientId = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(currentUser, recipientId, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}

class User {
    private int userId;
    private int pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(int userId, int pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = String.format("Deposited: $%.2f", amount);
            transactionHistory.add(transaction);
            System.out.printf("Deposit successful. Current balance: $%.2f\n", balance);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            String transaction = String.format("Withdrawn: $%.2f", amount);
            transactionHistory.add(transaction);
            System.out.printf("Withdrawal successful. Current balance: $%.2f\n", balance);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }

    public void printTransactions() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

class Bank {
    private ArrayList<User> users;

    public Bank() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User authenticateUser(int userId, int pin) {
        for (User user : users) {
            if (user.getUserId() == userId && user.getPin() == pin) {
                return user;
            }
        }
        return null;
    }

    public void transfer(User sender, int recipientId, double amount) {
        User recipient = findUserById(recipientId);
        if (recipient != null && amount > 0 && sender.getBalance() >= amount) {
            sender.withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Invalid recipient or insufficient funds.");
        }
    }

    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}