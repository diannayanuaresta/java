package latian1b;

public class Latian1b {
    String key;
    String value;
    int row = 10;
    int column = 10;

    public Latian1b(String key, String value) {
        this.key = key;
        this.value = value;
        System.out.println(key + " : " + value);
    }

    public static void main(String[] args) {
        new Latian1b("Nama", "Namanya Siapa");
        new Latian1b("Jenis Kelamin", "Wanita");
        new Latian1b("Alamat", "Trayeman");
        new Latian1b("Kota", "Tegal");
        new Latian1b("Nomor", "0812******");

    }
}
