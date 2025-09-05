package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserRegistration {
    private final Scanner sc = new Scanner(System.in);

    public void registerUser() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String sql = "INSERT INTO voting_system (role, username, password) VALUES ('USER', ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
                System.out.println("✅ User registered successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
