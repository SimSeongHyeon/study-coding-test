
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = N - i; j < N; j++) {
                sb.append(" ");
            }

            for (int k = 2 * i; k < 2 * N - 1; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}