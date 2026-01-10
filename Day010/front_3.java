package Day010;

import java.awt.*;
import javax.swing.*;

public class front_3 extends JFrame {

    JLabel l1, l2;
    JTextField tf1, tf2;
    JButton b1, b2, b3;
    JFrame jf;

    public front_3() {
        jf = new JFrame("FlowLayout");
        jf.setSize(400, 150);
        l1 = new JLabel("Enter Username");
        l2 = new JLabel("Enter City");
        // default text field size 20
        tf1 = new JTextField(15);
        tf2 = new JTextField(15);
        b1 = new JButton("Clear");
        b2 = new JButton("Submit");
        b3 = new JButton("Exit");

        jf.add(l1);
        jf.add(tf1);
        jf.add(l2);
        jf.add(tf2);
        jf.add(b1);
        jf.add(b2);
        jf.add(b3);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new front_3();
    }
}
