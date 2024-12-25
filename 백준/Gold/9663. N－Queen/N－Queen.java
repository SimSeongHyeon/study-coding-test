import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, count;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        queens = new int[N];

        count = 0;

        putQueen(0);

        System.out.println(count);
    }

    static void putQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                putQueen(row + 1);
            }
        }

    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if(queens[i] == col) {
                return false;
            } else if (Math.abs(i - row) == Math.abs(queens[i] - col)) {
                return false;
            }
        }

        return true;
    }
}