import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int x, y, N, M, count;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] campus;
    static boolean[][] visited;

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] spot = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = spot[0] + dr[i];
                int ny = spot[1] + dc[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;

                    queue.add(new int[]{nx, ny});

                    if (campus[nx][ny] == 'P') {
                        count++;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                visited[nx][ny] = true;

                dfs(nx, ny);

                if (campus[nx][ny] == 'P') {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (str.charAt(j) == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        visited = new boolean[N][M];

        count = 0;

        bfs(x, y);

        System.out.println(count == 0 ? "TT" : count);
    }
}