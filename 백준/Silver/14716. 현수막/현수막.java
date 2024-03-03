import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] banner;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        banner = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && banner[i][j] == 1) {
                    bfs(i, j);

                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();

        queue.add(new Spot(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Spot current = queue.poll();

            for (int i= 0; i < 8; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (banner[nx][ny] == 0) {
                    continue;
                }

                queue.add(new Spot(nx, ny));

                visited[nx][ny] = true;
            }
        }
    }

    static class Spot {
        int x;
        int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}