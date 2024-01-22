import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] land;
    static int N;
    static int M;
    static int B;
    static int time = Integer.MAX_VALUE;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        land = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(max, land[i][j]);
                min = Math.min(min, land[i][j]);
            }
        }

        bruteForce(min, max);

        System.out.println(time + " " + height);
    }

    static void bruteForce (int min, int max) {
        for (int i = min; i <= max; i++) {

            int block = B;
            int cnt = 0;

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < M; k++) {

                    if (land[j][k] > i) {
                        cnt += (land[j][k] - i) * 2;
                        block += land[j][k] - i;
                    } else {
                        cnt += i - land[j][k];
                        block -= i - land[j][k];
                    }
                }
            }

            if (block < 0) return;

            if (time >= cnt) {
                time = cnt;
                height = i;
            }
        }
    }
}