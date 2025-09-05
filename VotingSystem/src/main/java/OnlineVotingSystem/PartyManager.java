package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PartyManager {
    private final Scanner sc = new Scanner(System.in);

    public void addParty() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Party Name: ");
            String name = sc.nextLine();

            String sql = "INSERT INTO voting_system (role, party_name) VALUES ('PARTY', ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.executeUpdate();
                System.out.println("✅ Party added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listParties() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT id, party_name FROM voting_system WHERE role='PARTY'";
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\n--- Parties ---");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ") " + rs.getString("party_name"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
