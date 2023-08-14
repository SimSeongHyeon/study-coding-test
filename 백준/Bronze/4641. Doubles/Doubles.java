import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            int cnt = 0;
            int i = 0;
            int[] num = new int[16];

            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) return;
                num[i] = n;
                i++;
            }

            Arrays.sort(num);

            for (int j = 1; j < 15; j++) {
                for (int k = j + 1; k < 16; k++) {
                    if(num[j] == 0) continue;
                    if (num[j] * 2 == num[k]) cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}