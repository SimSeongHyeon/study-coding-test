import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;

        while (N > 0) {
            int half = (int) Math.pow(2, N - 1);

            if (r < half && c >= half) {
                c -= half;
                result += (int) Math.pow(4, N - 1);
            } else if (r >= half && c < half) {
                r -= half;
                result += (int) Math.pow(4, N - 1) * 2;
            } else if (r >= half && c >= half) {
                r -= half;
                c -= half;
                result += (int) Math.pow(4, N - 1) * 3;
            }
            N--;
        }

        System.out.println(result);
    }
}