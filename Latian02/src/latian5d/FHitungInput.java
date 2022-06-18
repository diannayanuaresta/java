package latian5d;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FHitungInput extends JFrame implements ActionListener, java.awt.event.ActionListener {
    private JPanel pPgw = new JPanel();
    private JLabel lNilai1 = new JLabel(), lNilai2 = new JLabel(), lHasil = new JLabel(), lcreate = new JLabel();
    private JTextField fNilai1 = new JTextField(), fNilai2 = new JTextField(), fHasil = new JTextField();
    private JButton btnTambah = new JButton(), btnKurang = new JButton(), btnBersih = new JButton(),
            btnSelesai = new JButton(), btnKali = new JButton(), btnBagi = new JButton();

    public FHitungInput() {
        setPreferredSize(new Dimension(459, 280));
        setTitle("Form Hitung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane pPgw = new JDesktopPane();

        // mengatur letak objek Label di Container
        lNilai1.setBounds(15, 20, 100, 25);
        lNilai1.setText("Nilai 1");
        lNilai2.setBounds(15, 55, 100, 25);
        lNilai2.setText("Nilai 2");
        lHasil.setBounds(15, 90, 100, 25);
        lHasil.setText("Hasil");
        lcreate.setBounds(150, 210, 300, 25);
        lcreate.setText("Create by Dianna Yanuaresta (A12.2020.06425)");

        // Mengatur letak objek text di Container
        fNilai1.setBounds(115, 20, 100, 25);
        fNilai2.setBounds(115, 55, 205, 25);
        fHasil.setBounds(115, 90, 92, 25);
        fNilai1.setToolTipText("Isi Nilai dengan Angka ! ");

        // Mengatur letak button di Container
        btnTambah.setBounds(50, 150, 85, 25);
        btnTambah.setText("Tambah");
        btnTambah.setBackground(Color.red);
        btnTambah.setForeground(Color.getHSBColor(50, 0, 55));
        btnKurang.setBounds(150, 150, 85, 25);
        btnKurang.setText("Kurang");
        btnBersih.setBounds(250, 150, 75, 25);
        btnBersih.setText("Bersih");
        btnSelesai.setBounds(335, 150, 80, 25);
        btnSelesai.setText("Selesai");
        btnKali.setBounds(50, 180, 85, 25);
        btnKali.setText("Kali");
        btnBagi.setBounds(150, 180, 85, 25);
        btnBagi.setText("Bagi");
        btnSelesai.setToolTipText("Mengakhiri Program");

        // Objek button di Nonaktifkan dan di Aktifkan
        btnTambah.setEnabled(true);
        btnSelesai.setEnabled(true);

        // Mengatur objek untuk dapat berinteraksi
        btnTambah.addActionListener(this);
        btnKurang.addActionListener(this);
        btnKali.addActionListener(this);
        btnBagi.addActionListener(this);
        btnBersih.addActionListener(this);
        btnSelesai.addActionListener(this);

        // meletakkan selruh kontrol pada onjek panel
        pPgw.add(lNilai1);
        pPgw.add(fNilai1);
        pPgw.add(lNilai2);
        pPgw.add(fNilai2);
        pPgw.add(lHasil);
        pPgw.add(fHasil);
        pPgw.add(lcreate);
        pPgw.add(btnKurang);
        pPgw.add(btnTambah);
        pPgw.add(btnBagi);
        pPgw.add(btnKali);
        pPgw.add(btnBersih);
        pPgw.add(btnSelesai);

        // menambahkan objek panel (Ppgr) ke container frame
        getContentPane().add(pPgw).setBackground(Color.getHSBColor(250, 0, 250));

        // menampilkan frame ke layar monitor
        pack();

    }

    public static void main(String[] args) {
        new FHitungInput().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == btnTambah) {
            methodTambah();
        }
        if (obj == btnKurang) {
            methodKurang();
        }
        if (obj == btnKali) {
            methodKali();
        }
        if (obj == btnBagi) {
            methodBagi();
        }
        if (obj == btnBersih) {
            kosong();
        }
        if (obj == btnSelesai) {
            System.exit(0);
        }
    }

    void methodTambah() {
        int xhasil = Integer.parseInt(fNilai1.getText()) + Integer.parseInt(fNilai2.getText());
        fHasil.setText(Integer.toString(xhasil));
    }

    void methodKurang() {
        int xhasil = Integer.parseInt(fNilai1.getText()) - Integer.parseInt(fNilai2.getText());
        fHasil.setText(Integer.toString(xhasil));
    }
    
    void methodKali() {
        int xhasil = Integer.parseInt(fNilai1.getText()) * Integer.parseInt(fNilai2.getText());
        fHasil.setText(Integer.toString(xhasil));
    }
    void methodBagi() {
        int xhasil = Integer.parseInt(fNilai1.getText()) / Integer.parseInt(fNilai2.getText());
        fHasil.setText(Integer.toString(xhasil));
    }

    void kosong (){
        fNilai1.setText("");
        fNilai2.setText("");
        fHasil.setText("");
        fNilai1.requestFocus();
    }
}
