import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            for (int k = 1; k <= 2 * N - 2 * i; k++){
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - i; j > 0; j--) {
                bw.write("*");
            }
            for (int k = 1; k <= 2 * i; k++) {
                bw.write(" ");
            }
            for (int j = N - i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}