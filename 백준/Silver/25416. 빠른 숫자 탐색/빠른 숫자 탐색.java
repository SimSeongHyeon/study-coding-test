import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        board = new int[5][5];

        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(bfs(x, y));
    }

    static int bfs(int x, int y) {
        Queue<Travel> queue = new LinkedList<>();

        queue.add(new Travel(x, y, 0));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Travel current = queue.poll();

            if (board[current.x][current.y] == 1) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (!isValid(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == -1) {
                    continue;
                }

                queue.add(new Travel(nx, ny, current.count + 1));

                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    static boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

    static class Travel {
        int x;
        int y;
        int count;

        public Travel(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}