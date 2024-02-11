import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            trees[i] = height;

            maxHeight = Math.max(maxHeight, height);
        }

        int minHeight = 0;

        while (minHeight < maxHeight) {
            int currentHeight = (minHeight + maxHeight) / 2;

            if (Cut(trees, currentHeight) < M) {
                maxHeight = currentHeight;
            } else {
                minHeight = currentHeight + 1;
            }
        }

        System.out.println(minHeight - 1);

    }

    static long Cut(int[] trees, int height) {
        long sum = 0;

        for (int i : trees) {
            if (i - height >= 0) {
                sum += i - height;
            }
        }

        return sum;
    }
}