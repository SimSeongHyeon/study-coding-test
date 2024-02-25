import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, sheep, wolves;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] backyard;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        backyard = new int[R][C];

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();

            for (int j = 0; j < C; j++) {
                switch (row.charAt(j)) {
                    case '.' :
                        backyard[i][j] = 0;
                        break;

                    case '#' :
                        backyard[i][j] = -1;
                        break;

                    case 'o' :
                        backyard[i][j] = 1;
                        break;

                    case 'v' :
                        backyard[i][j] = 2;
                        break;
                }
            }
        }

        int survivedSheep = 0;
        int survivedWolves = 0;

        for (int i = 1; i < R - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (!visited[i][j] && backyard[i][j] != -1) {
                    sheep = 0;
                    wolves = 0;

                    bfs(i, j);

                    if (sheep > wolves) {
                        survivedSheep += sheep;
                    } else {
                        survivedWolves += wolves;
                    }
                }
            }
        }

        System.out.println(survivedSheep + " " + survivedWolves);


    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (backyard[x][y] == 1) {
            sheep++;
        }

        if (backyard[x][y] == 2) {
            wolves++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx < 0 || ny < 0 || nx >= R - 1 || ny >= C - 1) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (backyard[nx][ny] == -1) {
                continue;
            }

            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();

        queue.add(new Spot(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Spot current = queue.poll();

            if (backyard[current.x][current.y] == 1) {
                sheep++;
            }

            if (backyard[current.x][current.y] == 2) {
                wolves++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= R - 1 || ny >= C - 1) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (backyard[nx][ny] == -1) {
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
