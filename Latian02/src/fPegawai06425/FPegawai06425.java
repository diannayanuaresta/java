package fPegawai06425;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import koneksidbms.KoneksiDBMS;

public class FPegawai06425 extends JFrame implements ActionListener {
        private JPanel pPgw = new JPanel();
        private JLabel lNip = new JLabel("N I P "),
                        lNama = new JLabel("Nama "),
                        lBagian = new JLabel("Bagian "),
                        lJeniskel = new JLabel("Jenis Kelamin "),
                        lCreate = new JLabel("Created by Dianna Yanuaresta NIM A12.2020.06425");

        private JTextField fNip = new JTextField(),
                        fNama = new JTextField(),
                        fBagian = new JTextField(),
                        fJeniskel = new JTextField();
        private JButton btnAdd = new JButton(),
                        btnCari = new JButton(),
                        btnKoreksi = new JButton(),
                        btnHapus = new JButton(),
                        btnSelesai = new JButton();

        // tambah
        private ResultSet rs;
        String[] header = { "Nip", "Nama", "Bagian", "Jenis Kelamin" };

        DefaultTableModel tabModel;
        JTable tabel = new JTable();
        JScrollPane skrTabel = new JScrollPane();
        String gender[] = { "Laki-laki", "Perempuan" };
        JComboBox gendercb = new JComboBox(gender);

        public FPegawai06425() {
                setPreferredSize(new Dimension(570, 410));
                setTitle("Data Pegawai");

                // set default close operation

                JDesktopPane pPgw = new JDesktopPane();

                // mengatur letak objek label pada container
                lNip.setBounds(20, 20, 100, 25);
                lNama.setBounds(20, 55, 100, 25);
                lBagian.setBounds(20, 90, 100, 25);
                lJeniskel.setBounds(20, 125, 100, 25);
                lCreate.setBounds(230, 225, 200, 25);

                // mengatur letak objek text di kolom
                fNip.setBounds(135, 20, 100, 25);
                fNama.setBounds(135, 55, 205, 25);
                fBagian.setBounds(135, 90, 92, 25);
                // fJeniskel.setBounds(135, 125, 92, 25);
                gendercb.setBounds(135, 125, 92, 25);

                fNip.setToolTipText("Isi Nip dengan Angka");

                // mengatur letak objek Button pada container
                btnAdd.setBounds(20, 320, 85, 25);
                btnAdd.setBackground(Color.green);
                btnAdd.setForeground(Color.getHSBColor(250, 0, 255));
                btnAdd.setText("Add");
                btnCari.setBounds(120, 320, 85, 25);
                btnCari.setText("Cari");
                btnKoreksi.setBounds(220, 320, 85, 25);
                btnKoreksi.setText("Koreksi");
                btnHapus.setBounds(320, 320, 85, 25);
                btnHapus.setText("Hapus");
                btnSelesai.setBounds(435, 320, 85, 25);
                btnSelesai.setText("Selesai");
                btnSelesai.setToolTipText("Mengakhiri Program");

                // membuat tabel
                tabModel = new DefaultTableModel(null, header);
                tabel.setModel(tabModel);
                tabel.setBackground(Color.orange);
                skrTabel.getViewport().add(tabel);
                tabel.setEnabled(true);
                skrTabel.setBounds(20, 175, 500, 125);

                // objek buton di nonaktif dan aktifkan
                btnAdd.setEnabled(true);
                btnSelesai.setEnabled(true);

                // mengatur objek untuk berinteraksi
                btnAdd.addActionListener((ActionListener) this);
                btnCari.addActionListener((ActionListener) this);
                btnKoreksi.addActionListener((ActionListener) this);
                btnHapus.addActionListener((ActionListener) this);
                btnSelesai.addActionListener((ActionListener) this);

                // meletakkan seluruh kontrol
                pPgw.add(skrTabel);
                pPgw.add(lNip);
                pPgw.add(lNama);
                pPgw.add(lBagian);
                pPgw.add(lJeniskel);
                pPgw.add(lCreate);
                pPgw.add(fNip);
                pPgw.add(fNama);
                // pPgw.add(fJeniskel);
                pPgw.add(gendercb);
                pPgw.add(fBagian);

                pPgw.add(btnAdd);
                pPgw.add(btnCari);
                pPgw.add(btnKoreksi);
                pPgw.add(btnHapus);
                pPgw.add(btnSelesai);

                // menambahkan objek panel Ppgr ke container frame
                getContentPane().add(pPgw).setBackground(Color.getHSBColor(100, 150, 75));

                // menamplkan frame ke layar monitor
                pack();
                setLocationRelativeTo(null);
                tampiltabel();
                Kosong();
                settombol(1, 1, 0, 0, 1);

        }

