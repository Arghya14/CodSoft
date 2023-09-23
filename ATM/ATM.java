import java.util.Scanner;
public class ATM {
    private double accountBalance;
    public ATM(double initialBalance) {
        accountBalance = initialBalance;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Exit");
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your account balance is $" + accountBalance);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        accountBalance += depositAmount;
                        System.out.println("Deposit of $" + depositAmount + " successful.");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= accountBalance) {
                        accountBalance -= withdrawalAmount;
                        System.out.println("Withdrawal of $" + withdrawalAmount + " successful.");
                    } else {
                        System.out.println("Insufficient funds or invalid withdrawal amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!!!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public static void main(String[] args) {
        ATM atmMachine = new ATM(1000);

        atmMachine.start();
    }
}
