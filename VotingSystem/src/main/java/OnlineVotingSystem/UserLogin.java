package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {
    private final Scanner sc = new Scanner(System.in);

    public int loginUser() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String sql = "SELECT id FROM voting_system WHERE role='USER' AND username=? AND password=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("✅ Login successful!");
                        return rs.getInt("id");
                    } else {
                        System.out.println("⚠️ Invalid credentials!");
                        return -1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
