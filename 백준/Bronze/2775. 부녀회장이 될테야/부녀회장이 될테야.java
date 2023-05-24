import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] addr = new int [k + 1][n + 1];

            for (int a = 0; a < n + 1; a++) {
                addr[0][a] = a;
            }

            for (int b = 0; b < k + 1; b++) {
                addr[b][0] = 0;
            }

            for (int c = 1; c < k + 1; c++) {
                for (int d = 1; d < n + 1; d++) {
                    addr[c][d] = addr[c][d - 1] + addr[c - 1][d];
                }
            }
            bw.write(addr[k][n] + "\n");

        }

        br.close();

        bw.flush();
        bw.close();
    }
}