import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int R, C, maxPath;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static HashMap<Character, Boolean> path = new HashMap<>();

    static char[][] makeBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        return board;
    }

    static boolean isInBoard(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    static void dfs(char[][] board, int r, int c, int count) {
        path.put(board[r][c], true);

        maxPath = Math.max(maxPath, count);

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (!isInBoard(nextR, nextC)) {
                continue;
            }

            if (path.getOrDefault(board[nextR][nextC], false)) {
                continue;
            }

            dfs(board, nextR, nextC, count + 1);
        }

        path.remove(board[r][c]);
    }

    public static void main(String[] args) throws IOException {
        char[][] board = makeBoard();

        maxPath = 0;

        dfs(board, 0, 0, 1);

        System.out.println(maxPath);
    }
}