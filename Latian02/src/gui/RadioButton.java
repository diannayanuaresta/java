package gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RadioButton extends JFrame {
    RadioButton() {
        JRadioButton jcb = new JRadioButton("Laki-laki");
        add(jcb);
        jcb = new JRadioButton("Perempuan");
        add(jcb);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RadioButton();
    }
}
