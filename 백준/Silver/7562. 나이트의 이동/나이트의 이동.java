import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int edge;
    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (testCase-- > 0) {
            edge = Integer.parseInt(br.readLine());

            board = new int[edge][edge];

            visited = new boolean[edge][edge];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            board[targetX][targetY] = 1;

            sb.append(bfs(startX, startY)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int startX, int startY) {
        Queue<Spot> queue = new LinkedList<>();

        queue.add(new Spot(startX, startY, 0));

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Spot current = queue.poll();

            if (board[current.x][current.y] == 1) {
                return current.movement;
            }

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= edge || ny >= edge) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                queue.add(new Spot(nx, ny, current.movement + 1));

                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    static class Spot {
        int x;
        int y;
        int movement;

        public Spot(int x, int y, int movement) {
            this.x = x;
            this.y = y;
            this.movement = movement;
        }
    }
}