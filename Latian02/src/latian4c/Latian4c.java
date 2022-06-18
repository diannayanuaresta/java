package latian4c;

import java.util.Scanner;

public class Latian4c {
    public static void main(String[] args) {
        int angka;
        String konversi;
        Scanner oscanner01 = new Scanner(System.in);
        System.out.print("Masukan nilai : ");
        angka = oscanner01.nextInt();

        // hitung konversi
        if (angka >= 85 && angka <= 100)
            konversi = "A";
        else if (angka >= 70 && angka < 85)
            konversi = "B";
        else if (angka >= 60 && angka < 70)
            konversi = "C";
        else if (angka >= 50 && angka < 60)
            konversi = "D";
        else if (angka >= 0 && angka < 50)
            konversi = "E";
        else
            konversi = "Not Found";

        System.out.println("Konversi Nilai : " + konversi);

    }
}
