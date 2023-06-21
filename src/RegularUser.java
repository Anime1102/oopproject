import java.util.Scanner;
class RegularUser extends User {
    public RegularUser(String name, String phoneNumber, String password) {
        super(name, phoneNumber, password);
    }

    @Override
    public void showMenu() {
        System.out.println("1. View Wallet Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Logout");
        System.out.println("5. Cash In");
        System.out.println("6. Cash Out");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Wallet Balance: " + getWalletBalance());
                break;

            case 2:
                System.out.println("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                depositMoney(depositAmount);
                break;

            case 3:
                System.out.println("Enter the amount to withdraw: ");
                double withdrawalAmount = scanner.nextDouble();
                try {
                    withdrawMoney(withdrawalAmount);
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Logged out successfully.");
                break;

            case 5:
                System.out.println("Enter the amount to cash in: ");
                double cashInAmount = scanner.nextDouble();
                cashIn(cashInAmount);
                break;

            case 6:
                System.out.println("Enter the amount to cash out: ");
                double cashOutAmount = scanner.nextDouble();
                try {
                    cashOut(cashOutAmount);
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                showMenu();
                break;
        }
    }
}
