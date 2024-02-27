import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, soldiers;
    static boolean isFriendly;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] battleground;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        battleground = new char[M][N];

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                battleground[i][j] = str.charAt(j);
            }
        }

        int friendlyPower = 0;
        int enemyPower = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (battleground[i][j] == 'W') {
                        isFriendly = true;
                    }

                    if (battleground[i][j] == 'B') {
                        isFriendly = false;
                    }

                    soldiers = 0;

                    bfs(i, j);

                    if (isFriendly) {
                        friendlyPower += soldiers * soldiers;
                    }

                    if (!isFriendly) {
                        enemyPower += soldiers * soldiers;
                    }

                }
            }
        }

        System.out.println(friendlyPower + " " + enemyPower);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        soldiers++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (isFriendly && battleground[nx][ny] == 'W') {
                dfs(nx, ny);
            }

            if (!isFriendly && battleground[nx][ny] == 'B') {
                dfs(nx, ny);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Soldiers> queue = new LinkedList<>();

        queue.add(new Soldiers(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Soldiers current = queue.poll();

            soldiers++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (isFriendly && battleground[nx][ny] == 'W') {
                    queue.add(new Soldiers(nx, ny));
                    visited[nx][ny] = true;
                }

                if (!isFriendly && battleground[nx][ny] == 'B') {
                    queue.add(new Soldiers(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class Soldiers {
        int x;
        int y;

        public Soldiers(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
