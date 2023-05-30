import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] sb = new StringBuilder[201];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sb[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb2 = new StringBuilder();

        for (StringBuilder val : sb) {
            sb2.append(val);
        }

        bw.write(sb2 + "");

        br.close();

        bw.flush();
        bw.close();
    }
}