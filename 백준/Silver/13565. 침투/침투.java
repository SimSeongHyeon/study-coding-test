import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] fiber;
    static boolean[][] visited;

    static boolean isConnected;

    static void dfs (int x, int y) {

        visited[x][y] = true;

        if (x == N - 1 && fiber[x][y] == 0) {
            isConnected = true;

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dc[i];
            int nextY = y + dr[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if (!visited[nextX][nextY] && fiber[nextX][nextY] == 0) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fiber = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j  < M; j++) {
                fiber[i][j] = row.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            if (!visited[0][i] && fiber[0][i] == 0) {
                dfs(0 ,i);
            }
        }

        System.out.println(isConnected ? "YES" : "NO");


    }
}