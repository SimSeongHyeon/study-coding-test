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

        System.out.println(z(N, r, c, result));
    }

    static int z(int N, int r, int c, int result) {
        if (N == 0) {
            return result;
        }

        int half = (int) Math.pow(2, N - 1);

        //1, 2, 3, 4사분면(2사분면은 좌표 조정이 필요 없다.)
        if (r < half && c >= half) {
            c -= half;

            result += (int) Math.pow(4, N - 1);

            N--;

            return z(N, r, c, result);

        } else if (r < half) {
            N--;

            return z(N, r, c, result);

        } else if (c < half) {
            r -= half;

            result += (int) Math.pow(4, N - 1) * 2;

            N--;

            return z(N, r, c, result);

        } else {
            r -= half;

            c -= half;

            result += (int) Math.pow(4, N - 1) * 3;

            N--;

            return z(N, r, c, result);
        }
    }
}