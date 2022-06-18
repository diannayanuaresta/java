package latian4a;

import java.util.Scanner;

public class Latian4a {
    public static void main(String[] args) {
        String nama;
        int anak, gaji, tanak, total;

        Scanner oscan01 = new Scanner(System.in);
        System.out.println("Hitung Tunjangan Anak");
        System.out.println("=====================");
        System.out.print("Nama    :");
        nama = oscan01.nextLine();
        System.out.print("Anak    :");
        anak = oscan01.nextInt();
        System.out.print("Gaji    :");
        gaji = oscan01.nextInt();

        // Hitung tunjangan anak
        if (anak > 3)
            tanak = 3 * 200000;
        else
            tanak = anak * 200000;

        total = gaji + tanak;
        System.out.println("Tunjangan: " + tanak);
        System.out.println("Total    : " + total);

    }
}
