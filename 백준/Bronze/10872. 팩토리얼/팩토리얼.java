import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fac = 1;

        if (N > 0) {
            for (int i = 1; i <= N; i++) {
                fac = fac * i;
            }
        }

        bw.write(fac + "");

        br.close();

        bw.flush();
        bw.close();
    }
}