        public static void main(String[] args) {
                new FPegawai06425().setVisible(true);
        }

        // fungsi action pada button
        public void actionPerformed(ActionEvent ae) {
                Object obj = ae.getSource();
                if (obj == btnAdd) {
                        if (btnAdd.getText() == "Simpan") {
                                String xnip = fNip.getText();
                                if (xnip.length() > 0)
                                        Add();
                                else
                                        JOptionPane.showMessageDialog(this, "Nip Kosong");
                                btnAdd.setText("Add");
                                Kosong();
                                tampiltabel();
                                settombol(1, 1, 0, 0, 1);
                        } else {
                                Kosong();
                                settombol(1, 0, 0, 0, 1);
                                btnAdd.setText("Simpan");
                                btnAdd.setForeground(Color.getHSBColor(100, 10, 0));
                                btnAdd.setBackground(Color.getHSBColor(200, 100, 100));
                        }
                }

                if (obj == btnCari) {
                        String xcari = JOptionPane.showInputDialog(this, "Masukkan Nip");
                        if (xcari != null) {
                                fNip.setText(xcari);
                                int xx = Cari();
                                if (xx == 1) {
                                        settombol(1, 1, 1, 1, 1);
                                } else {
                                        JOptionPane.showMessageDialog(this, "Nip kosong !");
                                }
                        }
                }

                if (obj == btnKoreksi) {
                        if (fNip.getText() != "") {
                                Koreksi();
                                tampiltabel();
                                Kosong();
                        } else {
                                JOptionPane.showMessageDialog(this, "Nip kosong !");
                                Cari();
                                fNip.requestFocus();
                        }

                }

                if (obj == btnHapus) {
                        // if (fNip.getText() != "") {
                        // int stt = JOptionPane.showConfirmDialog(this, "Yakin akan dihapus ?");
                        // if (stt == 1) {
                        // Hapus();
                        // tampiltabel();
                        // Kosong();
                        // }
                        // } else {
                        // JOptionPane.showMessageDialog(this, "Nip kosong !");
                        // Cari();
                        // fNip.requestFocus();
                        // }

                        int stt = JOptionPane.showConfirmDialog(this, "Yakin dihapus ?");
                        System.out.print(stt);

                        if (stt == 0) {
                                Hapus();
                                tampiltabel();
                                Kosong();
                        }

                }

                if (obj == btnSelesai) {
                        this.dispose();
                }

        }

