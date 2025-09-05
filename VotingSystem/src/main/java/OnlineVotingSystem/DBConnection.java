package OnlineVotingSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String JDBC_URL = 
        "jdbc:mysql://localhost:3306/votingdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";      // change if needed
    private static final String PASS = "9751";      // change if needed

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        return DriverManager.getConnection(JDBC_URL, USER, PASS);
    }
}
