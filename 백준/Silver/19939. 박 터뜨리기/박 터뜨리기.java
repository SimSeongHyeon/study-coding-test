import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = sigma(K);

        int gap = 0;

        if (min > N) {
            System.out.println("-1");
            return;
        }

        else {
            gap = K - 1;
            N -= min;

            if (N % K != 0) {
                gap++;
            }
        }

        System.out.println(gap);
    }

    static int sigma (int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) result += i;
        return result;
    }
}