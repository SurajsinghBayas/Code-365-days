package JDBC;
// Step 1: Import javas.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "4530241";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

            // Create students table if it does not exist
            try {
                System.out.println("Attempting to create table 'students'...");
                String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                        "roll_no INT PRIMARY KEY, " +
                        "name VARCHAR(100), " +
                        "marks FLOAT)";
                java.sql.Statement stmt = con.createStatement();
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'students' is ready.");
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Error while creating table: " + ex.getMessage());
                ex.printStackTrace();
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}