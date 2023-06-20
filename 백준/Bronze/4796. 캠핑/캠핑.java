import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            int sum = 0;

            while (V > P) {
                V = V - P;
                sum += L;
            }

            sum += Math.min(V, L);

            bw.write("Case " + caseNum + ": " + sum + "\n");

            caseNum++;
        }

        br.close();

        bw.flush();
        bw.close();
    }
}