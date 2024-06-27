import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int minChickenDistanceSum;
    static int[][] city;
    static boolean[] isOpened;
    static ArrayList<location> chickenLocations = new ArrayList<>();
    static ArrayList<location> houseLocations = new ArrayList<>();

    static class location {
        int x;
        int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void getCity() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void getChickenLocations() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    houseLocations.add(new location(i, j));
                }

                if (city[i][j] == 2) {
                    chickenLocations.add(new location(i, j));
                }
            }
        }
    }

    static void dfs(int depth, int openedChickensCount) {
        if (openedChickensCount == M) {
            int minDistanceSum = 0;
            for (int i = 0; i < houseLocations.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chickenLocations.size(); j++) {
                    if (isOpened[j]) {
                        int distance = Math.abs(houseLocations.get(i).x - chickenLocations.get(j).x)
                                + Math.abs(houseLocations.get(i).y - chickenLocations.get(j).y);

                        minDistance = Math.min(minDistance, distance);
                    }
                }
                minDistanceSum += minDistance;
            }
            minChickenDistanceSum = Math.min(minChickenDistanceSum, minDistanceSum);
            return;
        }

        for (int i = depth; i < chickenLocations.size(); i++) {
            isOpened[i] = true;

            dfs(i + 1, openedChickensCount + 1);

            isOpened[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        getCity();
        getChickenLocations();

        isOpened = new boolean[chickenLocations.size()];

        minChickenDistanceSum = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(minChickenDistanceSum);
    }
}