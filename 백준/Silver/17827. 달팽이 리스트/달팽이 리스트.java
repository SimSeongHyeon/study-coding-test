import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        int[] snailList = new int[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            snailList[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int cycleLength = N - V + 1;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(bufferedReader.readLine());

            int currentNode;

            if (K < V - 1) {
                currentNode = 1 + K;
            } else {
                K -= (V - 1);
                K %= cycleLength;
                currentNode = V + K;
            }

            result.append(snailList[currentNode]).append("\n");
        }

        System.out.print(result);
    }
}
