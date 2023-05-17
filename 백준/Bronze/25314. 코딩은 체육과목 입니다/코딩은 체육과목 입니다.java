import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int i = x / 4;
        for(int j = 0; j < i; j++) System.out.print("long ");
        System.out.println("int");
    }
}