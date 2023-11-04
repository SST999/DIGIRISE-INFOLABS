import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {
        double balance = 5000.0; // Initial balance
        List<String> transactionHistory = new ArrayList<>();

        while (true) {
            System.out.println("Automated Teller Machine");
            System.out.println("Choose 1 for Transaction History");
            System.out.println("Choose 2 for Withdraw");
            System.out.println("Choose 3 for Deposit");
            System.out.println("Choose 4 for Transfer Money");
            System.out.println("Choose 5 for Check Balance");
            System.out.println("Choose 6 for EXIT");
            System.out.print("Choose the operation you want to perform: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Code for Transaction History
                    System.out.println("Transaction History:");
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case 2:
                    // Code for Withdraw
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        if (withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            String transaction = "Withdraw: " + withdrawAmount;
                            transactionHistory.add(transaction);
                            System.out.println("Withdrawal successful. Your new balance is: " + balance);
                        } else {
                            System.out.println("Insufficient balance. You cannot withdraw more than your current balance.");
                        }
                    } else {
                        System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
                    }
                    break;
                case 3:
                    // Code for Deposit
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        String transaction = "Deposit: " + depositAmount;
                        transactionHistory.add(transaction);
                        System.out.println("Deposit successful. Your new balance is: " + balance);
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive amount.");
                    }
                    break;
                case 4:
                    // Code for Transfer Money
                    System.out.print("Enter the recipient's account number: ");
                    int recipientAccount = scanner.nextInt();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();

                    if (transferAmount > 0) {
                        if (transferAmount <= balance) {
                            balance -= transferAmount;
                            String transaction = "Transfer to Account " + recipientAccount + ": " + transferAmount;
                            transactionHistory.add(transaction);
                            System.out.println("Transfer successful. Your new balance is: " + balance);
                        } else {
                            System.out.println("Insufficient balance. You cannot transfer more than your current balance.");
                        }
                    } else {
                        System.out.println("Invalid transfer amount. Please enter a positive amount.");
                    }
                    break;
                case 5:
                    // Code for Check Balance
                    System.out.println("Your current balance is: " + balance);
                    break;
                case 6:
                    // Code for EXIT
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}