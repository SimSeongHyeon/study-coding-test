import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, days;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[] spotX, spotY;
    static int[][] box;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        spotX = new int[N];
        spotY = new int [M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        days = 0;

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(days);
    }

    static void bfs () {
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();

            days = Math.max(days, current.days);

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (!isRanged(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (box[nx][ny] == -1) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    box[nx][ny] = 1;

                    queue.add(new Tomato(nx, ny, current.days + 1));

                    visited[nx][ny] = true;
                }
            }
        }
    }

    static boolean isRanged(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Tomato {
        int x;
        int y;
        int days;

        public Tomato(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
}