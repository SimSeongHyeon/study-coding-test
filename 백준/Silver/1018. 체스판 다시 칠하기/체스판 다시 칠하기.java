import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board, chessBoard;

    public static void main(String[] args) throws IOException {
        init();

        int count = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                getChessBoard(i, j);
                count = Math.min(count, countRepaint());
            }
        }

        System.out.println(count);
    }

    static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }
    }

    static void getChessBoard(int x, int y) {
        chessBoard = new char[8][8];

        for (int i = 0; i < 8; i++) {
            System.arraycopy(board[i + x], y, chessBoard[i], 0, 8);
        }
    }

    static int countRepaint() {
        int repaintW = 0;
        int repaintB = 0;

        char[] patterns = {'W', 'B'};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char pattern = patterns[(i + j) % 2];
                if (chessBoard[i][j] != pattern) {
                    repaintW++;
                } else {
                    repaintB++;
                }
            }
        }
        return Math.min(repaintW, repaintB);
    }

}