import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];

        long min = 0;
        long max = 0;
        long mid = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if (max < lan[i]) {
                max = lan[i];
            }
        }

        ++max;

        while (min < max) {
            mid = (min + max) / 2;

            long cnt = 0;

            for (int i : lan) {
                cnt += i / mid;
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = ++mid;
            }
        }

        System.out.println(--min);
    }
}