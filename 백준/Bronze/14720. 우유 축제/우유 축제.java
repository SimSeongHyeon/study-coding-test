import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ptr = 0;
        int cnt = 0;

        int[] shop = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            shop[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (shop[i] == ptr) {
                cnt++;
                ptr = (shop[i] + 1) % 3;
            }
        }

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
}