import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N, M;
    static int[] numbers;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        getCombination(N, M);

        System.out.println(stringBuilder.toString().trim());
    }

    static void getCombination(int N, int M) {
        numbers = new int[M];

        backtracking(1, 0);
    }

    static void backtracking(int pointer, int depth) {
        if (depth == M) {
            appendStringBuilder(numbers);

            return;
        }

        for (int i = pointer; i <= N; i++) {
            numbers[depth] = i;

            backtracking(i + 1, depth + 1);
        }

    }

    static void appendStringBuilder(int[] numbers) {
        for (int number : numbers) {
            stringBuilder.append(number).append(" ");
        }

        stringBuilder.append("\n");
    }

}