        // fungsi penambahan data
        void Add() {
                try {
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();

                        // buat koneksi
                        Connection con = CnPenjualan.BukaCn();

                        // buat objek statement
                        Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        String strsqlcr = "SELECT * FROM pegawai06425 WHERE nip='" + fNip.getText() + "'";
                        ResultSet rs = stat.executeQuery(strsqlcr);
                        if (rs.next()) {
                                JOptionPane.showMessageDialog(this, "Nip sudah ada");
                        }

                        String strsql = "INSERT INTO pegawai06425(nip, nama, bagian, jeniskel) values ('"
                                        + fNip.getText()
                                        + "','" + fNama.getText() + "','" + fBagian.getText() + "','"
                                        + gendercb.getSelectedItem() + "')";

                        int stsproses = stat.executeUpdate(strsql);

                        if (stsproses == 1) {
                                JOptionPane.showMessageDialog(this, "Sukses di Tambahkan");

                        }
                        con.close();
                        stat.close();

                } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(this, "Penambahan gagal !");
                        System.err.println("Kesalahan perintah SQL : " + e.getMessage());
                }
        }

        // fungci mencari kode nip ke tabel
        int Cari() {
                int x = 0;
                try {
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        String strsql = "SELECT * FROM pegawai06425 WHERE nip = '" + fNip.getText() + "'";
                        ResultSet rs = stat.executeQuery(strsql);

                        if (rs.next()) {
                                // Jika nip ditemukan
                                fNip.setText(rs.getString("nip"));
                                fNama.setText(rs.getString("nama"));
                                fBagian.setText(rs.getString("bagian"));
                                // fJeniskel.setText(rs.getString("jeniskel"));
                                gendercb.setSelectedItem(rs.getString("jeniskel"));
                                x = 1;
                        } else {
                                // Jika tidak ditemukan
                                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
                                fNip.requestFocus();
                        }
                        rs.close();
                        con.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        System.err.println("Kesalahan perintah SQL : " + e.getMessage());
                }
                return x;
        }

        // Fungsi untuk mengedit data yang ada
        void Koreksi() {
                try {
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        String strsql = "UPDATE pegawai06425 set nama = '" + fNama.getText() + "', bagian = '"
                                        + fBagian.getText() + "', jeniskel='" + gendercb.getSelectedItem()
                                        + "' WHERE nip = '"
                                        + fNip.getText() + "'";
                        int stsproses = stat.executeUpdate(strsql);
                        if (stsproses == 1) {
                                JOptionPane.showMessageDialog(this, "Sukses melakukan update");
                        }
                        con.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(this, "Koneksi gagal");
                        System.err.println("Kesalahan perintah SQL :" + e.getMessage());
                }
        }

        // Fungsi menghapus data
        void Hapus() {
                try {
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        String strsql = "DELETE FROM pegawai06425 WHERE nip ='" + fNip.getText() + "'";
                        int stsproses = stat.executeUpdate(strsql);

                        if (stsproses == 1) {
                                JOptionPane.showMessageDialog(this, "Data terhapus");
                        }
                        con.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(this, "Penghapusan gagal");
                        System.err.println("Kesalahan perintah SQL : " + e.getMessage());
                }
        }

        // fungsi tampil data
        void tampiltabel() {
                try {
                        bersihtabel();
                        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                        Connection con = CnPenjualan.BukaCn();
                        Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        String strsql = "SELECT * FROM pegawai06425";
                        rs = stat.executeQuery(strsql);
                        ResultSetMetaData meta = rs.getMetaData();

                        rs.beforeFirst();
                        while (rs.next()) {
                                String Nip = rs.getString("nip");
                                String Nama = rs.getString("nama");
                                String Bagian = rs.getString("bagian");
                                String JenisKelamin = rs.getString("jeniskel");
                                String[] data = { Nip, Nama, Bagian, JenisKelamin };
                                tabModel.addRow(data);
                        }
                        stat.close();
                        rs.close();
                        con.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        System.err.println("Kesalahan perintah SQL :" + e.getMessage());
                }
        }

        // fungsi membersihkan tabel
        void bersihtabel() {
                int brs = tabModel.getRowCount();
                for (int i = 0; i < brs; i++) {
                        tabModel.removeRow(0);
                }
        }

        // fungsi mengosongkan kolom input

        void Kosong() {
                fNip.setText("");
                fNama.setText("");
                fBagian.setText("");
                // fJeniskel.setText("");
                gendercb.setSelectedItem("");
                fNip.requestFocus();
        }

        void settombol(int a, int b, int c, int d, int e) {
                btnAdd.setEnabled(a >= 1 ? true : false);
                btnCari.setEnabled(b >= 1 ? true : false);
                btnKoreksi.setEnabled(c >= 1 ? true : false);
                btnHapus.setEnabled(d >= 1 ? true : false);
                btnSelesai.setEnabled(e >= 1 ? true : false);
        }

}
