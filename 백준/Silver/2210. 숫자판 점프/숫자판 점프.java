import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static Set<String> result;
    static int[] selected;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        result = new HashSet<>();
        selected = new int[6];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j);
            }
        }
        System.out.println(result.size());
    }

    static void dfs(int depth, int r, int c) {
        if(depth==6) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++) {
                sb.append(selected[i]);
            }
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = r + dr[i];
            int ny = c + dc[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }

            selected[depth] = map[nx][ny];

            dfs(depth+1, nx, ny);
        }
    }
}