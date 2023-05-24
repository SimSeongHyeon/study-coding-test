import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = 1;
        int lcm = a * b;

        if (a >= b) {
            for (int i = 2; i <= a; i++) {
                if (a % i == 0 && b % i == 0) gcd = i;
            }
        }

        else {
            for (int i = 2; i <= b; i++){
                if (a % i == 0 && b % i == 0) gcd = i;
            }
        }

        for (int j = lcm; j >= 1; j--) {
            if (j % a == 0 && j % b == 0) lcm = j;
        }

        bw.write(gcd +"\n" + lcm);

        br.close();

        bw.flush();
        bw.close();
    }
}