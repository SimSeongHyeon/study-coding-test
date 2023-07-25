import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int r = 1;

        int side = 2;

        for (int i = 0; i < N; i++) {
            side += r;
            r *= 2;
        }

        System.out.println((int)Math.pow(side, 2));
    }
}