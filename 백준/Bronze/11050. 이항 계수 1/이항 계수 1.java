import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int num = 1;
        int deno = 1;

        for (int i = 0; i < K; i++) {
            num = num * N;
            N--;
        }

        for (int i = 1; i <= K; i++) {
            deno = deno * i;
        }

        bw.write(num / deno + "");

        br.close();

        bw.flush();
        bw.close();
    }
}