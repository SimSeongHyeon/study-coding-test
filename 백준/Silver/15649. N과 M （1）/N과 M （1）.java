import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    static int[] numbers;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        getCombination(N, M);
    }

    static void getCombination(int N, int M) {
        numbers = new int[M];
        isVisited = new boolean[N + 1];

        backtracking(N, M, numbers, isVisited, 0);
    }

    static void backtracking(int N, int M, int[] numbers, boolean[] isVisited, int depth) {
        if (depth == M) {
            printCombination(numbers);

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;

                numbers[depth] = i;

                backtracking(N, M, numbers, isVisited, depth + 1);

                isVisited[i] = false;
            }
        }

    }

    static void printCombination(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int number : numbers) {
            stringBuilder.append(number).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }

}
