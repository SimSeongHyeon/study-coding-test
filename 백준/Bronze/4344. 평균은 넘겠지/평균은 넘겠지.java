import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            double avg;
            double sum = 0;
            double cnt = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            double[] scr = new double[N];

            for (int j = 0; j < N; j++) {
                scr[j] = Integer.parseInt(st.nextToken());
                sum = sum + scr[j];
            }

            avg = sum / N;

            for (int k = 0; k < scr.length; k++) {
                if (scr[k] > avg) cnt++;
            }

            String answer = String.format("%.3f", cnt / (double)scr.length * 100);

            bw.write(answer + "%\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}