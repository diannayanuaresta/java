package gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ComboBox extends JFrame {
    String name[] = { "Semarang", "Surabaya", "Pati" };

    ComboBox() {
        JComboBox jcb = new JComboBox(name);
        add(jcb);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBox();
    }

}
