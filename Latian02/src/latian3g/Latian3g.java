package latian3g;

public class Latian3g {
    public static void main(String[] args) {
        int x1, x2, x3, x4, x5;
        
        x1 = 5 + 7 * 2;
        x2 = (5 + 7) * 2;
        x3 = 5 + 7 * 2 - 1;
        x4 = (5 + 7) * 2 - 1;
        x5 = 1 + 2 - 3 * 4 % 5;

        System.out.println("5 + 7 * 2        :" + x1);
        System.out.println("(5 + 7) * 2      :" + x2);
        System.out.println("5 + 7 * 2 - 1    :" + x3);
        System.out.println("(5 + 7) * 2 - 1  :" + x4);
        System.out.println("1 + 2 - 3 * 4 % 5:" + x5);
    }
}
