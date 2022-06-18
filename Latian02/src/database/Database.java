package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import java.sql.ResultSet;

public class Database {
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public int addData(String nip, String nama, String bagian) {

        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // buat objek statement
            stmt = conn.createStatement();

            // buat query ke database
            String sql = "INSERT INTO pegawai (nip, nama, bagian) VALUES(?,?,?)";

            // eksekusi query dan simpan hasilnya di obj ResultSet
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nip);
            statement.setString(2, nama);
            statement.setString(3, bagian);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return 1;
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int hapusData(String nip) {
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // buat objek statement
            stmt = conn.createStatement();

            // buat query ke database
            String sql = "DELETE FROM pegawai WHERE nip=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nip);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return 1;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateData(String nip, String nama, String bagian) {
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // buat objek statement
            stmt = conn.createStatement();

            // buat query ke database
            String sql = "UPDATE Pegawai SET nama=?, bagian=? WHERE nip=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, bagian);
            statement.setString(3, nip);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("berhasil !");
                return 1;

            } else {
                System.out.println("gagal !");
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String cariData(String sql) {
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // buat query ke database
            // PreparedStatement statements = conn.prepareStatement(sql);
            // statements.setString(1, nip);

            // Statement statement = conn.createStatement();
            // buat objek statement
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            // tampilkan hasil query
            while (result.next()) {
                return "NIP " + result.getString("nip") + " dengan nama " + result.getString("nama") + " pada divisi "
                        + result.getString("bagian");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Data tidak tersedia";
    }
    // public static void main(String[] args) {

    // // Melakukan koneksi ke database
    // // harus dibungkus dalam blok try/catch
    // try {
    // // register driver yang akan dipakai
    // Class.forName(JDBC_DRIVER);

    // // buat koneksi ke database
    // conn = DriverManager.getConnection(DB_URL, USER, PASS);

    // // buat objek statement
    // stmt = conn.createStatement();

    // // buat query ke database
    // String sql = "SELECT * FROM products";

    // // eksekusi query dan simpan hasilnya di obj ResultSet
    // rs = stmt.executeQuery(sql);

    // // tampilkan hasil query
    // while(rs.next()){
    // System.out.println("id: " + rs.getInt("id"));
    // System.out.println("name: " + rs.getString("name"));
    // System.out.println("description: " + rs.getString("description"));
    // }

    // stmt.close();
    // conn.close();

    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // }
}
