import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = str.charAt(j) - '0';
            }
        }

        int side = Math.min(N, M);

        while (side > 0) {
            for (int i = 0; i <= N - side; i++) {
                for (int j = 0; j <= M - side; j++) {
                    int num = square[i][j];
                    if (square[i + side - 1][j] == num && square[i][j + side - 1] == num && square[i + side - 1][j + side - 1] == num) {
                        System.out.println(side * side);
                        return;
                    }
                }
            }
            side--;
        }
    }
}