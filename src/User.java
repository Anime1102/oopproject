abstract class User {
    private String name;
    private String phoneNumber;
    private String password;
    private double walletBalance;

    public User(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.walletBalance = 0.0;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void depositMoney(double amount) {
        walletBalance += amount;
        System.out.println("Deposit successful. New wallet balance: " + walletBalance);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (walletBalance >= amount) {
            walletBalance -= amount;
            System.out.println("Withdrawal successful. New wallet balance: " + walletBalance);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in the wallet.");
        }
    }

    public void cashIn(double amount) {
        walletBalance += amount;
        System.out.println("Cash-in successful. New wallet balance: " + walletBalance);
    }

    public void cashOut(double amount) throws InsufficientBalanceException {
        if (walletBalance >= amount) {
            walletBalance -= amount;
            System.out.println("Cash-out successful. New wallet balance: " + walletBalance);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in the wallet.");
        }
    }

    public abstract void showMenu();
}
