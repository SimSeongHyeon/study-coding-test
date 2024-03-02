import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, safeDistance;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] space;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSafeDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 0) {
                    initVisited(visited);
                    safeDistance = 0;

                    bfs(i, j);

                    maxSafeDistance = Math.max(maxSafeDistance, safeDistance);
                }
            }
        }

        System.out.println(maxSafeDistance);
    }

    static void bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();

        queue.add(new Spot(x, y, 0));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Spot current = queue.poll();

            if (space[current.x][current.y] == 1) {
                safeDistance = current.distance;

                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                queue.add(new Spot(nx, ny, current.distance + 1));

                visited[nx][ny] = true;
            }
        }
    }

    static void initVisited(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
    }

    static class Spot {
        int x;
        int y;
        int distance;

        public Spot(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}