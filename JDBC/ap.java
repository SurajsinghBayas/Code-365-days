package JDBC;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ap extends JFrame implements ActionListener {
    // GUI
    JLabel l1, l2, l3;
    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3, b4;

    // JDBC
    Connection con;
    Statement st;
    ResultSet rs;

    ap() {
        // Initialize GUI components first
        setLayout(null);
        l1 = new JLabel("Roll Number");
        l2 = new JLabel("Name");
        l3 = new JLabel("Stipend");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        b1 = new JButton("First");
        b2 = new JButton("Next");
        b3 = new JButton("Prev");
        b4 = new JButton("Last");

        l1.setBounds(100, 50, 100, 30);
        tf1.setBounds(220, 50, 150, 30);

        l2.setBounds(100, 100, 100, 30);
        tf2.setBounds(220, 100, 150, 30);

        l3.setBounds(100, 150, 100, 30);
        tf3.setBounds(220, 150, 150, 30);

        b1.setBounds(50, 220, 80, 30);
        b2.setBounds(140, 220, 80, 30);
        b3.setBounds(230, 220, 80, 30);
        b4.setBounds(320, 220, 80, 30);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(l3);
        add(tf3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        // Database connection
        String url = "jdbc:mysql://localhost:3306/nkocet";
        String user = "root";
        String password = "4530241";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to the database: " + url);

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("SELECT * FROM stipend ORDER BY std_id");

            if (rs.next()) {
                tf1.setText(rs.getString(1));
                tf2.setText(rs.getString(2));
                tf3.setText(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            JButton B = (JButton) ae.getSource();
            if (B == b1) { // First
                rs.first();
            } else if (B == b2) { // Next
                if (!rs.isLast()) {
                    rs.next();
                }
            } else if (B == b3) { // Previous
                if (!rs.isFirst()) {
                    rs.previous();
                }
            } else if (B == b4) { // Last
                rs.last();
            }

            tf1.setText(rs.getString(1));
            tf2.setText(rs.getString(2));
            tf3.setText(rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ap op = new ap();
        op.setTitle("Stipend Viewer");
        op.setSize(450, 320);
        op.setLocationRelativeTo(null);

        op.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        op.setVisible(true);
    }
}