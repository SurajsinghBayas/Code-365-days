package JDBC;

import java.sql.*;
import java.util.Random;

public class app {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nkocet";
        String user = "root";
        String password = "4530241";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to the database: " + url);

            Statement stmt = con.createStatement();

            // Step 0: Create std_nkocet table if not exists
            String createStdTable = "CREATE TABLE IF NOT EXISTS std_nkocet (roll_no INT PRIMARY KEY, name VARCHAR(100), marks FLOAT)";
            stmt.executeUpdate(createStdTable);
            System.out.println("Table 'std_nkocet' created successfully (if it did not exist).\n");

            // Insert dummy data into std_nkocet
            String insertStd = "INSERT INTO std_nkocet (roll_no, name, marks) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE name=VALUES(name), marks=VALUES(marks)";
            PreparedStatement stdInsert = con.prepareStatement(insertStd);
            Object[][] stdData = {
                    { 1, "Elon Musk", 91.5f },
                    { 2, "Taylor Swift", 85.0f },
                    { 3, "Cristiano Ronaldo", 78.2f },
                    { 4, "Lionel Messi", 88.8f },
                    { 5, "Virat Kohli", 95.3f },
                    { 6, "Beyoncé", 67.4f },
                    { 7, "Dwayne Johnson", 82.1f },
                    { 8, "Rihanna", 90.0f },
                    { 9, "MrBeast", 76.6f },
                    { 10, "Oprah Winfrey", 89.9f }
            };
            for (Object[] row : stdData) {
                stdInsert.setInt(1, (int) row[0]);
                stdInsert.setString(2, (String) row[1]);
                stdInsert.setFloat(3, (float) row[2]);
                stdInsert.executeUpdate();
            }
            stdInsert.close();
            System.out.println("Dummy data inserted into 'std_nkocet'.\n");

            // Step 1: Create stipend table if not exists
            String createStipendTable = "CREATE TABLE IF NOT EXISTS stipend (std_id INT PRIMARY KEY, name VARCHAR(100), salary FLOAT)";
            stmt.executeUpdate(createStipendTable);
            System.out.println("Table 'stipend' created successfully (if it did not exist).\n");

            // Step 2: Copy names from std_nkocet and insert random salary
            String selectStudents = "SELECT roll_no, name FROM std_nkocet";
            ResultSet rs = stmt.executeQuery(selectStudents);
            PreparedStatement stipendInsert = con.prepareStatement(
                    "INSERT INTO stipend (std_id, name, salary) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE name=VALUES(name), salary=VALUES(salary)");
            Random rand = new Random();
            int count = 0;
            while (rs.next()) {
                int id = rs.getInt("roll_no");
                String name = rs.getString("name");
                float salary = 5000 + rand.nextFloat() * 5000; // random salary between 5000-10000
                stipendInsert.setInt(1, id);
                stipendInsert.setString(2, name);
                stipendInsert.setFloat(3, salary);
                stipendInsert.executeUpdate();
                count++;
            }
            stipendInsert.close();
            System.out.println("Inserted/updated " + count + " records into 'stipend' table.\n");

            stmt.close();
            con.close();
            System.out.println("Done. You can now use the stipend table in your AWT application.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
