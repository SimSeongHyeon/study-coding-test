import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int minGap = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int[][] stat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stat = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeams(0, 0);

        System.out.println(minGap);
    }

    static void divideTeams(int depth, int pointer) {
        if (depth == N / 2) {
            calculateGap();
            return;
        }

        for (int i = pointer; i < N; i++){
            if (!isVisited[i]) {
                isVisited[i] = true;
                divideTeams(depth + 1,  i + 1);
                isVisited[i] = false;
            }
        }

    }

    static void calculateGap() {
        int teamStar = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    teamStar += stat[i][j];
                    teamStar += stat[j][i];
                } else if (!isVisited[i] && !isVisited[j]) {
                    teamLink += stat[i][j];
                    teamLink += stat[j][i];
                }
            }
        }

        int gap = Math.abs(teamStar - teamLink);

        if (gap == 0) {
            System.out.println(gap);
            System.exit(0);
        }

        minGap = Math.min(minGap, gap);
    }
}