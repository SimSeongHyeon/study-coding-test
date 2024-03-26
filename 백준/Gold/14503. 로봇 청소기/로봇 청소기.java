import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;

        dfs(startX, startY, direction);

        System.out.println(count);
    }

    static void dfs(int startX, int startY, int direction) {
        if (room[startX][startY] == 0) {
            room[startX][startY] = -1;

            count++;
        }

        boolean canMove = false;

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;

            int nx = startX + dr[direction];
            int ny = startY + dc[direction];

            if (!isInRoom(nx, ny)) {
                continue;
            }

            if (room[nx][ny] != 0) {
                continue;
            }

            canMove = true;

            dfs(nx, ny, direction);

            break;
        }

        if (!canMove) {
            int back = (direction + 2) % 4;
            int bx = startX + dr[back];
            int by = startY + dc[back];

            if (isInRoom(bx, by) && room[bx][by] != 1) {
                dfs(bx, by, direction);
            }
        }
    }

    static boolean isInRoom(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}