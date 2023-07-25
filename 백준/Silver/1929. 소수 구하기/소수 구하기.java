import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        isPrime(N);

        for (int i = M; i <= N; i++) {
            if (!prime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void isPrime (int N) {
        prime = new boolean[N + 1];

        prime[0] = true;
        prime[1] = true;


        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}