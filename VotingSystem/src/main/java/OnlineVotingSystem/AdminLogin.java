package OnlineVotingSystem;

import java.util.Scanner;

public class AdminLogin {
    private final Scanner sc = new Scanner(System.in);

    public boolean loginAdmin() {
        System.out.print("Enter Admin Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        // Hardcoded inbuilt admin credentials
        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("✅ Admin login successful!");
            return true;
        } else {
            System.out.println("⚠️ Invalid admin credentials!");
            return false;
        }
    }
}
