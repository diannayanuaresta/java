import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Dianna Yanuaresta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("logoig.jpg");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(51, 200, 255));
        // new MyFrame();

        JLabel label = new JLabel();
        label.setText("I'm Dianna");
        label.setHorizontalTextPosition(JLabel.CENTER);// set text
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(152,251,152));

        frame.add(label);

    }

}