import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i ++) {
            System.out.println(primeNumber(Long.parseLong(br.readLine())));
        }
    }

    public static long primeNumber (long n) {
        if (n <= 2) return 2;
        
        while (true) {
            int result = 0;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    result++;
                    break;
                }
            }

            if (result == 0) {
                return n;
            }

            n++;
        }
    }
}