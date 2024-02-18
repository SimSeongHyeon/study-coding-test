import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, area;
    static int[] dc = {1, -1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int[][] aisle;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        aisle = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            aisle[r - 1][c - 1] = 1;
        }

        int dfsMaxArea = 0;
        int bfsMaxArea = 0;

//        visited = new boolean[N][M];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (!visited[i][j] && aisle[i][j] == 1) {
//                    area = 0;
//
//                    dfs(i, j);
//
//                    dfsMaxArea = Math.max(area, dfsMaxArea);
//                }
//            }
//        }
//
//        System.out.println("DFS : " + dfsMaxArea);

        area = 0;

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && aisle[i][j] == 1) {
                    area = 0;

                    bfs(i, j);

                    bfsMaxArea = Math.max(area, bfsMaxArea);
                }
            }
        }

        System.out.println(bfsMaxArea);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        area++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (aisle[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<LocationOfFood> queue = new LinkedList<>();

        queue.add(new LocationOfFood(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            LocationOfFood current = queue.poll();

            visited[current.x][current.y] = true;

            area++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (aisle[nx][ny] == 1) {
                    queue.add(new LocationOfFood(nx, ny));

                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class LocationOfFood {
        int x;
        int y;

        public LocationOfFood(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}