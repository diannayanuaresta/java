package latian2j;

import java.util.Scanner;

public class Latian2j {
    public static void main(String[] args) {
        Scanner u_input = new Scanner(System.in);

        String nama;
        int nilai1, nilai2;
        float rata2;

        System.out.print("Nama        : ");
        nama = u_input.next();
        System.out.print("Nilai1      : ");
        nilai1 = u_input.nextShort();
        System.out.print("Nilai2      : ");
        nilai2 = u_input.nextShort();
        System.out.println("============");
        rata2 = (nilai1 + nilai2) / 2;
        System.out.print("Rata-rata :  " + rata2);
    }
}
