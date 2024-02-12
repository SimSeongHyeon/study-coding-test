import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        visited = new boolean[n][m];

        bfs(x, y);

        convertCannotReach();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void convertCannotReach() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();

        queue.add(new Spot(x, y, 0));


        while (!queue.isEmpty()) {
            Spot current = queue.poll();

            map[current.x][current.y] = current.distance;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dc[i];
                int ny = current.y + dr[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    queue.add(new Spot(nx, ny, current.distance + 1));
                }
            }
        }

    }

    public static class Spot {
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