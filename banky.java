 import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
  private String accountNumber;
  private String accountHolder;
  private double balance;

  public Account(String accountNumber, String accountHolder, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getAccountHolder() {
    return accountHolder;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    if (balance >= amount) {
      balance -= amount;
    } else {
      System.out.println("Insufficient balance.");
    }
  }

  public void transfer(Account recipient, double amount) {
    if (balance >= amount) {
      balance -= amount;
      recipient.deposit(amount);
    } else {
      System.out.println("Insufficient balance.");
    }
  }
}

public class banky {
  private Map<String, Account> accounts;
  private Scanner scanner;

  public banky() {
    accounts = new HashMap<>();
    scanner = new Scanner(System.in);
  }

  public void createAccount() {
    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.print("Enter account holder's name: ");
    String accountHolder = scanner.nextLine();
    System.out.print("Enter initial balance: ");
    double balance = scanner.nextDouble();
    scanner.nextLine(); // Consume newline left-over

    Account account = new Account(accountNumber, accountHolder, balance);
    accounts.put(accountNumber, account);
    System.out.println("Account created successfully.");
  }

  public void deposit() {
    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.print("Enter amount to deposit: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline left-over

    Account account = accounts.get(accountNumber);
    if (account != null) {
      account.deposit(amount);
      System.out.println("Deposit successful. New balance: " + account.getBalance());
    } else {
      System.out.println("Account not found.");
    }
  }

  public void withdraw() {
    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.print("Enter amount to withdraw: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline left-over

    Account account = accounts.get(accountNumber);
    if (account != null) {
      account.withdraw(amount);
      System.out.println("Withdrawal successful. New balance: " + account.getBalance());
    } else {
      System.out.println("Account not found.");
    }
  }

  public void transfer() {
    System.out.print("Enter sender's account number: ");
    String senderAccountNumber = scanner.nextLine();
    System.out.print("Enter recipient's account number: ");
    String recipientAccountNumber = scanner.nextLine();
    System.out.print("Enter amount to transfer: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline left-over

    Account sender = accounts.get(senderAccountNumber);
    Account recipient = accounts.get(recipientAccountNumber);
    if (sender != null && recipient != null) {
      sender.transfer(recipient, amount);
      System.out.println("Transfer successful. Sender's new balance: " + sender.getBalance());
      System.out.println("Recipient's new balance: " + recipient.getBalance());
    } else {
      System.out.println("One or both accounts not found.");
    }
  }

  public void run() {
    while (true) {
      System.out.println("\nBankY System");
      System.out.println("1. Create account");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Transfer");
      System.out.println("5. Exit");

      System.out.print("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine(); // Consume newline left-over

      switch (option) {
        case 1:
          createAccount();
          break;
        case 2:
          deposit();
          break;
        case 3:
          withdraw();
          break;
        case 4:
          transfer();
          break;
        case 5:
          System.out.println("Goodbye!");
          return;
        default:
          System.out.println("Invalid option. Please choose a valid option.");
      }
    }
  }

  public static void main(String[] args) {
    banky bank = new banky();
    bank.run();
  }
}
 // Bank Management {
    

