import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] areaInfo;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && areaInfo[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        areaInfo = new int[N][N];

        StringTokenizer st;

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                areaInfo[i][j] = Integer.parseInt(st.nextToken());

                maxHeight = Math.max(areaInfo[i][j], maxHeight);
            }
        }

        int max = 1;

        for (int h = 1; h <= maxHeight; h++) {
            visited = new boolean[N][N];

            int count = 0;

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && areaInfo[i][j] > h) {
                        dfs(i, j, h);

                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);

    }
}