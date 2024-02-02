import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] gameArea;
    static boolean[][] visited;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    static void bfs (int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;

        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] spot = queue.poll();

            if (gameArea[spot[0]][spot[1]] == -1) {
                System.out.println("HaruHaru");

                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextX = spot[0] + dr[i] * gameArea[spot[0]][spot[1]];
                int nextY = spot[1] + dc[i] * gameArea[spot[0]][spot[1]];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;

                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        System.out.println("Hing");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        gameArea = new int[N][N];

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                gameArea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
    }
}