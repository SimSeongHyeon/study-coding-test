import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int area;
    static ArrayList<Integer> areaList = new ArrayList<>();

    static void dfs (int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dfsX = x + dr[i];
            int dfsY = y + dc[i];

            if (dfsX >= 0 && dfsX < N && dfsY >= 0 && dfsY < N && map[dfsX][dfsY] == 1 && !visited[dfsX][dfsY]) {
                dfs(dfsX, dfsY);
                area++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        visited = new boolean[N][N];

        area = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    areaList.add(area);
                    area = 1;
                }
            }
        }

        Collections.sort(areaList);

        StringBuilder sb = new StringBuilder();

        sb.append(areaList.size()).append("\n");

        for (int i : areaList) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}