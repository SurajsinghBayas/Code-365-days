package JDBC;

// most used imports for JDBC
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.sql.*;

public class jdbc_demo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nkocet";
        String user = "root";
        String password = "4530241";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step 3: Connect to the database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to the database: " + url);

            // Step 4: Create a statement object
            Statement stmt = con.createStatement();
            String sqlQuery = "Create table if not exists std_nkocet (roll_no int primary key, name varchar(100), marks float)";
            // Step 5: Execute the query
            stmt.executeUpdate(sqlQuery);
            // Step 6: Process the results
            System.out.println("Table 'std_nkocet' created successfully (if it did not exist).");

            // Step 4: Create PreparedStatement object (Insert Query)
            String insertQuery = "INSERT INTO std_nkocet (roll_no, name, marks) VALUES (?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE name=VALUES(name), marks=VALUES(marks)";

            // Step 5: Execute the query
            PreparedStatement pstmt = con.prepareStatement(insertQuery);

            // inseting first row
            pstmt.setInt(1, 14);
            pstmt.setString(2, "onkar");
            pstmt.setFloat(3, 10.99f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 15);
            pstmt.setString(2, "Lan de ray");
            pstmt.setFloat(3, 90f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 16);
            pstmt.setString(2, "Virat kohli");
            pstmt.setFloat(3, 85.45f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 17);
            pstmt.setString(2, "Rohit sharma");
            pstmt.setFloat(3, 95.67f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 18);
            pstmt.setString(2, "ananya pandey");
            pstmt.setFloat(3, 88.88f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 19);
            pstmt.setString(2, "sachin tendulkar");
            pstmt.setFloat(3, 99.99f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 20);
            pstmt.setString(2, "Modi");
            pstmt.setFloat(3, 77.77f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 21);
            pstmt.setString(2, "Amitabh bachchan");
            pstmt.setFloat(3, 89.56f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 22);
            pstmt.setString(2, "Shahrukh khan");
            pstmt.setFloat(3, 91.34f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 23);
            pstmt.setString(2, "Messi");
            pstmt.setFloat(3, 78.45f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 24);
            pstmt.setString(2, "Trump");
            pstmt.setFloat(3, 74.56f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 25);
            ;
            pstmt.setString(2, "Elon musk");
            pstmt.setFloat(3, 92.34f);

            pstmt.setInt(1, 26);
            ;
            pstmt.setString(2, "JEFFRY EPSTINE");
            pstmt.setFloat(3, 81.23f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 27);
            ;
            pstmt.setString(2, "Mark zuckerberg");
            pstmt.setFloat(3, 87.45f);
            pstmt.executeUpdate();

            pstmt.setInt(1, 28);
            ;
            pstmt.setString(2, "Bill gates");
            pstmt.setFloat(3, 93.67f);
            pstmt.executeUpdate();

            System.out.println("All rows inserted or updated successfully in the table 'std_nkocet'.");

            // Step 7: Close the connection
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
