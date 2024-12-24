import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[] numbers;
    static boolean[] isVisited;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        getCombination(N, M);

        System.out.println(stringBuilder.toString().trim());
    }

    static void getCombination(int N, int M) {
        numbers = new int[M];
        isVisited = new boolean[N + 1];

        backtracking(N, M, 0);
    }

    static void backtracking(int N, int M, int depth) {
        if (depth == M) {
            appendStringBuilder(numbers);

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;

                numbers[depth] = i;

                backtracking(N, M, depth + 1);

                isVisited[i] = false;
            }
        }

    }

    static void appendStringBuilder(int[] numbers) {
        for (int number : numbers) {
            stringBuilder.append(number).append(" ");
        }

        stringBuilder.append("\n");
    }

}
