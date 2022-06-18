package gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Checkbox extends JFrame {
    Checkbox() {
        JCheckBox jcb = new JCheckBox("Membaca");
        add(jcb);
        jcb = new JCheckBox("Traveling");
        add(jcb);
        jcb = new JCheckBox("Games");
        add(jcb);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Checkbox();
    }

}
