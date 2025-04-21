import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class FinanceManager {
 static ArrayList<Transaction> transactions = new ArrayList<>();
 static Scanner scanner = new Scanner(System.in);
 public static void main(String[] args) {
 while (true) {
 System.out.println("\n--- Personal Finance Manager ---");
 System.out.println("1. Add Income");
 System.out.println("2. Add Expense");
 System.out.println("3. View Summary");
 System.out.println("4. Exit");
 System.out.print("Enter choice: ");
 int choice = scanner.nextInt();
 scanner.nextLine();
 switch (choice) {
 case 1: addTransaction("Income");
 case 2: addTransaction("Expense");
 case 3: viewSummary();
 case 4: {
 System.out.println("Goodbye!");
 return;
 }
 default: System.out.println("Invalid choice.");
 }
 }
 }
 static void addTransaction(String type) {
 System.out.print("Enter category: ");
 String category = scanner.nextLine();
 System.out.print("Enter amount: ");
 double amount = scanner.nextDouble();
 scanner.nextLine();
 System.out.print("Enter date (yyyy-mm-dd): ");
 String dateInput = scanner.nextLine();
 LocalDate date = LocalDate.parse(dateInput);
 transactions.add(new Transaction(type, category, amount, date));
 System.out.println(type + " added successfully.");
 }
 static void viewSummary() {
 double income = 0, expense = 0;
 System.out.println("\n--- Transaction Summary ---");
 for (Transaction t : transactions) {
 System.out.println(t.type + " | " + t.category + " | " + t.amount + " | " + t.date);
 if (t.type.equals("Income")) income += t.amount;
 else expense += t.amount;
 }
 System.out.println("\nTotal Income: Rs. " + income);
 System.out.println("Total Expense: Rs. " + expense);
 System.out.println("Balance: Rs. " + (income - expense));
 }
}
class Transaction {
 String type;
 String category;
 double amount;
 LocalDate date;
 public Transaction(String type, String category, double amount, LocalDate date) {
 this.type = type;
 this.category = category;
 this.amount = amount;
 this.date = date;
 }
}