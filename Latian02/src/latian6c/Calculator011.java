package latian6c;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator011 extends JFrame implements ActionListener {
    private JPanel jpCalculator = new JPanel();
    private JTextField fLayar = new JTextField();
    private JLabel labelmhs = new JLabel("NIM : A12.2020.06425 Nama : Dianna Yanuaresta");
    private JButton btnTambah = new JButton("+"), btnKurang = new JButton("-"), btnC = new JButton("C"),
            btn1 = new JButton("1"), btn2 = new JButton("2"), btn3 = new JButton("3"), btn4 = new JButton("4"),
            btn5 = new JButton("5"), btn6 = new JButton("6"), btn7 = new JButton("7"), btn8 = new JButton("8"),
            btn9 = new JButton("9"), btn0 = new JButton("0"), btnBagi = new JButton("/"), btnKali = new JButton("*"),
            btnTitik = new JButton("."), btnSama = new JButton("=");

    private String isiLayar = "";
    private String snilai1, snilai2, tombol;
    private double hasil;
    Font font1 = new Font("SanSerif", Font.BOLD, 24);

    public Calculator011() {
        setPreferredSize(new Dimension(500, 600));
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new BorderLayout();
        JDesktopPane jpCalculator = new JDesktopPane();
        add(jpCalculator, BorderLayout.CENTER);

        // Mengatur letak objek di Container
        fLayar.setBounds(50, 50, 400, 50);
        fLayar.setFont(font1);
        labelmhs.setBounds(50, 445, 500, 50);

        // mengatur letak objek Button di Container
        btnC.setBounds(350, 130, 85, 50);
        btnKali.setBounds(350, 195, 85, 50);
        btnBagi.setBounds(350, 260, 85, 50);
        btnTambah.setBounds(350, 315, 85, 50);
        btnKurang.setBounds(350, 380, 85, 50);

        btn9.setBounds(250, 195, 85, 50);
        btn6.setBounds(250, 260, 85, 50);
        btn3.setBounds(250, 315, 85, 50);
        btnSama.setBounds(250, 380, 85, 50);

        btn8.setBounds(150, 195, 85, 50);
        btn5.setBounds(150, 260, 85, 50);
        btn2.setBounds(150, 315, 85, 50);
        btnTitik.setBounds(150, 380, 85, 50);

        btn7.setBounds(50, 195, 85, 50);
        btn4.setBounds(50, 260, 85, 50);
        btn1.setBounds(50, 315, 85, 50);
        btn0.setBounds(50, 380, 85, 50);

        fLayar.setHorizontalAlignment(JTextField.RIGHT);

        // Objek button di nonaktif dan atkifkan
        btnTambah.setEnabled(true);

        // Mengatur objek untuk berinteraksi
        btn1.addActionListener((java.awt.event.ActionListener) this);
        btn2.addActionListener((java.awt.event.ActionListener) this);
        btn3.addActionListener((java.awt.event.ActionListener) this);
        btn4.addActionListener((java.awt.event.ActionListener) this);
        btn5.addActionListener((java.awt.event.ActionListener) this);
        btn6.addActionListener((java.awt.event.ActionListener) this);
        btn7.addActionListener((java.awt.event.ActionListener) this);
        btn8.addActionListener((java.awt.event.ActionListener) this);
        btn9.addActionListener((java.awt.event.ActionListener) this);
        btn0.addActionListener((java.awt.event.ActionListener) this);

        btnC.addActionListener((java.awt.event.ActionListener) this);
        btnSama.addActionListener((java.awt.event.ActionListener) this);
        btnTambah.addActionListener((java.awt.event.ActionListener) this);
        btnBagi.addActionListener((java.awt.event.ActionListener) this);
        btnKali.addActionListener((java.awt.event.ActionListener) this);
        btnKurang.addActionListener((java.awt.event.ActionListener) this);
        btnTitik.addActionListener((java.awt.event.ActionListener) this);

        // meletakkan seluruh kontrol pada objek panel
        jpCalculator.add(fLayar);
        jpCalculator.add(labelmhs);

        jpCalculator.add(btn1);
        jpCalculator.add(btn2);
        jpCalculator.add(btn3);
        jpCalculator.add(btn4);
        jpCalculator.add(btn5);
        jpCalculator.add(btn6);
        jpCalculator.add(btn7);
        jpCalculator.add(btn8);
        jpCalculator.add(btn9);
        jpCalculator.add(btn0);

        jpCalculator.add(btnTambah);
        jpCalculator.add(btnKurang);
        jpCalculator.add(btnBagi);
        jpCalculator.add(btnKali);
        jpCalculator.add(btnTitik);
        jpCalculator.add(btnC);
        jpCalculator.add(btnSama);

        // menambahkan objek panel (jpCalculator) ke Container frame
        getContentPane().add(jpCalculator).setBackground(Color.getHSBColor(20, 10, 5));

        // menampilakan frame ke layar monitor;
        pack();
        setVisible(true);

    }

    // fungsi jika user melakukan action tombol
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == btnC) {
            tombol = "";
            snilai1 = "";
            snilai2 = "";
            isiLayar = "";
            fLayar.setText(isiLayar);
        }

        if (obj == btn1) {
            isiLayar = isiLayar + "1";
            fLayar.setText(isiLayar);
        }

        if (obj == btn2) {
            isiLayar = isiLayar + "2";
            fLayar.setText(isiLayar);
        }

        if (obj == btn3) {
            isiLayar = isiLayar + "3";
            fLayar.setText(isiLayar);
        }

        if (obj == btn4) {
            isiLayar = isiLayar + "4";
            fLayar.setText(isiLayar);
        }

        if (obj == btn5) {
            isiLayar = isiLayar + "5";
            fLayar.setText(isiLayar);
        }

        if (obj == btn6) {
            isiLayar = isiLayar + "6";
            fLayar.setText(isiLayar);
        }

        if (obj == btn7) {
            isiLayar = isiLayar + "7";
            fLayar.setText(isiLayar);
        }

        if (obj == btn8) {
            isiLayar = isiLayar + "8";
            fLayar.setText(isiLayar);
        }

        if (obj == btn9) {
            isiLayar = isiLayar + "9";
            fLayar.setText(isiLayar);
        }

        if (obj == btn0) {
            isiLayar = isiLayar + "0";
            fLayar.setText(isiLayar);
        }

        if (obj == btnTitik) {
            isiLayar = isiLayar + ".";
            fLayar.setText(isiLayar);
        }

        if (obj == btnTambah) {
            tombol = "tambah";
            snilai1 = fLayar.getText();
            isiLayar = "";
            fLayar.setText(isiLayar);
        }

        if (obj == btnKurang) {
            tombol = "kurang";
            snilai1 = fLayar.getText();
            isiLayar = "";
            fLayar.setText("");
        }

        if (obj == btnKali) {
            tombol = "kali";
            snilai1 = fLayar.getText();
            isiLayar = "";
            fLayar.setText("");
        }

        if (obj == btnBagi) {
            tombol = "bagi";
            snilai1 = fLayar.getText();
            isiLayar = "";
            fLayar.setText("");
        }

        if (obj == btnSama) {

            snilai2 = fLayar.getText();
            // saat ditekan tombol sama dengan
            // sebelum operator yang digunakan tambah
            hasil = operation(Double.parseDouble(snilai1), Double.parseDouble(snilai2), tombol);
            String shasil = "" + hasil;
            fLayar.setText(shasil);
            snilai1 = Double.toString(hasil);
        }

    }

    // Fungsi untuk mengosogkan Objek layar tampilan

    void kosong() {
        fLayar.setText("");
        fLayar.requestFocus();
    }

    Double operation(Double a, Double b, String tombol) {
        if (tombol == "tambah") {
            return a + b;
        }
        if (tombol == "kurang") {
            return a - b;
        }
        if (tombol == "kali") {
            return a * b;
        }
        if (tombol == "bagi") {
            return a / b;
        }

        return b;

    }

    public static void main(String[] args) {
        new Calculator011().setVisible(true);
    }

}
