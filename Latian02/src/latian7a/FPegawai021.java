package latian7a;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import database.Database;

public class FPegawai021 extends JFrame implements ActionListener {
    private JPanel pPgw = new JPanel();
    private JLabel lNip = new JLabel(),
            lNama = new JLabel(),
            lBagian = new JLabel(),
            lcreate = new JLabel(),
            alert = new JLabel();
    private JTextField fNip = new JTextField(),
            fNama = new JTextField(),
            fBagian = new JTextField();
    private JButton btnAdd = new JButton(),
            btnCari = new JButton(),
            btnKoreksi = new JButton(),
            btnHapus = new JButton(),
            btnSelesai = new JButton();
    Database db = new Database();
    int confirm = 0;

    public FPegawai021() {
        setPreferredSize(new Dimension(450, 400));
        setTitle("Data Pegawai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDesktopPane pPgw = new JDesktopPane();

        // MENGATUR LETAK OBJEK LABEL DI CONTAINER
        lNip.setBounds(15, 20, 100, 25);
        lNip.setText("NIP");
        lNama.setBounds(15, 55, 100, 25);
        lNama.setText("Nama");
        lBagian.setBounds(15, 90, 100, 25);
        lBagian.setText("Bagian");
        alert.setBounds(15, 225, 300, 25);
        lcreate.setBounds(15, 325, 300, 25);
        lcreate.setText("create by Dianna Yanuaresta, NIM A12.2020.06425");

        // MENGATUR LETAK OBJEK TEXT di Container
        fNip.setBounds(115, 20, 100, 25);
        fNama.setBounds(115, 55, 205, 25);
        fBagian.setBounds(115, 90, 92, 25);
        fNip.setToolTipText("Isi NIP dengan Angka");

        // MENGATUR LETAK OBJEK BUTTON DI ANGKA
        btnAdd.setBounds(20, 150, 85, 25);
        btnAdd.setText("Add");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.getHSBColor(250, 0, 250));
        btnCari.setBounds(120, 150, 85, 25);
        btnCari.setText("Cari");
        btnKoreksi.setBounds(220, 150, 85, 25);
        btnKoreksi.setText("Koreksi");
        btnHapus.setBounds(220, 180, 85, 25);
        btnHapus.setText("Hapus");
        btnSelesai.setBounds(320, 150, 85, 60);
        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");

        // Objek Button di Non aktifkan dan di Aktifkan
        btnAdd.setEnabled(true);
        btnHapus.setEnabled(true);
        btnKoreksi.setEnabled(true);
        btnSelesai.setEnabled(true);

        // Mengaturobjek untuk dapat berinteraksi
        btnAdd.addActionListener((ActionListener) this);
        btnCari.addActionListener((ActionListener) this);
        btnKoreksi.addActionListener((ActionListener) this);
        btnHapus.addActionListener((ActionListener) this);
        btnSelesai.addActionListener((ActionListener) this);

        // meletakkan seluruh kontrol pada objek panel
        pPgw.add(lNip);
        pPgw.add(fNip);
        pPgw.add(lNama);
        pPgw.add(fNama);
        pPgw.add(lBagian);
        pPgw.add(fBagian);
        pPgw.add(lcreate);
        pPgw.add(alert);
        pPgw.add(btnAdd);
        pPgw.add(btnCari);
        pPgw.add(btnHapus);
        pPgw.add(btnKoreksi);
        pPgw.add(btnSelesai);

        // menambahkan objek panel (pPgw) ke container frame
        getContentPane().add(pPgw).setBackground(Color.getHSBColor(100, 150, 75));

        // menampilkan frame ke layar monitor
        pack();
        Kosong();

    }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        if (obj == btnAdd) {
            if (btnAdd.getText() != "Simpan") {
                Add();
            }
        } else {
            Kosong();
            btnAdd.setText("Simpan");
            btnAdd.setForeground(Color.getHSBColor(100, 10, 0));
            btnAdd.setBackground(Color.getHSBColor(200, 100, 100));
        }

        if (obj == btnCari) {
            String xCari = JOptionPane.showInputDialog(this, "Masukkan NIP !");
            if (xCari != null) {
                String rs = Cari(xCari);
                alert.setText(rs);

            } else {
                JOptionPane.showMessageDialog(this, "Nip kosong !");
            }
        }

        if (obj == btnKoreksi) {
            if (btnKoreksi.getText() != "Simpan") {
                String m = JOptionPane.showInputDialog("Masukkan NIP yang akan diedit?");
                fNip.setText(m);
                btnKoreksi.setText("Simpan");
                setTombol(0, 0, 1, 0, 0);
            } else {
                Koreksi(fNip.getText(), fNama.getText(), fBagian.getText());
                btnKoreksi.setText("Koreksi");
                setTombol(1, 1, 1, 1, 1);
            }
        }

        if (obj == btnHapus) {
            String m = JOptionPane.showInputDialog("NIP yang akan dihapus?");
            confirm = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus ?",
                    "Gagal menghapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Hapus(m);
            } else {
            }
        }

        if (obj == btnSelesai) {
            System.exit(0);
        }
    }

    void Add() {
        try {
            String nip = fNip.getText();
            String nama = fNama.getText();
            String bagian = fBagian.getText();
            if (nip.length() == 0) {
                alert.setText("NIP Kosong");
            } else {
                if (nama.length() == 0) {
                    alert.setText("Nama Kosong");
                } else {
                    if (bagian.length() == 0) {
                        alert.setText("Bagian Kosong");
                    } else {
                        if (db.addData(nip, nama, bagian) == 1) {
                            alert.setText("Penambahan berhasil");
                            JOptionPane.showMessageDialog(this, "Penambahan berhasil !");
                            Kosong();
                        } else {
                            alert.setText("Penambahan gagal");
                            confirm = JOptionPane.showConfirmDialog(this, "Perbaiki data yang diinputkan ?",
                                    "Gagal menambahkan", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {

                            } else {
                                Kosong();
                                JOptionPane.showMessageDialog(this, "Data dibersihkan !");
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Penambahan Gagal");
        }
    }

    void Kosong() {
        fNip.setText("");
        fNama.setText("");
        fBagian.setText("");
        fNip.requestFocus();
    }

    void Hapus(String nip) {
        try {
            if (db.hapusData(nip) == 1) {
                JOptionPane.showMessageDialog(this, "Penghapusan berhasil !");

            } else {
                JOptionPane.showMessageDialog(this, "Penghapusan gagal !");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Penghapusan Gagal");
        }
    }

    void Koreksi(String nip, String nama, String bagian) {
        try {
            if (db.updateData(nip, nama, bagian) == 1) {
                JOptionPane.showMessageDialog(this, "Update berhasil !");
                Kosong();
            } else {
                JOptionPane.showMessageDialog(this, "Update gagal !");
                Kosong();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update Gagal");
        }
    }

    String Cari(String nip) {
        String result = db.cariData("SELECT * FROM pegawai WHERE nip=" + nip);
        return result;
    }

    void setTombol(int a, int b, int c, int d, int e) {
        btnAdd.setEnabled(a >= 1 ? true : false);
        btnCari.setEnabled(b >= 1 ? true : false);
        btnKoreksi.setEnabled(c >= 1 ? true : false);
        btnHapus.setEnabled(d >= 1 ? true : false);
        btnSelesai.setEnabled(e >= 1 ? true : false);
    }

    public static void main(String[] args) {
        new FPegawai021().setVisible(true);
    }
}
