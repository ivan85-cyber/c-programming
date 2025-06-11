import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "user"; 
        String password = "password"; 

        int attemptsRemaining = 3;
        boolean loggedIn = false;

        while (attemptsRemaining > 0 && !loggedIn) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = maskPasswordInput(scanner.nextLine());

            if (enteredUsername.equals(username) && enteredPassword.equals(maskPasswordInput(password))) {
                loggedIn = true;
                System.out.println("Login successful!");
            } else {
                attemptsRemaining--;
                System.out.println("Incorrect username or password. Attempts remaining: " + attemptsRemaining);
            }
        }

        if (!loggedIn) {
            System.out.println("Login failed after multiple attempts.");
        }
        scanner.close();
    }

    // Helper method to mask password input
    private static String maskPasswordInput(String password) {
        StringBuilder maskedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            maskedPassword.append("*");
        }
        return maskedPassword.toString();
    }
}