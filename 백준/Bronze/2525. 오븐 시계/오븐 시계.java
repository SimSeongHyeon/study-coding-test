import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h = scn.nextInt();
        int m = scn.nextInt();
        int ckTm = scn.nextInt();

        h = h + ckTm / 60;
        m = m + ckTm % 60;

        if(m >= 60) {
            h++;
            m = m - 60;
        }

        if(h >= 24) h = h % 24;

        System.out.println(h + " " + m);
    }
}