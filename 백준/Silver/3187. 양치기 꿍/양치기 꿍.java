import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, sumOfWolves, sumOfSheep, survivedSheep, survivedWolves;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new int[R][C];

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {

                switch(str.charAt(j)) {
                    case '.' :
                        area[i][j] = 0;
                        break;

                    case '#' :
                        area[i][j] = -1;
                        break;

                    case 'v' :
                        area[i][j] = 1;
                        break;

                    case 'k' :
                        area[i][j] = 2;
                        break;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && area[i][j] != -1) {
                    sumOfWolves = 0;

                    sumOfSheep = 0;

                    bfs(i, j);

                    if (sumOfSheep > sumOfWolves) {
                        survivedSheep += sumOfSheep;
                    } else {
                        survivedWolves += sumOfWolves;
                    }
                }
            }
        }

        System.out.println(survivedSheep + " " + survivedWolves);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (area[x][y] == 1) {
            sumOfWolves++;
        }

        if (area[x][y] == 2) {
            sumOfSheep++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (area[nx][ny] == -1) {
                continue;
            }

            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y) {
        Queue<Pasture> queue = new LinkedList<>();

        queue.add(new Pasture(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pasture current = queue.poll();

            if (area[current.x][current.y] == 1) {
                sumOfWolves++;
            }

            if (area[current.x][current.y] == 2) {
                sumOfSheep++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (area[nx][ny] == -1) {
                    continue;
                }

                queue.add(new Pasture(nx, ny));

                visited[nx][ny] = true;
            }
        }
    }

    static class Pasture {
        int x;
        int y;

        public Pasture(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}