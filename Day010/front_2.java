package Day010;

import java.awt.event.*;
import java.awt.*;

public class front_2 extends Frame {
    Label l;

    public front_2() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        l = new Label("Window Closing Example");
        this.add(l);
        setTitle("Suraj");
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new front_2();
    }
}
