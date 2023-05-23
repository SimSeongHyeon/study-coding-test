import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrimeNum(num)) cnt ++;
        }

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }

    static boolean isPrimeNum (int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}