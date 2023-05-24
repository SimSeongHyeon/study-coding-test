import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }

            if (sum + i == N) {
                answer = i;
                break;
            }
        }

        bw.write(answer + "");

        br.close();

        bw.flush();
        bw.close();
    }
}