import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] drEven = {-1, 0, 1, 1, 0, -1};
    static int[] dcEven = {0, 1, 0, -1, -1, -1};
    static int[] drOdd = {-1, 0, 1, 1, 0, -1};
    static int[] dcOdd = {1, 1, 1, 0, -1, 0};
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maze[x][y] = 1;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Maze> queue = new LinkedList<>();

        queue.add(new Maze(0, 0, 0));

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Maze current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.count;
            }

            int[] dr = current.x % 2 == 0 ? drEven : drOdd;
            int[] dc = current.x % 2 == 0 ? dcEven : dcOdd;

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (isValid(nx, ny) && maze[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Maze(nx, ny, current.count + 1));

                    visited[nx][ny] = true;
                }
            }

        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Maze {
        int x;
        int y;
        int count;

        public Maze(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}