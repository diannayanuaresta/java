package latian3b;

public class Latian3b {
    public static void main(String[] args) {
        int a, hasil;
        a = 14;
        hasil = (a++> 14) ? 10 : 20;
        System.out.println("Output satu : " + hasil);

        hasil = (a <= 14) ? 30 : 40;
        System.out.println("Output dua  : " + hasil);

        hasil = (a >14 && a<45) ? 50 : 60;
        System.out.println("Output tiga : " + hasil);

        hasil = (a<14 || a<45) ? 70 : 80;
        System.out.println("Output empat: " + hasil);

        System.out.println("======================");
        System.out.println("Program   : Latihan03b");
        System.out.println("NIM       : A12.2020.06425");
        System.out.println("Nama      : Dianna Yanuaresta");
    }
}
