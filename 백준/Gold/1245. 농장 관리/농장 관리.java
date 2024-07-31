import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] farm;
    static boolean[][] isVisitedPeaks;
    static ArrayList<boolean[][]> peaks;

    static void getFarm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean isInFarm(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static boolean[][] isPeaks(int x, int y) {
        boolean[][] isPeaks = new boolean[N][M];
        boolean[][] isVisited = new boolean[N][M];

        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(x, y));

        while (!queue.isEmpty()) {
            Spot current = queue.poll();
            isPeaks[current.x][current.y] = true;

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dr[i];
                int nextY = current.y + dc[i];

                if (!isInFarm(nextX, nextY)) {
                    continue;
                }

                if (farm[nextX][nextY] != farm[current.x][current.y]) {
                    continue;
                }

                if (isVisited[nextX][nextY]) {
                    continue;
                }

                isPeaks[nextX][nextY] = true;
                isVisited[nextX][nextY] = true;
                isVisitedPeaks[nextX][nextY] = true;

                queue.add(new Spot(nextX, nextY));
            }
        }

        return isPeaks;
    }

    static void getPeaks() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisitedPeaks[i][j]) {
                    peaks.add(isPeaks(i, j));
                }
            }
        }
    }

    static int getPeaksCount() {
        int peaksCount = 0;

        for (boolean[][] peak : peaks) {
            boolean isNotPeaks = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (peak[i][j]) {
                        for (int k = 0; k < 8; k++) {
                            int nextX = i + dr[k];
                            int nextY = j + dc[k];

                            if (!isInFarm(nextX, nextY)) {
                                continue;
                            }

                            if (farm[nextX][nextY] > farm[i][j]) {
                                isNotPeaks = true;
                            }
                        }
                    }
                }
            }

            if (!isNotPeaks) {
                peaksCount++;
            }
        }
        return peaksCount;
    }

    public static void main(String[] args) throws IOException {
        int peaksCount = 0;

        getFarm();
        isVisitedPeaks = new boolean[N][M];
        peaks = new ArrayList<>();
        getPeaks();

        peaksCount = getPeaksCount();

        System.out.println(peaksCount);
    }

    static class Spot {
        int x;
        int y;

        Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
