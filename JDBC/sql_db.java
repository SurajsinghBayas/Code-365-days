package JDBC;

import java.sql.*;

public class sql_db {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "4530241";
        String dbName = "nkocet";
        try {
            // Load And Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step 3: Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to the database: " + dbName);

            // step 4: Create a statement object
            Statement stmt = con.createStatement();
            String sqlQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;

            // step 5: Execute the query
            stmt.executeUpdate(sqlQuery);

            // step 6: Process the results
            System.out.println("Database '" + dbName + "'created successfully (if it did not exist).");

            // step 7: Close the connection
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
