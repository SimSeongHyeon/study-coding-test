import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int benefit = C - B;

        int cnt = 0;

        if (benefit <= 0) cnt = -1;
        else while (A >= benefit * cnt) cnt++;

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
}