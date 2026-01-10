
package Day010;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

import javax.swing.*;

public class front4 extends JFrame implements ActionListener {
    CardLayout cd;
    JPanel PP;
    JFrame jf;

    public front4() {
        jf = new JFrame("Card Layout Example");
        cd = new CardLayout();
        setTitle("Card Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        cd = new CardLayout();
        PP = new JPanel(cd);

        // Creating two child panels
        JPanel cp1 = new JPanel();
        JPanel cp2 = new JPanel();

        // Creating parent buttons
        JButton b1 = new JButton("Numbers");
        JButton b2 = new JButton("Alphabet");

        // Sub buttons for Numbers
        JButton b3 = new JButton("1");
        JButton b4 = new JButton("2");
        JButton b5 = new JButton("3");

        // Sub buttons for Alphabet
        JButton b6 = new JButton("A");
        JButton b7 = new JButton("B");
        JButton b8 = new JButton("C");

        // Add sub buttons to panels
        cp1.add(b3);
        cp1.add(b4);
        cp1.add(b5);
        cp2.add(b6);
        cp2.add(b7);
        cp2.add(b8);

        PP.setLayout(cd);
        // Add child panels to card panel with names
        PP.add(cp1, "Numbers");
        PP.add(cp2, "Alphabet");

        // Top panel for parent buttons

        // Add listeners to switch cards
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Setting Container JFrame's
        // Layout to FlowLayout
        jf.setLayout(new FlowLayout());

        // adding Two Buttons To Jframe
        // these buttons will remian commenly on top
        // Visible to all panels
        jf.add(b1);
        jf.add(b2);
        jf.add(PP);

        jf.setSize(300, 200);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Numbers") {
            cd.show(PP, "Numbers");

        } else {
            cd.show(PP, "Alphabet");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(front4::new);
    }
}
