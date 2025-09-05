package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultModule {

    public void showResults() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT p.party_name, COUNT(u.id) AS votes " +
                         "FROM voting_system u " +
                         "JOIN voting_system p ON u.vote_party_id = p.id " +
                         "WHERE u.role='USER' AND p.role='PARTY' " +
                         "GROUP BY p.id";

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\n--- Election Results ---");
                while (rs.next()) {
                    System.out.println(rs.getString("party_name") + " : " + rs.getInt("votes") + " votes");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showWinner() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT p.party_name, COUNT(u.id) AS votes " +
                         "FROM voting_system u " +
                         "JOIN voting_system p ON u.vote_party_id = p.id " +
                         "WHERE u.role='USER' AND p.role='PARTY' " +
                         "GROUP BY p.id " +
                         "ORDER BY votes DESC LIMIT 1";

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    System.out.println("\n🏆 Winner: " + rs.getString("party_name") + " with " + rs.getInt("votes") + " votes");
                } else {
                    System.out.println("No votes yet.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
