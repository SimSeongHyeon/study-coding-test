import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] have = new int[6];

        int[] chess = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < have.length; i++) {
            have[i] = Integer.parseInt(st.nextToken());
            bw.write(chess[i] - have[i] + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
