import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, +2, -1, 1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());

        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        visited = new boolean[N][N];

        board[r2][c2] = 1;

        System.out.println(bfs(r1, c1));
    }

    static int bfs(int x, int y) {
        Queue<DeathKnight> queue = new LinkedList<>();

        queue.add(new DeathKnight(x, y, 0));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            DeathKnight current = queue.poll();

            if (board[current.x][current.y] == 1) {
                return current.movement;
            }

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                queue.add(new DeathKnight(nx, ny, current.movement + 1));

                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    static class DeathKnight {
        int x;
        int y;
        int movement;

        public DeathKnight(int x, int y, int movement) {
            this.x = x;
            this.y = y;
            this.movement = movement;
        }
    }
}