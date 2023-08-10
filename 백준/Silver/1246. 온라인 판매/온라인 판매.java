import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cost = new int[M];

        for (int i = 0; i < M; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int benefit = 0;

        Arrays.sort(cost);

        int[] sum = new int[M];

        for (int i = 0; i < M; i++) {
                sum[i] = cost[i] * Math.min(N, M - i);
        }

        int price = 0;

        for (int i = 0; i < M; i++) {
            if (sum[i] > benefit) {
                price = cost[i];
                benefit = sum[i];
            }
        }

        System.out.println(price + " " + benefit);
    }
}