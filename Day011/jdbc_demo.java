package Day011;

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
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
