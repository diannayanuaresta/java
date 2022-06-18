package koneksidbms;

import java.sql.*;

public class KoneksiDBMS {
    String driverdbms = "com.mysql.cj.jdbc.Driver";
    String database = "jdbc:mysql://localhost/dianna06425";
    String user = "dianna06425";
    String password = "";

    public KoneksiDBMS() {
    }

    public Connection BukaCn() throws SQLException {
        Connection condbms = null;
        try {
            Class.forName(driverdbms);
            condbms = DriverManager.getConnection(database, user, password);
            return condbms;
        } catch (SQLException e) {
            System.out.println("Ada kesalahan DBMS !");
            return null;
        } catch (Exception ex) {
            System.out.println("Koneksi Gagal !");
            return null;
        }
    }
}
