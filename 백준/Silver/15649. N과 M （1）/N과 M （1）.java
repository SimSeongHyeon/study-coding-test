import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] sequence = new int[M];
        boolean[] visited = new boolean[N];

        backTracking(N, M, sequence, visited, 0);

    }

    static void backTracking (int N, int M, int[] sequence, boolean[] isVisited, int depth) {
        if (depth == sequence.length) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int n : sequence) {
                stringBuilder.append(n).append(" ");
            }

            System.out.println(stringBuilder.toString().trim());

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;

                sequence[depth] = i + 1;

                backTracking(N, M, sequence, isVisited, depth + 1);

                isVisited[i] = false;
            }
        }
    }
}