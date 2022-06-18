package gui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class List {
    List() {
        JFrame list_f = new JFrame();
        DefaultListModel<String> list_l1 = new DefaultListModel<>();
        list_l1.addElement("Jeruk");
        list_l1.addElement("Pisang");
        list_l1.addElement("Apel");

        JList<String> list1 = new JList<>(list_l1);
        list1.setBounds(50, 50, 100, 60);
        list_f.add(list1);
        list_f.setSize(360, 220);
        list_f.setLayout(null);
        list_f.setVisible(true);
    }

    public static void main(String[] args) {
        new List();
    }

}
