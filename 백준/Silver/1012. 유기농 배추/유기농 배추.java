import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] land;
    static boolean[][] visited;
    static int N, M, count;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + dr[i];
            int dy = y + dc[i];

            if (dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && land[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            land = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0 ; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                land[X][Y] = 1;
            }
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && land[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}