package latian4d;

import java.util.Scanner;

public class Latian4d {
    public static void main(String[] args) {
        String nama, nomor;
        int pemakaian_air = 0, biaya_pakai = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Perhitungan Biaya Pemakaian Air");
        System.out.println("===============================");
        System.out.print("Nama            :");
        nama = input.nextLine();
        System.out.print("No. Pelanggan   :");
        nomor = input.nextLine();
        System.out.print("Pemakaian Air   :");
        pemakaian_air = input.nextInt();
        if (pemakaian_air <= 10) {
            biaya_pakai += pemakaian_air * 1000;
        } else {
            biaya_pakai += 10 * 1000;
            pemakaian_air -= 10;
            if (pemakaian_air <= 10) {
                biaya_pakai += pemakaian_air * 2000;
            } else {
                biaya_pakai += 10 * 2000;
                pemakaian_air -= 10;
                biaya_pakai += pemakaian_air * 5000;
            }
        }
        System.out.println("Biaya Pakai     :" + biaya_pakai);
        System.err.println("===============================");

    }
}
