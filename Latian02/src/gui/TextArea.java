package gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TextArea extends JFrame {
    TextArea() {
        JFrame textArea_f = new JFrame();
        JTextArea textArea_area = new JTextArea("Tuliskan disini");
        textArea_area.setBounds(40, 30, 280, 120);
        textArea_f.add(textArea_area);

        textArea_f.setLayout(null);
        textArea_f.setSize(360, 220);
        textArea_f.setVisible(true);
    }

    public static void main(String[] args) {
        new TextArea();
    }

}
