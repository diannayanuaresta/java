package gui;

import javax.swing.*;

public class PasswordField {
    public static void main(String[] args) {
        JFrame password_f = new JFrame("Password field Demo");
        JPasswordField password_value = new JPasswordField();
        JLabel password_l1 = new JLabel("Password");
        password_l1.setBounds(20, 40, 100, 30);
        password_value.setBounds(100, 40, 100, 30);
        password_f.add(password_value);
        password_f.add(password_l1);
        password_f.setSize(360, 220);
        password_f.setLayout(null);
        password_f.setVisible(true);
    }

}
