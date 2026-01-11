package JDBC;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class StipendFrame extends Frame implements ActionListener {
    TextField tfId, tfName, tfSalary;
    Button btnFirst, btnNext, btnPrev, btnLast;
    ArrayList<Student> students = new ArrayList<>();
    int current = 0;

    class Student {
        int id;
        String name;
        float salary;

        Student(int id, String name, float salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }

    public StipendFrame() {
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new Label("Roll No:"));
        tfId = new TextField(10);
        add(tfId);
        add(new Label("Name:"));
        tfName = new TextField(20);
        add(tfName);
        add(new Label("Stipend:"));
        tfSalary = new TextField(10);
        add(tfSalary);

        btnFirst = new Button("First");
        add(btnFirst);
        btnPrev = new Button("Previous");
        add(btnPrev);
        btnNext = new Button("Next");
        add(btnNext);
        btnLast = new Button("Last");
        add(btnLast);

        btnFirst.addActionListener(this);
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);

        loadData();
        if (!students.isEmpty())
            showRecord(0);

        setTitle("Stipend Viewer");
        setSize(350, 250);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    void loadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nkocet", "root", "4530241");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stipend ORDER BY std_id");
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("std_id"),
                        rs.getString("name"),
                        rs.getFloat("salary")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showRecord(int idx) {
        if (idx >= 0 && idx < students.size()) {
            Student s = students.get(idx);
            tfId.setText(String.valueOf(s.id));
            tfName.setText(s.name);
            tfSalary.setText(String.format("%.2f", s.salary));
            current = idx;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnFirst)
            showRecord(0);
        else if (ae.getSource() == btnLast)
            showRecord(students.size() - 1);
        else if (ae.getSource() == btnNext && current < students.size() - 1)
            showRecord(current + 1);
        else if (ae.getSource() == btnPrev && current > 0)
            showRecord(current - 1);
    }

    public static void main(String[] args) {
        new StipendFrame();
    }
}
