package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {

    JFrame table_f;

    Table() {
        table_f = new JFrame();
        String table_data[][] = { { "1001", "Buku" }, { "1002", "Pensil" } };
        String table_column[] = { "Kode", "Nama Barang" };
        JTable table_jt = new JTable(table_data, table_column);
        JScrollPane table_sp = new JScrollPane(table_jt);
        table_f.add(table_sp);
        table_f.setSize(360, 220);
        table_f.setVisible(true);
    }

    public static void main(String[] args) {
        new Table();
    }

}
