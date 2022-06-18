package frame1;
import javax.swing.JFrame;

public class Frame1 extends JFrame{
    public static void main(String[] args) {
        Frame1 frame1 = new Frame1();
        frame1.initialize();
    }

    public void initialize() {
        JFrame mainPanel = new JFrame();
        mainPanel.setSize(600, 400);
        mainPanel.setTitle("Program Utama");
        mainPanel.setVisible(true);
        mainPanel.setLocationRelativeTo(null);
        
    }
}