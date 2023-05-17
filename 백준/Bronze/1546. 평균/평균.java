import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double sum = 0;

        double[] scr = new double[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            scr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scr);

        double M = scr[scr.length - 1];

        for (int i = 0; i < N; i++) {
            scr[i] = scr[i] / M * 100;
        }

        for (int i = 0; i < N; i++) {
            sum = sum + scr[i];
        }

        bw.write(sum / N + "");

        br.close();

        bw.flush();
        bw.close();
    }
}

