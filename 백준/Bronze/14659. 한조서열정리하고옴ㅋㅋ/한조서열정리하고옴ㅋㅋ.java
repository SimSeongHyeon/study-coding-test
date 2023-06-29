import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] bongwoori = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            bongwoori[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cnt = 0;
        int lIdx = 0;
        int rIdx = 1;

        while (rIdx < N) {
            if (bongwoori[lIdx] > bongwoori[rIdx]) {
                rIdx++;
                cnt++;
                max = Math.max(max, cnt);
            }

            else if (bongwoori[lIdx] < bongwoori[rIdx]) {
                lIdx = rIdx;
                rIdx++;
                cnt = 0;
            }
        }

        System.out.println(max);
    }
}