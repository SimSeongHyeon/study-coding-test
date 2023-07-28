import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(arithmetic_sequence(Integer.parseInt(br.readLine())));
    }

    static int arithmetic_sequence (int N) {
        int cnt = 99;

        if (N < 100) return N;

        else {
            for (int i = 100; i <= N; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;

                if (b - a == c - b) cnt++;
            }
        }

        return cnt;

    }
}