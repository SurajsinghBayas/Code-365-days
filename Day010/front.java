package Day010;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class front extends Frame {
    public front() {

        Button B = new Button("slap me");
        B.setBounds(30, 100, 100, 30);
        add(B);

        setSize(300, 300);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new front();
    }
}
