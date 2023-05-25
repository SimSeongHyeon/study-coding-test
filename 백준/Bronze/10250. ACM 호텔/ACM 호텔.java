import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int loc = 0;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            int[][] hotel = new int[H][W];

            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    hotel[j][k] = (j + 1) * 100 + k + 1;
                }
            }

            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    if (N != 0) {
                        N--;
                        loc = hotel[k][j];
                    }
                }
            }
            bw.write(loc + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}