import java.util.Scanner;
public class MyPaymentApp {
    private User[] users;
    private int userCount;
    private Scanner scanner;

    public MyPaymentApp(int maxUsers) {
        users = new User[maxUsers];
        userCount = 0;
        scanner = new Scanner(System.in);
    }
    public void registerUser() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Create a password: ");
        String password = scanner.nextLine();

        User newUser = new RegularUser(name, phoneNumber, password);
        users[userCount++] = newUser;
        System.out.println("User registered successfully.");
    }

    public void loginUser() {
        System.out.println("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        User user = findUserByPhoneNumber(phoneNumber);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + user.getPhoneNumber() + "!");
            user.showMenu();
        } else {
            System.out.println("Invalid phone number or password.");
        }
    }

    private User findUserByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyPaymentApp bKashApp = new MyPaymentApp(100);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== bKash App ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bKashApp.registerUser();
                    break;

                case 2:
                    bKashApp.loginUser();
                    break;

                case 3:
                    System.out.println("Exiting the app. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }
}

