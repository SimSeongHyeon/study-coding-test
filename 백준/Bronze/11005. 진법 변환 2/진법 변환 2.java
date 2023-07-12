import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            if (N % B < 10) sb.append(N % B);
            else sb.append((char)(N % B - 10 + 'A'));
            N /= B;
        }

        StringBuilder sb2 = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            sb2.append(sb.charAt(i));
        }

        System.out.println(sb2);
    }
}