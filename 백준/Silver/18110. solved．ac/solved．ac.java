import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        double cuttingAvg = n * 0.15;
        int cutting = (int) Math.round(cuttingAvg);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        for (int i = cutting; i < n - cutting; i++) {
            sum += level[i];
        }

        double avg = (double) sum / (n - 2 * cutting);

        bw.write(Math.round(avg) + "");

        br.close();

        bw.flush();
        bw.close();
    }
}