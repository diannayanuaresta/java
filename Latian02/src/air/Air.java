package air;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Air extends JFrame implements ActionListener {
    private JPanel pPgw = new JPanel();
    private JLabel lNo = new JLabel("NO PELANGGAN"),
            lNama = new JLabel("Nama"),
            lNik = new JLabel("NIK"),
            lGol = new JLabel("Gol: (1,2,3)"),
            lAlamat = new JLabel("Alamat"),
            ljmlPakai = new JLabel("Jml Pakai"),
            lbiayaPakai = new JLabel("Bi. Pakai"),
            lbiayaAdmin = new JLabel("Bi. Administrasi"),
            lPajak = new JLabel("Pajak"),
            ltotalBayar = new JLabel("Total Bayar"),
            lcreate = new JLabel("create by Dianna Yanuaresta dan NIM A12.2020.06425");
    private JTextField fNo = new JTextField(),
            fNama = new JTextField(),
            fNik = new JTextField(),
            fGol = new JTextField(),
            fAlamat = new JTextField(),
            fjmlPakai = new JTextField(),
            fbiayaPakai = new JTextField(),
            fbiayaAdmin = new JTextField(),
            fPajak = new JTextField(),
            ftotalBayar = new JTextField();
    private JButton btnHitung = new JButton("Hitung"),
            btnHapus = new JButton("Hapus"),
            btnSelesai = new JButton("Selesai");

    public Air() {
        setPreferredSize(new Dimension(600, 700));
        setTitle("Perhitungan pembayaran Air");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane pPgw = new JDesktopPane();

        // mengatur letak label
        lNo.setBounds(15, 50, 100, 25);
        lNama.setBounds(15, 100, 100, 25);
        lNik.setBounds(15, 150, 100, 25);
        lGol.setBounds(15, 200, 100, 25);
        lAlamat.setBounds(15, 250, 100, 25);
        ljmlPakai.setBounds(15, 300, 100, 25);
        lbiayaPakai.setBounds(15, 350, 100, 25);
        lbiayaAdmin.setBounds(15, 400, 100, 25);
        lPajak.setBounds(15, 450, 100, 25);
        ltotalBayar.setBounds(15, 500, 100, 25);
        lcreate.setBounds(250, 630, 300, 25);

        // megatur letak text field
        fNo.setBounds(150, 50, 180, 25);
        fNama.setBounds(150, 100, 180, 25);
        fNik.setBounds(150, 150, 180, 25);
        fGol.setBounds(150, 200, 180, 25);
        fAlamat.setBounds(150, 250, 180, 25);
        fjmlPakai.setBounds(150, 300, 180, 25);
        fbiayaPakai.setBounds(150, 350, 180, 25);
        fbiayaAdmin.setBounds(150, 400, 180, 25);
        fPajak.setBounds(150, 450, 180, 25);
        ftotalBayar.setBounds(150, 500, 180, 25);

        // letak button
        btnHitung.setBounds(150, 550, 100, 25);
        btnHapus.setBounds(280, 550, 100, 25);
        btnSelesai.setBounds(410, 550, 100, 25);

        // Mengaturobjek untuk dapat berinteraksi
        btnHapus.addActionListener((ActionListener) this);
        btnHitung.addActionListener((ActionListener) this);
        btnSelesai.addActionListener((ActionListener) this);

        // addcomponent
        pPgw.add(lNo);
        pPgw.add(lNama);
        pPgw.add(lNik);
        pPgw.add(lGol);
        pPgw.add(lAlamat);
        pPgw.add(ljmlPakai);
        pPgw.add(lbiayaPakai);
        pPgw.add(lbiayaAdmin);
        pPgw.add(lPajak);
        pPgw.add(ltotalBayar);
        pPgw.add(lcreate);

        pPgw.add(fNo);
        pPgw.add(fNama);
        pPgw.add(fNik);
        pPgw.add(fGol);
        pPgw.add(fAlamat);
        pPgw.add(fjmlPakai);
        pPgw.add(fbiayaPakai);
        pPgw.add(fbiayaAdmin);
        pPgw.add(fPajak);
        pPgw.add(ftotalBayar);

        pPgw.add(btnHitung);
        pPgw.add(btnHapus);
        pPgw.add(btnSelesai);

        btnHapus.setEnabled(true);
        btnHitung.setEnabled(true);
        btnSelesai.setEnabled(true);
        // menambahkan objek panel (pPgw) ke container frame
        getContentPane().add(pPgw).setBackground(Color.getHSBColor(100, 150, 75));

        // menampilkan frame ke layar monitor
        pack();
        // Hapus();
    }

    public static void main(String[] args) {
        new Air().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == btnHapus) {
            Hapus();
        }
        if (obj == btnSelesai) {
            Selesai();
        }
        if (obj == btnHitung) {
            Hitung();
        }

    }

    void Hitung() {
        if (fGol.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Input golongan kosong");
        } else {
            if (fjmlPakai.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Input jumlah pakai kosong");
            } else {
                // biaya pakai
                int biaya_pakai = Integer.parseInt(fjmlPakai.getText()) * 500;
                fbiayaPakai.setText(String.valueOf(biaya_pakai));

                int biaya_admin = 0;
                int gol = Integer.parseInt(fGol.getText());
                if (gol == 1) {
                    biaya_admin = 15000;
                }
                if (gol == 2) {
                    biaya_admin = 10000;
                }
                if (gol == 3) {
                    biaya_admin = 5000;
                }
                fbiayaAdmin.setText(String.valueOf(biaya_admin));

                double pajak = (biaya_pakai + biaya_admin) / 20;
                fPajak.setText(String.valueOf(pajak));

                double total = biaya_pakai + biaya_admin + pajak;
                ftotalBayar.setText(String.valueOf(total));
            }
        }

    }

    void Selesai() {
        System.exit(0);
    }

    void Hapus() {
        fNo.setText("");
        fNama.setText("");
        fNik.setText("");
        fAlamat.setText("");
        fGol.setText("");
        fjmlPakai.setText("");
        fbiayaPakai.setText("");
        fbiayaAdmin.setText("");
        fPajak.setText("");
        ftotalBayar.setText("");

    }
}
