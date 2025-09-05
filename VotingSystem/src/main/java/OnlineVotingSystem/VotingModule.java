package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class VotingModule {
    private final Scanner sc = new Scanner(System.in);

    public void castVote(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            // Check if already voted
            String checkSql = "SELECT has_voted FROM voting_system WHERE role='USER' AND id=?";
            try (PreparedStatement ps = con.prepareStatement(checkSql)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && rs.getInt("has_voted") == 1) {
                        System.out.println("⚠️ You already voted!");
                        return;
                    }
                }
            }

            new PartyManager().listParties();
            System.out.print("Enter Party ID to vote: ");
            int pid = Integer.parseInt(sc.nextLine());

            String voteSql = "UPDATE voting_system SET has_voted=1, vote_party_id=? WHERE role='USER' AND id=?";
            try (PreparedStatement ps = con.prepareStatement(voteSql)) {
                ps.setInt(1, pid);
                ps.setInt(2, userId);
                ps.executeUpdate();
                System.out.println("✅ Vote cast successfully!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
