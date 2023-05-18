import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                bw.write(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++){
                bw.write("*");
            }
            bw.newLine();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                bw.write(" ");
            }

            for (int k = 0; k < 2 * N - 3 - 2 * i; k++) {
                bw.write("*");
            }
            bw.newLine();
        }

        br.close();

        bw.flush();
        bw.close();
    }
}