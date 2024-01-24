import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] image;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m, count, maxArea,  currentArea;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        image = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        count = 0;

        maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && image[i][j] == 1) {
                    currentArea = 0;
                    count++;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        currentArea++;

        for (int i = 0; i < 4; i++) {
            int dfsX = x + dr[i];
            int dfsY = y + dc[i];

            if (dfsX >= 0 && dfsY >= 0 && dfsX < n && dfsY < m && !visited[dfsX][dfsY] && image[dfsX][dfsY] == 1) {
                dfs(dfsX, dfsY);
            }
        }
    }
}
