import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create two Account objects using parameterized constructor
        Account acc1 = new Account("Alice", 1001, 1000.0);
        Account acc2 = new Account("Bob", 1002, 2000.0);

        System.out.print("=== Bank: " + Account.bankName + " ===\n");
        int n = -1;// to avoid error in while condition

        while (n != 0) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit (Account 1)");
            System.out.println("2. Deposit (Account 2)");
            System.out.println("3. Withdraw (Account 1)");
            System.out.println("4. Withdraw (Account 2)");
            System.out.println("5. Check Balance (Account 1)");
            System.out.println("6. Check Balance (Account 2)");
            System.out.println("7. Change Bank Name");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.print("Enter amount to deposit into Account 1: ");
                    double d1 = sc.nextDouble();
                    acc1.deposit(d1);
                    System.out.println("Account 1 Balance: " + acc1.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit into Account 2: ");
                    double d2 = sc.nextDouble();
                    acc2.deposit(d2);
                    System.out.println("Account 2 Balance: " + acc2.getBalance());
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw from Account 1: ");
                    double w1 = sc.nextDouble();
                    boolean success1 = acc1.withdraw(w1);
                    System.out.println(
                            success1 ? "Withdrawal successful." : "Withdrawal failed: Minimum balance limit reached.");
                    System.out.println("Account 1 Balance: " + acc1.getBalance());
                    break;

                case 4:
                    System.out.print("Enter amount to withdraw from Account 2: ");
                    double w2 = sc.nextDouble();
                    boolean success2 = acc2.withdraw(w2);
                    System.out.println(
                            success2 ? "Withdrawal successful." : "Withdrawal failed: Minimum balance limit reached.");
                    System.out.println("Account 2 Balance: " + acc2.getBalance());
                    break;

                case 5:
                    System.out.println("Account 1 (" + acc1.getAccountHolder() + ") Balance: " + acc1.getBalance());
                    break;

                case 6:
                    System.out.println("Account 2 (" + acc2.getAccountHolder() + ") Balance: " + acc2.getBalance());
                    break;

                case 7:
                    System.out.print("Enter new bank name: ");
                    String newName = sc.next();
                    Account.bankName = newName;
                    System.out.println("Bank name changed to: " + Account.bankName);
                    System.out.println("(This affects all accounts since bankName is static)");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}

class Account {
    private String accountHolder;
    private int accountNo;
    private double balance;
    static String bankName = "MCB";
    final double MIN_BALANCE = 500;

    // Default constructor
    public Account() {
        accountHolder = "Unknown";
        accountNo = 0;
        balance = 0.0;
    }

    public Account(String accountHolder, int accountNo, double balance) {
        this.accountHolder = accountHolder;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}