package latian2g;

public class Latian2g {
    public static void main(String[] args) {
        double[] myList = { 1.1, 2, 3, 4, 5 };
        double count = 0 ;
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
           count = count + myList[i];
        } 
        System.out.println("===== +");
        System.out.println(count);
    }
}
