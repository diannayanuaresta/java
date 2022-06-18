package teskoneksidbms;

import java.sql.*;

import koneksidbms.KoneksiDBMS;

public class TesKoneksiDBMS {
    public static void main(String[] args) {
        try {
            KoneksiDBMS CnPenjualan = new KoneksiDBMS();
            Connection con = CnPenjualan.BukaCn();

            if (con != null) {
                System.out.println("Koneksi berhasil !");
            } else {
                System.out.println("Koneksi Gagal !");
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());
        }
    }
}
