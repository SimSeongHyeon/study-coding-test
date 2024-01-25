import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] maze;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int N, M;

    static void bfs (int x, int y) {
        visited[x][y] = true;

        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] nowSpot = queue.poll();
            int nowX = nowSpot[0];
            int nowY = nowSpot[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dr[i];
                int nextY = nowY + dc[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY] && maze[nextX][nextY] > 0) {
                    queue.add(new int[]{nextX, nextY});

                    maze[nextX][nextY] = maze[nowX][nowY] + 1;

                    visited[nextX][nextY] = true;
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

        maze = new int[N][M];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];

        visited[0][0] = true;

        bfs(0, 0);

        System.out.println(maze[N - 1][M - 1]);
    }
}