import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int range = 2;

        if (N == 1) {
            bw.write(answer + "");
        }
        else {
            while (range <= N) {
                range = range + (6 * answer);
                answer++;
            }
            bw.write(answer + "");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}