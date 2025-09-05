package OnlineVotingSystem;

import java.util.Scanner;

public class VotingSystem {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n==== Voting System ====");
                System.out.println("1) Admin Login");        // ✅ moved to 1
                System.out.println("2) Register User");      // ✅ now 2
                System.out.println("3) Login User");         // ✅ now 3
                System.out.println("4) Exit");               // ✅ still 4
                System.out.print("Choose: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: // Admin Login
                        if (new AdminLogin().loginAdmin()) {
                            while (true) {
                                System.out.println("\n--- Admin Panel ---");
                                System.out.println("1) Add Party");
                                System.out.println("2) List Parties");
                                System.out.println("3) Show Results");
                                System.out.println("4) Show Winner");
                                System.out.println("5) Back");
                                System.out.print("Choose: ");
                                int c = Integer.parseInt(sc.nextLine());
                                switch (c) {
                                    case 1:
                                        new PartyManager().addParty();
                                        break;
                                    case 2:
                                        new PartyManager().listParties();
                                        break;
                                    case 3:
                                        new ResultModule().showResults();
                                        break;
                                    case 4:
                                        new ResultModule().showWinner();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                }
                                if (c == 5) break;
                            }
                        }
                        break;

                    case 2: // Register User
                        new UserRegistration().registerUser();
                        break;

                    case 3: // Login User
                        int userId = new UserLogin().loginUser();
                        if (userId != -1) {
                            new VotingModule().castVote(userId);
                        }
                        break;

                    case 4:
                        System.out.println("Bye!");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
