import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int prize = 0;

        if (a == b && b == c) prize = 10000 + a * 1000;
        else if (a == b && b != c) prize = 1000 + a * 100;
        else if (b == c && c != a) prize = 1000 + b * 100;
        else if (c == a && a != b) prize = 1000 + c * 100;
        else if (a != b && b != c && c != a) {
            if (a > b && a > c) prize = a * 100;
            else if (a < b && b > c) prize = b * 100;
            else if (c > a && b < c) prize = c * 100;
        }
        System.out.println(prize);
    }
}