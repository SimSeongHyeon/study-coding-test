import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kjm = Integer.parseInt(st.nextToken());
        int lhs = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (kjm != lhs) {
            kjm = kjm / 2 + kjm % 2;
            lhs = lhs / 2 + lhs % 2;
            cnt++;
        }

        System.out.println(cnt);
    }
}