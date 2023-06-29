import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[2 * N - 1];

        for (int i = 1; i <= N; i++) {
            cards[i - 1] = i;
        }

        int lIdx = 0;
        int rIdx = N;

        while (N-- > 1) {
            lIdx++;

            cards[rIdx] = cards[lIdx];

            lIdx++;
            rIdx++;
        }

        System.out.println(cards[lIdx]);
    }
}