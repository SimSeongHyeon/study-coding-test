import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int sum = 0;
        int price, quantity;

        for(int i = 0; i < n; i++) {
            price = scn.nextInt();
            quantity = scn.nextInt();
            sum = sum + price * quantity;
        }

        if(sum == x) System.out.println("Yes");
        else System.out.println("No");
    }
}