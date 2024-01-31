import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] picture;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, normalCount, colorBlindnessCount;

    static void dfs (int x, int y) {
        visited[x][y] = true;

        int rgb = picture[x][y];

        for (int i = 0; i < 4; i++) {
            int nextX = x + dc[i];
            int nextY = y + dr[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }

            if (!visited[nextX][nextY] && picture[nextX][nextY] == rgb) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        picture = new int[N][N];

        for (int i = 0; i < N; i++) {

            String row = br.readLine();

            for (int j = 0; j < N; j++) {

                //picture[i][j]에 R이면 1, G면 2, B면 3을 저장
                picture[i][j] = switch (row.charAt(j)) {
                    case 'R' -> 1;
                    case 'G' -> 2;
                    case 'B' -> 3;
                    default -> 0;
                };
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    normalCount++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 2) {
                    picture[i][j] = 1;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    colorBlindnessCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindnessCount);
    }
}