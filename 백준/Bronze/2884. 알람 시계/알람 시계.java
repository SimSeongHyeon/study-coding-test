import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int H = scn.nextInt();
        int M = scn.nextInt();

        if (H != 0) {
            if (M >= 45) System.out.println(H + " " + (M - 45));
            else System.out.println((H - 1) + " " + (M + 15));
        }
        else{
            if (M >= 45) System.out.println(H + " " + (M - 45));
            else{
                H = 24;
                System.out.println((H - 1) + " " + (M + 15));
            }
        }
    }
}